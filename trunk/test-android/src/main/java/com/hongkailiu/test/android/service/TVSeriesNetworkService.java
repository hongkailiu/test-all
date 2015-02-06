package com.hongkailiu.test.android.service;

import java.util.List;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.hongkailiu.test.android.db.entity.TVSeries;
import com.hongkailiu.test.android.db.service.TVSeriesService;
import com.hongkailiu.test.android.http.HttpHandler;
import com.hongkailiu.test.android.http.HttpTask;
import com.hongkailiu.test.android.httptask.UpdateTVSeriesHttpTask;
import com.hongkailiu.test.android.json.TVSeriesJsonResult;
import com.hongkailiu.test.android.json.TVSeriesListJsonResult;
import com.hongkailiu.test.android.param.Action;
import com.hongkailiu.test.android.param.Param;
import com.hongkailiu.test.android.parcelable.TestData;

public class TVSeriesNetworkService extends Service {
	
	private boolean isRunning  = false;
	private HttpHandler handler;
	private final static String uri = "http://192.168.0.59:8080/test-webapp/tvseries/all";
	
	@Override
	public void onCreate() {
		handler = new HttpHandler() {
			@Override
			public void handleMessage(Message m) {
				Log.d(Param.LOG_TAG, "handleMessage");
				isRunning  = false;
				Bundle bundle = m.getData();
				if (bundle!=null) {
					TestData data = bundle.getParcelable(HttpTask.DATA_KEY);
					if (data!=null && data.getA()==0) {
						String s = data.getS();
						Log.d(Param.LOG_TAG, "s: " + s);
						// save to database
						if (s!=null) {
							Gson gson = new Gson();
							TVSeriesListJsonResult result = gson.fromJson(s, TVSeriesListJsonResult.class);
							if (result!=null) {
								List<TVSeriesJsonResult> list = result.getList();
								if (list!=null) {
									for (TVSeriesJsonResult tvSeriesJsonResult : list) {
										TVSeries tvSeries = new TVSeries(tvSeriesJsonResult);
										TVSeriesService.getInstance(TVSeriesNetworkService.this).save(tvSeries);
										Intent intent = new Intent();
										intent.setAction(Action.UPDATE_TV_SERIES_UI_ACTION);
										sendBroadcast(intent); 
									}
								}
							}
						}
					}
				}
			}
		};
	}
	
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(Param.LOG_TAG, "Received start id " + startId + ": " + intent);
        if (intent!=null){
        	if (Action.UPDATE_TV_SERIES_ACTION.equals(intent.getAction())) {
        		if (!isRunning) {
	        		// httptask
	        		Log.d(Param.LOG_TAG, "action: " + intent.getAction());
	        		UpdateTVSeriesHttpTask httptask = new UpdateTVSeriesHttpTask(uri, null,null,handler);
	        		httptask.start();
	        		isRunning  = true;
        		} else {
        			Log.d(Param.LOG_TAG, "httptask is running");
        		}
        	}
        }
        // return START_STICKY;
        return super.onStartCommand(intent, flags, startId);
    }

}

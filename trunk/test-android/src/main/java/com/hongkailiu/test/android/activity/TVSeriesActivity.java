package com.hongkailiu.test.android.activity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hongkailiu.test.android.R;
import com.hongkailiu.test.android.db.entity.TVSeries;
import com.hongkailiu.test.android.db.service.TVSeriesService;
import com.hongkailiu.test.android.param.Action;
import com.hongkailiu.test.android.param.Param;
import com.hongkailiu.test.android.service.TVSeriesNetworkService;
import com.hongkailiu.test.android.util.IOUtil;


/**
 * 美剧信息
 * 
 * 
 * 
 * 
 * @author liu
 * 
 */
public class TVSeriesActivity extends Activity implements
		OnClickListener {

	private ListView myListView;
	private ViewAdapter myViewAdapter;
	private MyBroadcastReceiver myBroadcastReceiver;
	
	private List<TVSeries> tvSeriesList;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.d(Param.LOG_TAG, "onCreate: " + this.getClass());
		// 设置无标题窗口
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tv_series);
		init();
		myBroadcastReceiver = new MyBroadcastReceiver();
		this.registerReceiver(myBroadcastReceiver, new IntentFilter(Action.UPDATE_TV_SERIES_UI_ACTION));
	}

	private void init() {

		initTables();

		myViewAdapter = new ViewAdapter();
		myListView = (ListView) findViewById(R.id.listViewTV1);
		myListView.setAdapter(myViewAdapter);
	}

	/**
	 * 初始化数据库
	 * 
	 * 另一个做法是导入文件：书page156
	 */
	private void initTables() {
//		TVSeries ncis = new TVSeries();
//		ncis.setName("ncis");
//		TVSeries friends = new TVSeries();
//		friends.setName("friends");
//		TVSeriesService tvSeriesService = TVSeriesService
//				.getInstance(MyApplication.CONTEXT);
//		tvSeriesService.insert(ncis);
//		tvSeriesService.insert(friends);
	}

	@Override
	public void onClick(View v) {
		Log.d(Param.LOG_TAG , "" + v.getId());
//		switch (v.getId()) {
//		
//
//		case R.id.textViewPUM1:
//			
//			break;
//
//		
//
//		}

	}
	
	@Override
	protected void onStart() {
        super.onStart();
        Intent i = new Intent(this, TVSeriesNetworkService.class);
        i.setAction(Action.UPDATE_TV_SERIES_ACTION);
        startService(i);
    }
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(myBroadcastReceiver);
	}

	private class ViewAdapter extends BaseAdapter {

		LayoutInflater inflater;

		public ViewAdapter() {
			inflater = LayoutInflater.from(TVSeriesActivity.this);
			tvSeriesList = TVSeriesService.getInstance(
					TVSeriesActivity.this).getAllTVSeries();
			if (tvSeriesList==null) {
				tvSeriesList = new ArrayList<TVSeries>();
				Log.d(Param.LOG_TAG, "empty tvSeriesList");
			} else {
				Log.d(Param.LOG_TAG,  "tvSeriesList.size():" + tvSeriesList.size());
			}
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			Holder holder;
			if (convertView == null) {

				holder = new Holder();
				convertView = inflater.inflate(R.layout.tv_item, parent, false);
				holder.poster = (ImageView) convertView
						.findViewById(R.id.imageViewTVItem1);
				holder.name = (TextView) convertView
						.findViewById(R.id.textViewTVItem1);
				holder.onAir = (TextView) convertView
						.findViewById(R.id.textViewTVItem2);
				holder.watched = (TextView) convertView
						.findViewById(R.id.textViewTVItem3);

				convertView.setTag(holder);
			} else {

				holder = (Holder) convertView.getTag();
			}
			
			TVSeries tvSeries = tvSeriesList.get(position);
			String filename = tvSeries.getImageFilename();
			if (!TextUtils.isEmpty(filename)) {
				InputStream is = null;
				try {
					is = new FileInputStream(filename);
					holder.poster.setImageDrawable(Drawable.createFromStream(
							is, "poster"));
				} catch (IOException e) {
					Log.e(Param.LOG_TAG, e.getMessage());
					holder.poster.setImageResource(R.drawable.testicon);
				} finally {
					IOUtil.closeQuietly(is);
				}
				
			} else {
				holder.poster.setImageResource(R.drawable.testicon);
			}
			holder.name.setText(tvSeries.getName());
			holder.onAir.setText("last epi: " + tvSeries.getSeasonOnAir()
					+ "," + tvSeries.getEpisodeOnAir());
			holder.watched.setText("watched epi: " + tvSeries.getSeasonWatched()
					+ "," + tvSeries.getEpisodeWatched());

			// 分布更新
			// myGridAppAdapter.notifyDataSetChanged();
			return convertView;

		}

		@Override
		public final int getCount() {
			return tvSeriesList.size();
		}

		@Override
		public final Object getItem(int position) {
			return position;
		}

		@Override
		public final long getItemId(int position) {
			return position;
		}
	}

	private class Holder {
		ImageView poster;
		TextView name, onAir, watched;
	}
	
	public class MyBroadcastReceiver extends BroadcastReceiver {
		 
		   @Override
		   public void onReceive(Context context, Intent intent) {
			   Log.d(Param.LOG_TAG, "MyBroadcastReceiver: onReceive");
			   if (intent!=null){
				  if (Action.UPDATE_TV_SERIES_UI_ACTION.equals(intent.getAction())){
					  if (myViewAdapter!=null) { 
						  Log.d(Param.LOG_TAG, "MyBroadcastReceiver: notifyDataSetChanged");
						  myViewAdapter.notifyDataSetChanged();
					  }
				  }
			   }
		   }
		}
}

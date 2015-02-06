package com.hongkailiu.test.android.httptask;

import java.io.InputStream;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import com.hongkailiu.test.android.http.HttpHandler;
import com.hongkailiu.test.android.http.HttpTask;
import com.hongkailiu.test.android.param.Param;
import com.hongkailiu.test.android.parcelable.TestData;
import com.hongkailiu.test.android.util.IOUtil;



/**
 * 
 * 
 * @author liu
 *
 */
public class UpdateTVSeriesHttpTask extends HttpTask {


	public UpdateTVSeriesHttpTask(String uri, List<NameValuePair> params,
			Header[] headers, HttpHandler httpHandler) {
		super(uri, params, headers, httpHandler);
		Log.d(Param.LOG_TAG, "UpdateTVSeriesHttpTask ...");

	}


	@Override
	protected void handleHttpResponse(HttpResponse httpResponse)
			throws Exception {
		Log.d(Param.LOG_TAG, "httpRspHandler ...");

		InputStream is = httpResponse.getEntity().getContent();
		String contentStr = IOUtil.inputStream2String(is, "UTF-8");

		Message m = this.httpHandler.obtainMessage();
		Bundle bundle = new Bundle();
		TestData td = new TestData();
		td.setA(0);
		td.setS(contentStr);
		bundle.putParcelable(DATA_KEY, td);
		m.setData(bundle);
		this.httpHandler.sendMessage(m);
	}
}

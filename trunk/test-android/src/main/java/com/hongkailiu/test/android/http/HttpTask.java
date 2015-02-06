package com.hongkailiu.test.android.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import com.hongkailiu.test.android.param.Param;
import com.hongkailiu.test.android.parcelable.TestData;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;



public abstract class HttpTask extends Thread {

	public final static String DATA_KEY = "data";

	private String uri;
	private List<NameValuePair> params;
	private Header[] headers;
	protected HttpHandler httpHandler;

	// private HttpUriRequest request;

	public HttpTask(String uri, List<NameValuePair> params, Header[] headers,
			HttpHandler httpHandler) {
		super();
		this.uri = uri;
		this.params = params;
		this.headers = headers;
		this.httpHandler = httpHandler;
	}

	@Override
	public void run() {

		try {
			DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
			HttpUriRequest request;

			if (params == null) {
				request = new HttpGet(uri);
			} else {
				request = new HttpPost(uri);
				HttpEntity entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
				((HttpPost) request).setEntity(entity);

			}

			if (headers != null) {
				for (int i = 0; i < headers.length; i++) {
					request.addHeader(headers[i]);
				}
			}

			HttpResponse response = defaultHttpClient.execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
			Log.d(Param.LOG_TAG, "statusCode: " + statusCode);
			if (statusCode== HttpStatus.SC_OK) {
				handleHttpResponse(response);
			}
			defaultHttpClient.getConnectionManager().shutdown();
		} catch (UnsupportedEncodingException e) {
			error(e);
			Log.d(Param.LOG_TAG, e.getMessage());
		} catch (ClientProtocolException e) {
			error(e);
			Log.d(Param.LOG_TAG, e.getMessage());
		} catch (IOException e) {
			error(e);
			Log.d(Param.LOG_TAG, e.getMessage());
		} catch (Exception e) {
			error(e);
			Log.d(Param.LOG_TAG, e.getMessage());
		}

	}

	private void error(Exception e) {
		Message m = this.httpHandler.obtainMessage();
		Bundle bundle = new Bundle();
		TestData td = new TestData();
		td.setA(-1);
		td.setS(e.getMessage());
		bundle.putParcelable(DATA_KEY, td);
		m.setData(bundle);
		this.httpHandler.sendMessage(m);
	}

	/**
	 * 处理响应
	 * 
	 * @param httpResponse
	 */
	protected abstract void handleHttpResponse(HttpResponse httpResponse)
			throws Exception;
}

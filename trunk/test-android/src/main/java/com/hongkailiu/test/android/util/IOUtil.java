package com.hongkailiu.test.android.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.hongkailiu.test.android.param.Param;

import android.util.Log;

public class IOUtil {
	public static void closeQuietly(InputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			Log.e(Param.LOG_TAG, e.getMessage());
		}
	}
	public static void closeQuietly(OutputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			Log.e(Param.LOG_TAG, e.getMessage());
		}
	}
	
	public static String inputStream2String(InputStream is, String enc) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(is, enc));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}
}

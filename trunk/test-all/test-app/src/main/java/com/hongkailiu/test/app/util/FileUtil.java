package com.hongkailiu.test.app.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class FileUtil {

	public static byte[] toByteArray(InputStream is) throws IOException {
		return IOUtils.toByteArray(is);
	}

	public static byte[] toByteArray(String filename) throws IOException {
		InputStream is = null;
		try {
			is = new FileInputStream(filename);
			return toByteArray(is);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}
}

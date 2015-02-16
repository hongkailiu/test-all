package com.hongkailiu.test.app.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

public class IOUtil {

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
	
	public static void read(InputStream is) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

	public static void read(String filename) throws IOException {
		FileInputStream fis = new FileInputStream(filename);
		read(fis);
	}

	/**
	 * ref: http://commons.apache.org/proper/commons-io/description.html
	 * 
	 * @throws IOException
	 */
	public static void readCommonIO(File file, String encoding)
			throws IOException {
		LineIterator it = FileUtils.lineIterator(file, encoding);
		try {
			while (it.hasNext()) {
				String line = it.nextLine();
				System.out.println("line: " + line);
			}
		} finally {
			LineIterator.closeQuietly(it);
		}
	}
	
	public static void readCommonIO(String filename, String encoding)
			throws IOException {
		File file = new File(filename);
		readCommonIO(file, encoding);
	}
	
	public static void write(String filename, String encoding, String content)
			throws IOException {
		write(new FileOutputStream(filename), encoding, content);
		
	}
	
	public static void write(OutputStream os, String encoding, String content)
			throws IOException {
		PrintWriter pw
		   = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os, encoding)));
		pw.write(content);
		pw.close();
	}
}

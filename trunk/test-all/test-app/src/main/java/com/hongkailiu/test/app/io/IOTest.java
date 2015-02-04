package com.hongkailiu.test.app.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class IOTest {
	public static void main(String[] args) {
		System.out.println("IOTest.main");
		String filename = "file\\test.dat";
		try {
			System.out.println("read");
			read(filename);
			System.out.println("readCommonIO");
			readCommonIO(filename,"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
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
}

package com.hongkailiu.test.app.hadoop.mr.wordcount;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class WordCountJobTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void test() {
		// windows下执行有权限问题
		// java.io.IOException: Failed to set permissions of path: \tmp\hadoop-Liu\mapred\staging\Liu763817420\.staging to 0700
		try {
			WordCountJob.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

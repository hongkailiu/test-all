package com.hongkailiu.test.app.util;

import org.junit.*;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IOUtilTest {

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
	public void testRead() {
		System.out.println("IOUtilTest: testRead(): begin");
		//String filename = "file\\test.dat";
		String filename = new File("file", "test.dat").getAbsolutePath();
		try {
			File file = new File(filename);
			if (!file.exists()) {
				System.out.println("The file not exists: " + file.getAbsolutePath());
				// return;
			}
			System.out.println("read");
			IOUtil.read(filename);
			System.out.println("readCommonIO");
			IOUtil.readCommonIO(filename, "UTF-8");
		} catch (IOException e) {
			System.out.println("ex message: " + e.getMessage());
			fail("IO exception occurred when reading file: " + filename);
		}
		
		System.out.println("IOUtilTest: testRead(): end");
	}
	
	@Test
	public void testRW() throws IOException {
		System.out.println("IOUtilTest: testRW(): begin");
		System.out.println("user dir: " + SystemUtil.getUserDir());
		File folder = new File("file");
		if (!folder.exists()||!folder.isDirectory()){
			//System.out.println("create folder: " + folder.getAbsolutePath());
			//folder.mkdirs();
			fail("file folder does not exist: " + folder.getAbsolutePath());
		}
		String filename = new File("file", "test.dat").getAbsolutePath();
		//String filename = "file\\test.dat";
		final String content = "abcd";
		final String encoding = "UTF-8";
		
		IOUtil.write(filename, encoding, content);
		String result = new String(IOUtil.toByteArray(filename), encoding);
		assertEquals(content, result);
		
		System.out.println("IOUtilTest: testRW(): end");
	}

}

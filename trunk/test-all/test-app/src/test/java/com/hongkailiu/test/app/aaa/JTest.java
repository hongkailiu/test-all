package com.hongkailiu.test.app.aaa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JTest {

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
	public void test() {
		//fail("Not yet implemented");
		H h1 = new H(3);
		assertEquals(3, h1.getI());
		
		H h2 = new J(6);
		assertEquals(7, h2.getI());
		
		J j1 = new J(6);
		assertEquals(7, j1.getI());
	}

}

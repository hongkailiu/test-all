package com.hongkailiu.test.app.xml.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StaffTest {

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
	public void testEqualsObject() {
		Staff s0 = new Staff();
		s0.setId(1001);
		s0.setFirstname("yong");
		s0.setLastname("mook kim");
		s0.setNickname("mkyong");
		s0.setSalary(100000);

		Staff s1 = new Staff();
		s1.setId(1001);
		s1.setFirstname("yong");
		s1.setLastname("mook kim");
		s1.setNickname("mkyong");
		s1.setSalary(100000);
		
		boolean a = s0.equals(s1);
		assertTrue(a);
		assertEquals(s0,s1);
	}

}

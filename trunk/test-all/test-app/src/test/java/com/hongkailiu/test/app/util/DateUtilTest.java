package com.hongkailiu.test.app.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateUtilTest {

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
	}
	
	@Test
	public void testIsToday() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0); 
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date date = calendar.getTime();
		System.out.println("testIsToday: date: " +  date);
		assertTrue(DateUtil.isToday(date));
		
		calendar.set(Calendar.SECOND, 1);
		date = calendar.getTime();
		System.out.println("testIsToday: date: " +  date);
		assertTrue(DateUtil.isToday(date));
		
		calendar.set(Calendar.HOUR_OF_DAY, 23); 
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		date = calendar.getTime();
		System.out.println("testIsToday: date: " +  date);
		assertTrue(DateUtil.isToday(date));
		
		calendar.set(Calendar.HOUR_OF_DAY, 0); 
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DATE, 1);
		date = calendar.getTime();
		System.out.println("testIsToday: date: " +  date);
		assertFalse(DateUtil.isToday(date));
	}

}

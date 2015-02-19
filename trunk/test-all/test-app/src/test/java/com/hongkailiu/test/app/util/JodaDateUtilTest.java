package com.hongkailiu.test.app.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JodaDateUtilTest {

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
		Date now = new Date();
		System.out.println("now: " +  now);
		DateTime dateTime = JodaDateUtil.dateToDateTime(now);
		System.out.println("dateTime: " +  dateTime);
	}
	
	@Test
	public void testCalendarToDateTime() {
		DateTime dateTime = JodaDateUtil.calendarToDateTime(Calendar.getInstance());
		System.out.println("testCalendarToDateTime: dateTime: " +  dateTime);
		assertNotNull(dateTime);
		
		dateTime = JodaDateUtil.calendarToDateTime(null);
		System.out.println("testCalendarToDateTime: dateTime from null: " +  dateTime);
		assertNotNull(dateTime);
	}
	
	@Test
	public void testDateTimeToCalendar() {
		Calendar calendar = JodaDateUtil.dateTimeToCalendar(new DateTime(), Locale.CANADA);
		System.out.println("testDateTimeToCalendar: calendar: " +  calendar);
		assertNotNull(calendar);
		
		calendar = JodaDateUtil.dateTimeToCalendar(new DateTime(), null);
		System.out.println("testDateTimeToCalendar: calendar from null Locale: " +  calendar);
		assertNotNull(calendar);
		
		calendar = JodaDateUtil.dateTimeToCalendar(null, null);
		System.out.println("testDateTimeToCalendar: calendar from null dateTime: " +  calendar);
		assertNull(calendar);
	}
	
	@Test
	public void testDateToDateTime() {
		DateTime dateTime = JodaDateUtil.dateToDateTime(new Date());
		System.out.println("testDateToDateTime: date: " +  dateTime);
		assertNotNull(dateTime);
		
		dateTime = JodaDateUtil.dateToDateTime(null);
		System.out.println("testDateToDateTime: date from null: " +  dateTime);
		assertNotNull(dateTime);
	}
	
	@Test
	public void testDateTimeToDate() {
		Date date = JodaDateUtil.dateTimeToDate(new DateTime());
		System.out.println("testDateTimeToDate: date: " +  date);
		assertNotNull(date);
		
		date = JodaDateUtil.dateTimeToDate(null);
		System.out.println("testDateTimeToDate: date from null: " +  date);
		assertNull(date);

	}
	
	@Test
	public void testDateToString() {
		Date date = new Date();
		String pattern ="MM/dd/yyyy HH:mm:ss";
		String dateStr = JodaDateUtil.dateToString(date, pattern);
		String expected = DateUtil.dateToString(date, pattern);
		System.out.println("testDateToString: dateStr: " +  dateStr);
		assertEquals(expected, dateStr);
		
		dateStr = JodaDateUtil.dateToString(null, pattern);
		System.out.println("testDateToString: dateStr from null: " +  dateStr);
		assertNotNull(date);

	}
	
	
	@Test
	public void testStringToDate() throws ParseException {
		String pattern ="MM/dd/yyyy HH:mm:ss";
		String dateStr = "02/18/2015 20:23:37";
		Date date = JodaDateUtil.stringToDate(dateStr, pattern);
		Date expected = DateUtil.stringToDate(dateStr, pattern);
		System.out.println("testStringToDate: date: " +  date);
		assertEquals(expected, date);
		
		date = JodaDateUtil.stringToDate(null, pattern);
		System.out.println("testDateToString: dateStr from null: " +  dateStr);
		assertNull(date);

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
		assertTrue(JodaDateUtil.isToday(date));
		
		calendar.set(Calendar.SECOND, 1);
		date = calendar.getTime();
		System.out.println("testIsToday: date: " +  date);
		assertTrue(JodaDateUtil.isToday(date));
		
		calendar.set(Calendar.HOUR_OF_DAY, 23); 
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		date = calendar.getTime();
		System.out.println("testIsToday: date: " +  date);
		assertTrue(JodaDateUtil.isToday(date));
		
		calendar.set(Calendar.HOUR_OF_DAY, 0); 
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DATE, 1);
		date = calendar.getTime();
		System.out.println("testIsToday: date: " +  date);
		assertFalse(JodaDateUtil.isToday(date));
	}
	
	@Test
	public void testGetToday() throws ParseException {

		String todayStr = JodaDateUtil.getToday();
		String expected = DateUtil.getToday();
		System.out.println("testGetToday: todayStr: " +  todayStr);
		assertEquals(expected, todayStr);

	}
	
	@Test
	public void testGetYesterday() throws ParseException {

		String yesterdayStr = JodaDateUtil.getYesterday();
		String expected = DateUtil.getYesterday();
		System.out.println("testGetYesterday: yesterdayStr: " +  yesterdayStr);
		assertEquals(expected, yesterdayStr);

	}
	
	
	@Test
	public void testGetNBeforeToday() throws ParseException {
		int n = 1;
		String dateStr = JodaDateUtil.getNBeforeToday(n);
		String expected = DateUtil.getNBeforeToday(n);
		System.out.println("testGetNBeforeToday: dateStr: " +  dateStr);
		assertEquals(expected, dateStr);

	}
	
	@Test
	public void testGetNAfterDate() throws ParseException {
		int n = 3;
		String d = "20150219";
		String dateStr = JodaDateUtil.getNAfterDate(d,n);
		String expected = DateUtil.getNAfterDate(d,n);
		System.out.println("testGetNAfterDate: dateStr: " +  dateStr);
		assertEquals(expected, dateStr);

	}
	
	@Test
	public void testGetHourOfDay() throws ParseException {
		int hour = JodaDateUtil.getHourOfDay();
		int expected = DateUtil.getHourOfDay();
		System.out.println("testGetHourOfDay: hour: " +  hour);
		assertEquals(expected, hour);

	}
	
	@Test
	public void testGetDayDiff() throws ParseException {
		
		DateTime dt1 = new DateTime(2015, 1, 19, 13, 13, 13, 0);
		DateTime dt2 = new DateTime(2015, 2, 19, 23, 23, 23, 0);
		
		Date d1 = JodaDateUtil.dateTimeToDate(dt1);
		Date d2 = JodaDateUtil.dateTimeToDate(dt2);
		System.out.println("testGetDayDiff: d1: " +  d1);
		System.out.println("testGetDayDiff: d2: " +  d2);
		int expected = 31;
		assertEquals(expected, JodaDateUtil.getDayDiff(d1, d2));
		
		String dateStr1 = JodaDateUtil.dateToString(d1, JodaDateUtil.DATE_PATTERN);
		String dateStr2 = JodaDateUtil.dateToString(d2, JodaDateUtil.DATE_PATTERN);
		System.out.println("testGetDayDiff: dateStr1: " +  dateStr1);
		System.out.println("testGetDayDiff: dateStr2: " +  dateStr2);
		assertEquals(expected, JodaDateUtil.getDayDiff(dateStr1, dateStr2, JodaDateUtil.DATE_PATTERN));

	}
}

package com.hongkailiu.test.app.util;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class JodaDateUtil {

    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_PATTERN = "yyyyMMdd";

    public final static String MIN_PATTERN = "HHmm";
    public final static String HOUR_PATTERN = "HH";

    public static DateTime calendarToDateTime(Calendar calendar) {
        return new DateTime(calendar);
    }

    //Calendar jdkCal = dt.toCalendar(Locale.CHINESE);
    public static Calendar dateTimeToCalendar(DateTime dateTime, Locale locale) {
        return dateTime == null ? null : dateTime.toCalendar(locale);
    }

    public static DateTime dateToDateTime(Date date) {
        return new DateTime(date);
    }

    public static Date dateTimeToDate(DateTime dateTime) {
        return dateTime == null ? null : dateTime.toDate();
    }

    // pattern="MM/dd/yyyy HH:mm:ss"
    public static String dateToString(Date date, String pattern) {
        DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
        return dtf.print(dateToDateTime(date));
    }

    public static Date stringToDate(String dateStr, String pattern) {
        if (dateStr != null) {
            DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
            return dateTimeToDate(dtf.parseDateTime(dateStr));
        } else {
            return null;
        }
    }

    public static boolean isEarlierThan(DateTime dt1, DateTime dt2) {
        return dt1.isBefore(dt2);
    }

    public static boolean isEarlierThan(Date date1, Date date2) {
        return date1.getTime() < date2.getTime();
    }

    public static boolean isToday(Date date) {
        DateTime now = new DateTime();
        DateTime startOfToday = now.withTimeAtStartOfDay();
        DateTime startOfTomorrow = now.plusDays(1).withTimeAtStartOfDay();
        DateTime dateTime = dateToDateTime(date);
        return (startOfToday.isBefore(dateTime) || startOfToday.equals(dateTime)) && dateTime
            .isBefore(startOfTomorrow);

        //		DateTime now = new DateTime();
        //		LocalDate today = now.toLocalDate();
        //		LocalDate tomorrow = today.plusDays(1);
        //
        //		DateTime startOfToday = today.toDateTimeAtStartOfDay(now.getZone());
        //		DateTime startOfTomorrow = tomorrow.toDateTimeAtStartOfDay(now.getZone());
        //
        //		DateTime dateTime = dateToDateTime(date);
        //		return (startOfToday.isBefore(dateTime) || startOfToday.equals(dateTime)) &&  dateTime.isBefore(startOfTomorrow);
    }

    public static String getToday() {
        return getNBeforeToday(0);
    }

    public static String getYesterday() {
        return getNBeforeToday(1);
    }

    public static String getNBeforeToday(int n) {
        DateTime dt = new DateTime();
        dt = dt.minusDays(n);
        return dateToString(dateTimeToDate(dt), DATE_PATTERN);
    }

    public static String getNAfterDate(String startDateStr, int n) {
        DateTime dt = dateToDateTime(stringToDate(startDateStr, DATE_PATTERN));
        dt = dt.plusDays(n);
        return dateToString(dateTimeToDate(dt), DATE_PATTERN);
    }

    public static int getHourOfDay() {
        DateTime dt = new DateTime();
        return dt.getHourOfDay();
    }

    public static Date timestampTODate(Timestamp tt) {
        return new Date(tt.getTime());
    }

    public static String timestampToDateStr(Timestamp tt) {
        return dateToString(timestampTODate(tt), DATE_PATTERN);
    }

    public static int getDayDiff(Date d1, Date d2) {

        DateTime dt1 = dateToDateTime(d1);
        DateTime dt2 = dateToDateTime(d2);
        return Days.daysBetween(dt1.withTimeAtStartOfDay(), dt2.withTimeAtStartOfDay()).getDays();
    }

    public static int getDayDiff(String s1, String s2, String pattern) {
        Date d1 = stringToDate(s1, pattern);
        Date d2 = stringToDate(s2, pattern);
        return getDayDiff(d1, d2);
    }
}

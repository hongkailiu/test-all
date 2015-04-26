package com.hongkailiu.test.app.java8.date;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hongkailiu on 2015-04-26.
 */
public class DateTest {

    @Test public void test1() {
        LocalDate ld1 = LocalDate.of(1985, 7, 13);
        LocalDate ld2 = LocalDate.of(1980, 4, 10);
        LocalDate ld3 = LocalDate.of(1953, 3, 7);

        List<LocalDate> dateList = new ArrayList<>();
        dateList.add(ld1);
        dateList.add(ld2);
        dateList.add(ld3);
        LocalDate[] dates = dateList.toArray(new LocalDate[dateList.size()]);
        Arrays.sort(dates);
        for (int i = 0; i < dates.length; i++) {
            System.out.println("array " + i + ": " + dates[i]);
        }

        for (int i = 0; i < dateList.size(); i++) {
            System.out.println("list " + i + ": " + dateList.get(0));
        }
    }
}

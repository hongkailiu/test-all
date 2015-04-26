package com.hongkailiu.test.app.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CollectionTest {

    @Test public void test01() {
        Set<String> strings = new HashSet<String>();
        strings.add("111");
        List<String> aaa = new ArrayList<String>();
        // add means append
        aaa.add("111");
    }

    @Test public void testListSize() {
        int n = 10;
        List<String> list = new ArrayList<String>(n);
        assertEquals(0, list.size());
        list.add("111");
        assertEquals(1, list.size());

        list.clear();
        for (int i = 0; i < n + 1; i++) {
            list.add("111");
        }
        assertEquals(n + 1, list.size());
    }

    @Test public void testSort() {
        Integer i1 = new Integer(3);
        Integer i2 = new Integer(1);
        Integer i3 = new Integer(2);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(i1);
        integerList.add(i2);
        integerList.add(i3);
        Integer[] integers = integerList.toArray(new Integer[integerList.size()]);
        Arrays.sort(integers);
        for (int i = 0; i < integers.length; i++) {
            System.out.println("array " + i + ": " + integers[i]);
        }

        for (int i = 0; i < integerList.size(); i++) {
            System.out.println("list " + i + ": " + integerList.get(0));
        }
    }

}

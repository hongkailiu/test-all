package com.hongkailiu.test.app.collection;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class MyCollectionUtilTest {

	@Test
	public void test1() {
		List<String> list1 = new ArrayList<String>();
		list1.add("ab");
		list1.add("ac");
		list1.add("ab");
		list1.add("abc");
		List<String> list2 = new ArrayList<String>();
		list2.add("bc");
		list2.add("bcd");
		list2.add("ac");
		list2.add("ab");
		Set<String> result = MyCollectionUtil.getIntersection(list1, list2);
		Set<String> expected = new HashSet<String>();
		expected.add("ac");
		expected.add("ab");
		assertEquals(expected, result);
	}
	
	@Test
	public void test2() {
		List<String> list1 = null;
		List<String> list2 = new ArrayList<String>();
		list2.add("bc");
		list2.add("bcd");
		list2.add("ac");
		list2.add("ab");
		Set<String> result = MyCollectionUtil.getIntersection(list1, list2);
		Set<String> expected = new HashSet<String>();
		assertEquals(expected, result);
	}
	
	@Test
	public void test3() {
		List<String> list1 = new ArrayList<String>();
		list1.add("ab");
		list1.add("ac");
		list1.add("ab");
		list1.add("abc");
		List<String> list2 = new ArrayList<String>();
		Set<String> result = MyCollectionUtil.getIntersection(list1, list2);
		Set<String> expected = new HashSet<String>();
		assertEquals(expected, result);
	}

}

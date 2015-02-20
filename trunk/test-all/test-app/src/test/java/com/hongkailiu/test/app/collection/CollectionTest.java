package com.hongkailiu.test.app.collection;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class CollectionTest {

	@Test
	public void test01() {
		Set<String> strings = new HashSet<String>();
		strings.add("111");
		List<String> aaa = new ArrayList<String>();
		// add means append
		aaa.add("111");
	}
	
	@Test
	public void testListSize() {
		int n = 10;
		List<String> list = new ArrayList<String>(n);
		assertEquals(0, list.size());
		list.add("111");
		assertEquals(1, list.size());
		
		list.clear();
		for (int i=0;i<n + 1;i++){
			list.add("111");
		}
		assertEquals(n+1, list.size());
	}

}

package com.hongkailiu.test.app.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test01();
	}

	private static void test01() {
		Set<String> strings = new HashSet<String>();
		strings.add("111");
		List<String> aaa = new ArrayList<String>();
		// add means append
		aaa.add("111");
	}

}

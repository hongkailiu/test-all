package com.hongkailiu.test.app.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyCollectionUtil {

	
	/**
	 * an interview question in Ericsson
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static Set<String> getIntersection(List<String> list1, List<String> list2){
		Set<String> resultSet = new HashSet<String>();
		if (list1==null||list1.size()==0||list2==null||list2.size()==0) {
			return resultSet;
		}
		// convert list to set because of faster operation "contains" with HashSet
		Set<String> set1 = new HashSet<String>(list1);
		Set<String> set2 = new HashSet<String>(list2);
		for (String s : set1){
			if (set2.contains(s)) {
				resultSet.add(s);
			}
		}
		return resultSet;
	}
}

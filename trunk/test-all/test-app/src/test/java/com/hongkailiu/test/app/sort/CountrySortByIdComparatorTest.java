package com.hongkailiu.test.app.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountrySortByIdComparatorTest {

	List<Country> countries;
	CountrySortByIdComparator countryComparator;

	@Before
	public void setUp() throws Exception {
		countries = new LinkedList<Country>();
		Country c = new Country(3);
		countries.add(c);
		c = new Country(1);
		countries.add(c);
		c = new Country(2);
		countries.add(c);
		countryComparator = new CountrySortByIdComparator();
	}

	@After
	public void tearDown() throws Exception {
		countries.clear();
		countries = null;
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
		Collections.sort(countries, countryComparator);
		Integer[] expectedIntArray = new Integer[] { 1, 2, 3 };
		List<Integer> resultList = new ArrayList<Integer>();
		for (Country c : countries) {
			resultList.add(c.getCountryId());
		}
		Assert.assertArrayEquals(expectedIntArray, resultList.toArray());
	}

}

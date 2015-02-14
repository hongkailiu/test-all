package com.hongkailiu.test.app.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountryTest {

	@Test
	public void testCompareTo() {
		//fail("Not yet implemented");
		Country c1 = new Country(1);
		Country c2 = new Country(2);
		assertTrue(c1.compareTo(c2)<=0);
	}

}

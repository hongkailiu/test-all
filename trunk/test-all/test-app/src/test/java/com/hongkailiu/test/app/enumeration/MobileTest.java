package com.hongkailiu.test.app.enumeration;

import org.junit.Test;

public class MobileTest {

	@Test
	public void testMobile() {
		// fail("Not yet implemented");

		Mobile ret;
		ret = Mobile.valueOf("Samsung");
		System.out.println("Selected : " + ret);
		System.out.println("price : " + ret.showPrice());
		
		ret = Mobile.Motorola;
		System.out.println("Selected : " + ret);
	}

	@Test
	public void testShowPrice() {
		// fail("Not yet implemented");
		System.out.println("CellPhone List:");
		for (Mobile m : Mobile.values()) {
			System.out.println(m + " costs " + m.showPrice() + " dollars");
		}
	}

}

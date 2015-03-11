package com.hongkailiu.test.app.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGSimpleTest {

	@Test
	public void testAdd() {
		System.out.println("=====testng:=====testAdd=================");
		String str = "TestNG is working fine";
		Assert.assertEquals("TestNG is working fine", str);
	}
}

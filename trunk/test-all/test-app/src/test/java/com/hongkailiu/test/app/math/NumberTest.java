package com.hongkailiu.test.app.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberTest {

	@Test
	public void test() {
		int a = Integer.MAX_VALUE;
		int b = 1;
		int c = a + b;
		long m = Integer.MAX_VALUE;
		long n = 1L;
		long k = m+n;		
		System.out.println("a: " + a);
		System.out.println("c: " + c);
		System.out.println("k: " + k);
		System.out.println("assertTrue(Number.add2long(a,b): " + Number.add2long(a,b));
		System.out.println("assertTrue(Number.add2int(a,b): " + Number.add2int(a,b));
		assertTrue(Number.add2long(a,b) == k);
		assertEquals(k, Number.add2long(a,b));
		assertTrue(Number.add2int(a,b) == c);
		assertFalse(k == c);
		
		int x = Integer.MAX_VALUE;
		// 这里的1L非常重要，不能写成1，不然加法的返回值就是个int
		long y = x + 1L;
		System.out.println("y: " + y);
		assertTrue(Number.add2long(a,b) == y);
		
		System.out.println("MAX: " + (Integer.MAX_VALUE));
		System.out.println("MAX + 1: " + (Integer.MAX_VALUE + 1));
		System.out.println("MAX + 2: " + (Integer.MAX_VALUE + 2));
		System.out.println("MAX + 3: " + (Integer.MAX_VALUE + 3));
		System.out.println("MIN: " + (Integer.MIN_VALUE));
		System.out.println("MIN - 1: " + (Integer.MIN_VALUE - 1));
		System.out.println("MIN - 2: " + (Integer.MIN_VALUE - 2));
		System.out.println("MIN - 3: " + (Integer.MIN_VALUE - 3));
	}
	
	@Test
	public void absoluteOfMostNegativeValue() {
	final int mostNegative = Integer.MIN_VALUE;
	// hongkai: 看abs()的注释
	final int negated = Math.abs(mostNegative);
	System.out.println("negated: " + negated);
	assertFalse("No positive equivalent of Integer.MIN_VALUE", negated > 0);
	}

}

package com.wiley.javainterviewsexposed.chapter08;

import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

public class BoxingNullPointer {

	@Test
	public void primitiveNullPointer() {
		final Integer intObject = 42;
		assert (intObject == 42);

		try {
			final int newIntValue = methodWhichMayReturnNull(intObject);
			fail("Assignment of null to primitive should throw NPE");
		} catch (NullPointerException e) {
			// do nothing, test passed
		}
	}

	private Integer methodWhichMayReturnNull(Integer intValue) {
		return null;
	}

	/**
	 * hongkai: more test
	 */
	@Test
	public void myPrimitiveNullPointer() {
		final Integer intObject = 42;
		assert (intObject == 42);

		final int newIntValue = new Integer(3);
		assertEquals(3, newIntValue);
	}
}

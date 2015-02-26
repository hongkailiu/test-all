package com.hongkailiu.test.app.search;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBinarySearchIteration() {
		assertTrue(BinarySearch.binarySearch(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 4));
		assertFalse(BinarySearch.binarySearch(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 14));
	}
	
	@Test
	public void testBinarySearch() {
		assertFalse(BinarySearch.binarySearchIteration(null, 3));
		assertFalse(BinarySearch.binarySearchIteration(Arrays.asList(1), 3));
		assertTrue(BinarySearch.binarySearchIteration(Arrays.asList(3), 3));
		assertTrue(BinarySearch.binarySearchIteration(Arrays.asList(1, 3, 5, 7), 3));
		assertTrue(BinarySearch.binarySearchIteration(Arrays.asList(1, 3), 3));
		assertTrue(BinarySearch.binarySearchIteration(Arrays.asList(3, 5), 3));
		assertFalse(BinarySearch.binarySearchIteration(Arrays.asList(1, 3, 5, 7), 6));
	}

}

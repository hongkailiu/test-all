package com.wiley.javainterviewsexposed.chapter04;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BinarySearch {

	public static boolean binarySearch(final List<Integer> numbers,
			final Integer value) {
		if (numbers.isEmpty()) {
			return false;
		}

		final Integer comparison = numbers.get(numbers.size() / 2);
		if (value.equals(comparison)) {
			return true;
		}

		if (value < comparison) {
			return binarySearch(numbers.subList(0, numbers.size() / 2), value);
		} else {
			return binarySearch(
					numbers.subList(numbers.size() / 2 + 1, numbers.size()),
					value);
		}
	}

	/**
	 * hongkai: implement by iteration
	 * @param numbers
	 * @param value
	 * @return
	 */
	public static boolean binarySearchIteration(final List<Integer> numbers,
			final Integer value) {
		if (numbers == null || numbers.isEmpty()) {
			return false;
		}

		int begin = 0;
		int end = numbers.size()-1;
		
		do {
			int middle = begin + (end - begin) / 2;
			final Integer comparison = numbers.get(middle);
			if (value.equals(comparison)) {
				return true;
			}
			if (value < comparison) {
				end = middle -1;
			} else {
				begin = middle + 1;
			}
		} while (begin <= end);

		return false;
	}

	@Test
	public void testBinarySearchIteration() {
		assertTrue(binarySearch(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 4));
		assertFalse(binarySearch(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 14));
	}
	
	@Test
	public void testBinarySearch() {
		assertFalse(binarySearchIteration(null, 3));
		assertFalse(binarySearchIteration(Arrays.asList(1), 3));
		assertTrue(binarySearchIteration(Arrays.asList(3), 3));
		assertTrue(binarySearchIteration(Arrays.asList(1, 3, 5, 7), 3));
		assertTrue(binarySearchIteration(Arrays.asList(1, 3), 3));
		assertTrue(binarySearchIteration(Arrays.asList(3, 5), 3));
		assertFalse(binarySearchIteration(Arrays.asList(1, 3, 5, 7), 6));
	}
}

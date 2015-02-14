package com.hongkailiu.test.app.search;

import java.util.List;

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

	
}

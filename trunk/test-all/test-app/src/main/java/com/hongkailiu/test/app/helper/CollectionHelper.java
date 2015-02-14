package com.hongkailiu.test.app.helper;

import java.util.List;

public interface CollectionHelper {
	/**
	 * eliminates duplicates and preserves iteration order
	 * 
	 * @param list
	 * @return
	 */
	public <T> List<T> removeDuplicate(List<T> list);

	/**
	 * Returns true if the iterables have the same elements in the same order.
	 * 
	 * @param i1
	 * @param i2
	 * @return
	 */
	public <T> boolean elementsEqual(Iterable<T> i1, Iterable<T> i2);

	/**
	 * Returns true if each element in iterable after the first is greater than
	 * or equal to the element that preceded it, according to this ordering.
	 * Note that this is always true when the iterable has fewer than two
	 * elements.
	 * 
	 * @param iterable
	 * @return
	 */
	public <T> boolean isOrdered(Iterable<? extends Comparable<T>> iterable);
}

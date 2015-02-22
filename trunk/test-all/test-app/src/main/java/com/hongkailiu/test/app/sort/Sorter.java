package com.hongkailiu.test.app.sort;

public interface Sorter<T extends Comparable<T>> {

	public void sort(T[] array);
}

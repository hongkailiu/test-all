package com.hongkailiu.test.app.util;

public class ArrayUtil {

	public static <T> void swapItemsAt(T[] array, int i, int j){
		if (array==null || array.length<2){
			return;
		}
		if (array.length-1<Math.max(i, j)) {
			throw new IllegalArgumentException("array.length -1: " + (array.length -1) + " is smaller than max(i,j)" + Math.max(i, j));
		}
		if (i!=j) {
			T temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
}

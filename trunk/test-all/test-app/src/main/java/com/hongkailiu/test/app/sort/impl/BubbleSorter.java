package com.hongkailiu.test.app.sort.impl;

import com.hongkailiu.test.app.sort.Sorter;

/**
 * ref.
 * http://stackoverflow.com/questions/11072664/how-to-implement-interface-mysortedcollectiont-extends-comparablet
 * 
 * @author Liu
 *
 * @param <T>
 */
public class BubbleSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public void sort(T[] array) {
		if (array==null || array.length<=1){
			return;
		}
		
		for (int i=array.length-1;i>0;i--){
			for (int j=0;j<i-1;j++){
				if (array[j].compareTo(array[j+1])>0){
					swap(array, j, j+1);
				}
			}
		}
	}

	private void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	

}

package com.hongkailiu.test.app.sort.impl;

import java.util.ArrayList;
import java.util.List;

import com.hongkailiu.test.app.heap.Heap;
import com.hongkailiu.test.app.heap.impl.HeapMyImpl;
import com.hongkailiu.test.app.helper.CollectionHelper;
import com.hongkailiu.test.app.helper.CollectionHelperImpl;
import com.hongkailiu.test.app.sort.Sorter;

/**
 * ref.
 * P Lafore 288
 * 
 * @author Liu
 *
 * @param <T>
 */
public class HeapSorter<T extends Comparable<T>> implements Sorter<T> {

	private Heap<T> heap;
	private static CollectionHelper helper = CollectionHelperImpl.getInstance();
	
	@Override
	public void sort(final T[] array) {
		if (array==null || array.length<2){
			return;
		}
		heap = new HeapMyImpl<T>();
		for (T t:array){
			heap.insert(t);
		}
		List<T> list = new ArrayList<T>(array.length);
		for (int i=0;i<array.length;i++){
			list.add(heap.remove());
		}
		list = helper.reverse(list);
		System.arraycopy(list.toArray(), 0, array, 0, array.length);
	}

}

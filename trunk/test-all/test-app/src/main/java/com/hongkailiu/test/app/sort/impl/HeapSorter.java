package com.hongkailiu.test.app.sort.impl;

import com.hongkailiu.test.app.heap.Heap;
import com.hongkailiu.test.app.heap.impl.HeapMyImpl;
import com.hongkailiu.test.app.helper.CollectionHelper;
import com.hongkailiu.test.app.helper.CollectionHelperImpl;
import com.hongkailiu.test.app.sort.Sorter;

import java.util.ArrayList;
import java.util.List;

/**
 * ref.
 * P Lafore 288
 *
 * @param <T>
 * @author Liu
 */
public class HeapSorter<T extends Comparable<T>> implements Sorter<T> {

    private static CollectionHelper helper = CollectionHelperImpl.getInstance();
    private Heap<T> heap;

    @Override public void sort(final T[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        heap = new HeapMyImpl<T>();
        for (T t : array) {
            heap.insert(t);
        }
        List<T> list = new ArrayList<T>(array.length);
        for (int i = 0; i < array.length; i++) {
            list.add(heap.remove());
        }
        list = helper.reverse(list);
        System.arraycopy(list.toArray(), 0, array, 0, array.length);
    }

}

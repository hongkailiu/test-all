package com.hongkailiu.test.app.sort.impl;

import com.hongkailiu.test.app.sort.Sorter;
import com.hongkailiu.test.app.util.ArrayUtil;

/**
 * ref.
 * P Lafore 92
 *
 * @param <T>
 * @author Liu
 */
public class SelectionSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override public void sort(final T[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = array.length - 1; i > 0; i--) {
            int max = i;
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[max]) > 0) {
                    max = j;
                }
            }

            ArrayUtil.swapItemsAt(array, i, max);
        }
    }
}

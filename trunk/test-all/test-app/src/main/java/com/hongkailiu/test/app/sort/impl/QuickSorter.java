package com.hongkailiu.test.app.sort.impl;

import com.hongkailiu.test.app.sort.Sorter;
import com.hongkailiu.test.app.util.ArrayUtil;

/**
 * ref.
 * P Lafore 337
 *
 * @param <T>
 * @author Liu
 */
public class QuickSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override public void sort(final T[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        // hongkai: 使用新的列表将更加简单
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(T[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = left;
        int partition = partition(array, left, right, pivotIndex);
        quickSort(array, left, partition - 1);
        quickSort(array, partition + 1, right);
    }

    private int partition(T[] array, int left, int right, int pivotIndex) {
        int iLeft = left;
        int iRight = right;
        T pivot = array[pivotIndex];

        while (iLeft <= iRight) {
            while (iLeft <= right && array[iLeft].compareTo(pivot) <= 0) {
                iLeft++;
            }
            while (iRight >= left && array[iRight].compareTo(pivot) >= 0) {
                iRight--;
            }
            if (iLeft < iRight) {
                ArrayUtil.swapItemsAt(array, iLeft, iRight);
                iLeft++;
                iRight++;
            }
        }
        ArrayUtil.swapItemsAt(array, pivotIndex, iLeft - 1);
        return iLeft - 1;
    }
}

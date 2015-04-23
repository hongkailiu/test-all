package com.hongkailiu.test.app.sort.impl;

import com.hongkailiu.test.app.sort.Sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ref.
 * P Lafore 288
 *
 * @param <T>
 * @author Liu
 */
public class MergeSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override public void sort(final T[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        List<T> list = Arrays.asList(array);
        list = mergeSort(list);
        System.arraycopy(list.toArray(), 0, array, 0, array.length);
    }

    private List<T> mergeSort(List<T> list) {
        if (list.size() < 2) {
            return list;
        }
        List<T> leftHalf = mergeSort(list.subList(0, list.size() / 2));
        List<T> rightHalf = mergeSort(list.subList(list.size() / 2, list.size()));
        return mergeSortedList(leftHalf, rightHalf);
    }

    private List<T> mergeSortedList(List<T> leftHalf, List<T> rightHalf) {
        List<T> result = new ArrayList<T>(leftHalf.size() + rightHalf.size());
        int iLeft = 0;
        int iRight = 0;
        while (iLeft < leftHalf.size() && iRight < rightHalf.size()) {
            T tleft = leftHalf.get(iLeft);
            T tRight = rightHalf.get(iRight);
            if (tleft.compareTo(tRight) <= 0) {
                result.add(tleft);
                iLeft++;
            } else {
                result.add(tRight);
                iRight++;
            }
        }
        if (iLeft < leftHalf.size()) {
            result.addAll(leftHalf.subList(iLeft, leftHalf.size()));
        }
        if (iRight < rightHalf.size()) {
            result.addAll(rightHalf.subList(iRight, rightHalf.size()));
        }
        return result;
    }



}

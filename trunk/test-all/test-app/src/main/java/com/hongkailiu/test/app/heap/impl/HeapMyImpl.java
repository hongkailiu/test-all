package com.hongkailiu.test.app.heap.impl;

import com.hongkailiu.test.app.heap.Heap;
import com.hongkailiu.test.app.util.ArrayUtil;

import java.util.Arrays;

public class HeapMyImpl<T extends Comparable<T>> implements Heap<T> {

    private Object[] queue = new Object[11];
    //private T[] a = new T[3];

    private int size = 0;

    @Override public boolean insert(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        if (queue.length == size) {
            grow(size + 1);
        }
        queue[size] = t;
        size++;
        bubbleUp();
        return true;
    }

    @SuppressWarnings("unchecked") private void bubbleUp() {
        int i = size - 1;
        do {
            T newT = (T) queue[i];
            int pIndex = i / 2;
            if (newT.compareTo((T) queue[pIndex]) > 0) {
                ArrayUtil.swapItemsAt(queue, i, pIndex);
                i = pIndex;
            } else {
                break;
            }

        } while (true);
    }



    @SuppressWarnings("unchecked") @Override public T remove() {
        T result = null;
        if (size > 0) {
            result = (T) queue[0];
            if (size > 1) {
                ArrayUtil.swapItemsAt(queue, 0, size - 1);
            }
            size--;
            sinkDown();
        }
        return result;
    }

    @SuppressWarnings("unchecked") private void sinkDown() {
        if (size > 0) {
            int i = 0;
            do {
                int lIndex = 2 * i + 1;
                int rIndex = 2 * i + 2;
                if (lIndex < size) {
                    int toSwapIndex = lIndex;
                    if (rIndex < size) {
                        if (((T) queue[toSwapIndex]).compareTo((T) queue[rIndex]) < 0) {
                            toSwapIndex = rIndex;
                        }
                    }
                    if (((T) queue[toSwapIndex]).compareTo((T) queue[i]) > 0) {
                        ArrayUtil.swapItemsAt(queue, i, toSwapIndex);
                    }
                    i = toSwapIndex;
                } else {
                    break;
                }
            } while (true);

        }

    }

    /**
     * cp from Priority Queue
     * Increases the capacity of the array.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = ((oldCapacity < 64) ? ((oldCapacity + 1) * 2) : ((oldCapacity / 2) * 3));
        if (newCapacity < 0) // overflow
            newCapacity = Integer.MAX_VALUE;
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        queue = Arrays.copyOf(queue, newCapacity);
    }
}

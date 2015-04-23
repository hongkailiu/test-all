package com.hongkailiu.test.app.heap;

public interface Heap<T extends Comparable<T>> {

    public boolean insert(T t);

    public T remove();
}

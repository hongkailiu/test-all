package com.hongkailiu.test.app.helper;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.List;

public class CollectionHelperImpl implements CollectionHelper {

    private static volatile CollectionHelperImpl helper;

    private CollectionHelperImpl() {
        super();
    }

    public static CollectionHelper getInstance() {
        CollectionHelperImpl result = helper;
        if (result == null) {
            synchronized (CollectionHelperImpl.class) {
                result = helper;
                if (result == null) {
                    helper = result = new CollectionHelperImpl();
                }
            }
        }
        return result;
    }

    @Override public <T> List<T> removeDuplicate(List<T> list) {
        return ImmutableSet.copyOf(list).asList();
    }

    @Override public <T> boolean elementsEqual(Iterable<T> i1, Iterable<T> i2) {
        return Iterables.elementsEqual(i1, i2);
    }

    @Override public <T> boolean isOrdered(Iterable<? extends Comparable<T>> iterable) {
        return Ordering.natural().isOrdered(iterable);
    }

    @Override public <T> List<T> reverse(List<T> list) {
        return Lists.reverse(list);
    }

}

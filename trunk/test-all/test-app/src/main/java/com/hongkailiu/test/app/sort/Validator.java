package com.hongkailiu.test.app.sort;


/**
 * ref.
 * https://issues.apache.org/jira/browse/LANG-536
 * @author Liu
 *
 * @param <T>
 */
public class Validator<T extends Comparable<T>> {

	public boolean isSorted(T[] a){
		if (a==null || a.length<=1) {
			return true;
		}

        // Otherwise, check that every element is not smaller than the previous
        T previous = a[0];
        for (int i = 1, n = a.length; i < n; i++) {
            final T current = a[i];
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
	}
}

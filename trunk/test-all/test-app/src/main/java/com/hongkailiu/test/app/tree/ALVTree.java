package com.hongkailiu.test.app.tree;

import com.hongkailiu.test.app.helper.CollectionHelper;
import com.hongkailiu.test.app.helper.CollectionHelperImpl;

import java.util.List;

//public class BinarySearchTree<T extends Comparable<T>> {


/**
 * TODO
 *
 * @param <T>
 * @author Liu
 */
public class ALVTree<T extends Comparable<T>> extends BinaryTree<T> {

    private static CollectionHelper helper = CollectionHelperImpl.getInstance();
    private ALVTree<T> left;
    private ALVTree<T> right;

    public ALVTree(T value) {
        super(value);
    }

    public ALVTree(T value, ALVTree<T> left, ALVTree<T> right) {
        super(value, left, right);
        this.left = left;
        this.right = right;
    }

    public ALVTree<T> getLeft() {
        return left;
    }

    public void setLeft(ALVTree<T> left) {
        super.setLeft(left);
        this.left = left;
    }

    public ALVTree<T> getRight() {
        return right;
    }

    public void setRight(ALVTree<T> right) {
        super.setRight(right);
        this.right = right;
    }

    @Override protected void validate() {
        super.validate();
        List<T> list1 = depthFirstTraversalInOrder();
        if (!helper.isOrdered(list1)) {
            throw new IllegalArgumentException("not ordered");
        }
        List<T> list2 = helper.removeDuplicate(list1);
        if (!helper.elementsEqual(list1, list2)) {
            throw new IllegalArgumentException("duplicate elements not allowed");
        }
    }

    @Override public boolean search(final T toFind) {
        if (toFind.equals(value)) {
            return true;
        }

        if (toFind.compareTo(value) < 0 && left != null) {
            return left.search(toFind);
        }

        return right != null && right.search(toFind);
    }

    public void insert(final T toInsert) {
        if (value.equals(toInsert)) {
            // do nothing since no duplicates allowed in BST
        } else if (toInsert.compareTo(value) < 0) {
            if (left == null) {
                setLeft(new ALVTree<T>(toInsert, null, null));
            } else {
                left.insert(toInsert);
            }
        } else {
            if (right == null) {
                setRight(new ALVTree<T>(toInsert, null, null));
            } else {
                right.insert(toInsert);
            }
        }
        validate();
    }

    /**
     * ref.
     * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
     * http://www.algolist.net/Data_structures/Binary_search_tree/Removal
     * hongkai: more to test
     *
     * @param toDelete
     */
    @Override public ALVTree<T> delete(final T toDelete) {
        ALVTree<T> result = this;
        if (toDelete.equals(value)) {
            if (left != null && right != null) {
                ALVTree<T> rightMost = findRightMost(left);
                value = rightMost.value;
                setLeft(left.delete(rightMost.value));
                //return this;
            } else {
                if (left == null) {
                    //return right;
                    result = right;
                } else {
                    //return left;
                    result = left;
                }
            }

        } else if (toDelete.compareTo(value) < 0) {
            if (left == null) {
                //return this;
            } else {
                setLeft(left.delete(toDelete));
                //return this;
            }
        } else {
            if (right == null) {
                //return this;
            } else {
                setRight(right.delete(toDelete));
                //return this;
            }
        }
        validate();
        return result;
    }


    private ALVTree<T> findRightMost(final ALVTree<T> root) {
        if (root == null) {
            return null;
        }
        ALVTree<T> result = root;
        while (result.right != null) {
            result = result.right;
        }
        return result;
    }

}

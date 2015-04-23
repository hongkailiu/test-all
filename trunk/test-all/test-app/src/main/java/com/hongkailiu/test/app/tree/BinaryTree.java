package com.hongkailiu.test.app.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree<E> extends Tree<E> {

    private BinaryTree<E> left;
    private BinaryTree<E> right;

    public BinaryTree(E value) {
        super(value);
        if (this.children == null) {
            this.children = new ArrayList<Tree<E>>(2);
        }
        this.children.add(null);
        this.children.add(null);
        validate();
    }

    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right) {
        super(value);
        this.left = left;
        this.right = right;
        if (this.children == null) {
            this.children = new ArrayList<Tree<E>>(2);
        }
        this.children.add(left);
        this.children.add(right);
        validate();
    }

    @Override public List<Tree<E>> getChildren() {
        throw new IllegalArgumentException("not supported method: use getters of left and right");
    }

    @Override public void setChildren(List<Tree<E>> children) {
        throw new IllegalArgumentException("not supported method: use setters of left and right");
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
        this.children.clear();
        this.children.add(left);
        this.children.add(right);
        validate();
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
        this.children.clear();
        this.children.add(left);
        this.children.add(right);
        validate();
    }

    protected void validate() {
        if (this.children != null) {
            if (this.children.size() != 2) {
                throw new IllegalArgumentException("exact 2 children in binary tree");
            }
            if (this.left != null) {
                left.validate();
            }
            if (this.right != null) {
                right.validate();
            }
        }

    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public List<E> depthFirstTraversalInOrder() {
        List<E> list = new LinkedList<E>();
        if (left != null) {
            list.addAll(left.depthFirstTraversalInOrder());
        }
        list.add(value);
        if (right != null) {
            list.addAll(right.depthFirstTraversalInOrder());
        }
        return list;
    }

}

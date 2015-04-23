package com.hongkailiu.test.app.tree;

import java.util.List;

public class Tree<E> {

    protected E value;
    protected List<Tree<E>> children;

    public Tree(E value, List<Tree<E>> children) {
        this.value = value;
        this.children = children;
    }

    public Tree(E value) {
        this.value = value;
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<E>> children) {
        this.children = children;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }


    /**
     * Hongkai
     * test more: print the tree
     * ref. http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
     */
    public void print() {
        print("", true, "X");
    }

    private void print(String prefix, boolean isTail, String index) {
        System.out
            .println(prefix + (isTail ? ("└─(" + index + ")─ ") : "├─(" + index + ")─ ") + value);

        if (children != null) {
            for (int i = 0; i < children.size() - 1; i++) {
                if (children.get(i) != null)
                    children.get(i).print(prefix + (isTail ? "       " : "│      "), false,
                        Integer.toString(i));
            }
            if (children.size() > 0) {
                if (children.get(children.size() - 1) != null)
                    children.get(children.size() - 1)
                        .print(prefix + (isTail ? "       " : "│      "), true,
                            Integer.toString(children.size() - 1));
            }
        }
    }

    public int getWidth() {
        throw new RuntimeException("not implemented yet");
    }

    public int getdepth() {
        throw new RuntimeException("not implemented yet");
    }

    public boolean isBalanced() {
        throw new RuntimeException("not implemented yet");
    }

    public boolean search(final E toFind) {
        return search(this, toFind);
    }

    private boolean search(final Tree<E> tree, final E toFind) {
        if (tree == null) {
            return false;
        }
        if (toFind.equals(tree.value)) {
            return true;
        }

        if (children != null) {
            for (Tree<E> child : children) {
                if (child != null) {
                    if (child.search(toFind)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public Tree<E> delete(E toDelete) {
        throw new RuntimeException("not implemented yet");
    }
}

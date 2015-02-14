package com.hongkailiu.test.app.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimpleTree<E extends Comparable<E>> {
	// Hongkai: remove private modifier of the fields: allowing access for class in the same package
    E value;
    SimpleTree<E> left;
    SimpleTree<E> right;

    public SimpleTree(E value, SimpleTree<E> left, SimpleTree<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public E getValue() {
        return value;
    }

    public SimpleTree<E> getLeft() {
        return left;
    }

    public SimpleTree<E> getRight() {
        return right;
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
    	 System.out.println(prefix + (isTail ? ("└─(" + index + ")─ ") : "├─(" + index + ")─ ") + value);
    	 final List<SimpleTree<E>> children = new ArrayList<SimpleTree<E>>();
		 children.add(left);
		 children.add(right);
    
         for (int i = 0; i < children.size() - 1; i++) {
        	 if (children.get(i)!=null)
        		 children.get(i).print(prefix + (isTail ? "       " : "│      "), false, Integer.toString(i));
         }
         if (children.size() > 0) {
        	 if (children.get(children.size() - 1)!=null)
        		 children.get(children.size() - 1).print(prefix + (isTail ? "       " : "│      "), true, Integer.toString(children.size()-1));
         }
    }
    
    /**
     * ref. http://en.wikipedia.org/wiki/Tree_traversal
     * Hongkai: test more
     * @return
     */
    public List<E> getValuesInOrder(){
    	List<E> list = new LinkedList<E>();
    	if (left!=null) {
    		list.addAll(left.getValuesInOrder());
    	}
    	list.add(value);
    	if (right!=null){
    		list.addAll(right.getValuesInOrder());
    	}
    	return list;
    }
}

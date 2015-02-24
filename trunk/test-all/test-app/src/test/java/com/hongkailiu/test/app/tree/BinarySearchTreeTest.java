package com.hongkailiu.test.app.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    //private SimpleTree<Integer> root;
    private BinarySearchTree<Integer> root;

    @Before
    public void createSampleTree() {
        final BinarySearchTree<Integer> t1 = new BinarySearchTree<Integer>(1, null, null);
        final BinarySearchTree<Integer> t5 = new BinarySearchTree<Integer>(5, null, null);
        final BinarySearchTree<Integer> t3 = new BinarySearchTree<Integer>(3, t1, t5);
        final BinarySearchTree<Integer> t9 = new BinarySearchTree<Integer>(9, null, null);
        final BinarySearchTree<Integer> t7 = new BinarySearchTree<Integer>(7, t3, t9);
        root = t7;
    }
    
    @Test
    public void validate1() {
    	try{
    		final BinarySearchTree<Integer> t1 = new BinarySearchTree<Integer>(1, null, null);
            final BinarySearchTree<Integer> t5 = new BinarySearchTree<Integer>(5, null, null);
            final BinarySearchTree<Integer> t3 = new BinarySearchTree<Integer>(5, t1, t5);
            final BinarySearchTree<Integer> t9 = new BinarySearchTree<Integer>(9, null, null);
            final BinarySearchTree<Integer> t7 = new BinarySearchTree<Integer>(7, t3, t9);
            root = t7;
    	} catch (IllegalArgumentException e) {
    		// pass
    		return;
    	}
    	
    	fail("should no duplicated value in BST!");
    }
    
    @Test
    public void validate2() {
    	try{
    		final BinarySearchTree<Integer> t1 = new BinarySearchTree<Integer>(1, null, null);
            final BinarySearchTree<Integer> t5 = new BinarySearchTree<Integer>(5, null, null);
            final BinarySearchTree<Integer> t6 = new BinarySearchTree<Integer>(6, t1, t5);
            final BinarySearchTree<Integer> t9 = new BinarySearchTree<Integer>(9, null, null);
            final BinarySearchTree<Integer> t7 = new BinarySearchTree<Integer>(7, t6, t9);
            root = t7;
    	} catch (IllegalArgumentException e) {
    		// pass
    		return;
    	}
    	fail("not ordered value in BST!");
    }

    @Test
    public void search() {
    	root.print();
        assertTrue(root.search(7));
        assertFalse(root.search(70));
    }

    @Test
    public void insert() {
    	System.out.println("=========1===========");
    	root.print();
        root.insert(10);
        System.out.println("=========2===========");
        root.print();
        assertTrue(root.search(10));
        assertEquals(Integer.valueOf(10), root.getRight().getRight().getValue());
        System.out.println("=========3===========");
        root.print();
    }
    
    
    @Test
    public void delete() {
    	System.out.println("=========a===========");
    	root.print();
    	assertTrue(root.search(7));
        root.delete(7);
        assertFalse(root.search(7));
        assertTrue(root.search(3));
    	System.out.println("=========x===========");
        root.print();
        System.out.println("=========b===========");
    }
    
}

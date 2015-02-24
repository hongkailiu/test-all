package com.hongkailiu.test.app.tree.other;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.hongkailiu.test.app.tree.other.BinarySearchTree;
import com.hongkailiu.test.app.tree.other.SimpleTree;

public class BinarySearchTreeTest {

    //private SimpleTree<Integer> root;
    private BinarySearchTree<Integer> root;

    @Before
    public void createSampleTree() {
        final SimpleTree<Integer> t1 = new SimpleTree<Integer>(1, null, null);
        final SimpleTree<Integer> t5 = new SimpleTree<Integer>(5, null, null);
        final SimpleTree<Integer> t3 = new SimpleTree<Integer>(3, t1, t5);
        final SimpleTree<Integer> t9 = new SimpleTree<Integer>(9, null, null);
        final SimpleTree<Integer> t7 = new SimpleTree<Integer>(7, t3, t9);
        root = new BinarySearchTree<Integer>(t7);
    }
    
    @Test
    public void validate1() {
    	
    	final SimpleTree<Integer> t1 = new SimpleTree<Integer>(1, null, null);
        final SimpleTree<Integer> t5 = new SimpleTree<Integer>(5, null, null);
        final SimpleTree<Integer> t3 = new SimpleTree<Integer>(5, t1, t5);
        final SimpleTree<Integer> t9 = new SimpleTree<Integer>(9, null, null);
        final SimpleTree<Integer> t7 = new SimpleTree<Integer>(7, t3, t9);
        
    	try{
    		new BinarySearchTree<Integer>(t7);
    	} catch (IllegalArgumentException e) {
    		// pass
    		return;
    	}
    	
    	fail("should no duplicated value in BST!");
       
       
    }
    
    @Test
    public void validate2() {
    	
    	final SimpleTree<Integer> t1 = new SimpleTree<Integer>(1, null, null);
        final SimpleTree<Integer> t5 = new SimpleTree<Integer>(5, null, null);
        final SimpleTree<Integer> t6 = new SimpleTree<Integer>(6, t1, t5);
        final SimpleTree<Integer> t9 = new SimpleTree<Integer>(9, null, null);
        final SimpleTree<Integer> t7 = new SimpleTree<Integer>(7, t6, t9);
        
    	try{
    		new BinarySearchTree<Integer>(t7);
    	} catch (IllegalArgumentException e) {
    		// pass
    		return;
    	}
    	
    	fail("not ordered value in BST!");
       
       
    }

    @Test
    public void search() {
    	root.getTree().print();
        assertTrue(root.search(7));
        assertFalse(root.search(70));
    }

    @Test
    public void insert() {
        root.insert(10);
        assertTrue(root.search(10));
        assertEquals(Integer.valueOf(10), root.getTree().getRight().getRight().getValue());
        root.getTree().print();
    }
    
    
    @Test
    public void delete() {
    	System.out.println("=========a===========");
    	root.getTree().print();
        root.delete(7);
    	System.out.println("=========x===========");
        root.getTree().print();
        System.out.println("=========b===========");
    }
    
}

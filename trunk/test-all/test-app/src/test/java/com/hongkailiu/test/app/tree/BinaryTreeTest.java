package com.hongkailiu.test.app.tree;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinaryTreeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBinaryTreeE() {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(3);
		bt.print();
		
		bt.setLeft(new BinaryTree<Integer>(1));
		bt.setRight(new BinaryTree<Integer>(2));
		bt.print();
		
		BinaryTree<Integer> right = new BinaryTree<Integer>(8, new BinaryTree<Integer>(6), new BinaryTree<Integer>(7));
		bt.setRight(right);
		bt.print();
	}
}

package com.hongkailiu.test.app.tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TreeTest {

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
	public void testTree() {
		//fail("Not yet implemented");
		Tree<Integer> tree = new Tree<Integer>(3, null);
		assertNotNull(tree);
	}

	@Test
	public void testPrint() {
		//fail("Not yet implemented");
		Tree<Integer> tree = new Tree<Integer>(3, null);
		tree.print();
		
		List<Tree<Integer>> children = new ArrayList<Tree<Integer>>();
		children.add(new Tree<Integer>(2, null));
		children.add(new Tree<Integer>(1, null));
		tree.setChildren(children);
		tree.print();
		
		children = new ArrayList<Tree<Integer>>();
		children.add(new Tree<Integer>(6, null));
		tree.getChildren().get(0).setChildren(children);
		tree.print();
		
		children = tree.getChildren().get(0).getChildren();
		children.add(0, null);
		tree.getChildren().get(0).setChildren(children);
		tree.print();
		
	}
	
	@Test
	public void testPrint2() {
		// 看结果，在有左孩子，没有右孩子的时候，还是不够漂亮
		System.out.println("testPrint2=========1===========");
		Tree<Integer> tree = new Tree<Integer>(3, null);
		tree.print();
		System.out.println("testPrint2=========2===========");
		List<Tree<Integer>> children = new ArrayList<Tree<Integer>>();
		children.add(new Tree<Integer>(2, null));
		children.add(null);
		tree.setChildren(children);
		tree.print();
		System.out.println("testPrint2=========3===========");

		
	}

}

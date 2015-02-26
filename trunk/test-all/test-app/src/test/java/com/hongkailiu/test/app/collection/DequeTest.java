package com.hongkailiu.test.app.collection;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hongkailiu.test.app.graph.Vertex;

public class DequeTest {

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
	public void test1() {
		//fail("Not yet implemented");
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.offer(1);
		assertEquals(1, deque.size());
	}
	
	@Test
	public void test2() {
		//fail("Not yet implemented");
		Deque<Vertex> deque = new ArrayDeque<Vertex>();
		deque.offer(new Vertex("1"));
		assertEquals(1, deque.size());
	}

}

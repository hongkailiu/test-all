package com.hongkailiu.test.app.heap;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hongkailiu.test.app.heap.impl.HeapMyImpl;
import com.hongkailiu.test.app.heap.impl.HeapPQImpl;

public class HeapTest {

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
	public void testHeapPQImpl() {
		Heap<Integer> heap = new HeapPQImpl<Integer>();
		heap.insert(2);
		heap.insert(3);
		heap.insert(1);
		int i = heap.remove();
		assertEquals(3, i);
	}

	@Test
	public void testHeapMyImpl1() {
		Heap<Integer> heap = new HeapMyImpl<Integer>();
		heap.insert(2);
		heap.insert(3);
		heap.insert(1);
		int i = heap.remove();
		assertEquals(3, i);
	}

	@Test
	public void testHeapMyImpl2() {
		Heap<Integer> heap = new HeapMyImpl<Integer>();
		heap.insert(1);
		heap.insert(4);
		heap.insert(2);
		heap.insert(3);
		heap.insert(9);
		heap.insert(7);
		heap.insert(23);
		heap.insert(33);
		heap.insert(8);
		heap.insert(10);
		heap.insert(14);
		heap.insert(16);
		Integer i;
		i = heap.remove();
		assertTrue(i.equals(33));
		i = heap.remove();
		assertTrue(i.equals(23));
		i = heap.remove();
		assertTrue(i.equals(16));
		i = heap.remove();
		assertTrue(i.equals(14));
		i = heap.remove();
		assertTrue(i.equals(10));
		i = heap.remove();
		assertTrue(i.equals(9));
		i = heap.remove();
		assertTrue(i.equals(8));
		i = heap.remove();
		assertTrue(i.equals(7));
		i = heap.remove();
		assertTrue(i.equals(4));
		i = heap.remove();
		assertTrue(i.equals(3));
		i = heap.remove();
		assertTrue(i.equals(2));
		i = heap.remove();
		assertTrue(i.equals(1));
		i = heap.remove();
		assertEquals(null, i);

	}

}

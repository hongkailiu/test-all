package com.hongkailiu.test.app.sort;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.hongkailiu.test.app.sort.impl.BubbleSorter;
import com.hongkailiu.test.app.sort.impl.HeapSorter;
import com.hongkailiu.test.app.sort.impl.InsertionSorter;
import com.hongkailiu.test.app.sort.impl.MergeSorter;
import com.hongkailiu.test.app.sort.impl.QuickSorter;
import com.hongkailiu.test.app.sort.impl.SelectionSorter;

public class SorterTest {
	
	private Set<Integer[]> inputs = new HashSet<Integer[]>();
	private Sorter<Integer> sorter;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Integer[] input = null;
		inputs.add(input);
		input = new Integer[]{};
		inputs.add(input);
		input = new Integer[]{2};
		inputs.add(input);
		input = new Integer[]{2, 1, 3, 5};
		inputs.add(input);
		input = new Integer[]{1, 3, 5, 7};
		inputs.add(input);
		input = new Integer[]{7, 6, 3, 2, 1};
		inputs.add(input);
		input = new Integer[]{1, 7, 6, 3, 2, 1};
		inputs.add(input);
	}

	@After
	public void tearDown() throws Exception {
		inputs.clear();
	}

	@Test
	public void testBubbleSorter() {
		sorter = new BubbleSorter<Integer>();
		testIt();
	}
	
	@Test
	public void testSelectionSorter() {
		sorter = new SelectionSorter<Integer>();
		testIt();
	}
	
	@Test
	public void testInsertionSorter() {
		sorter = new InsertionSorter<Integer>();
		testIt();
	}
	
	@Test
	public void testQuickSorter() {
		sorter = new QuickSorter<Integer>();
		testIt();
	}
	
	@Test
	public void testMergeSorter() {
		sorter = new MergeSorter<Integer>();
		testIt();
	}
	
	@Test
	public void testHeapSorter() {
		sorter = new HeapSorter<Integer>();
		testIt();
	}

	private void testIt() {
		System.out.println("=b=" + sorter.getClass().getName() + "===");
		for (Integer[] input : inputs) {
			boolean nullFlag = false;
			ImmutableList<Integer> immutableList = null;
			if (input==null) {
				nullFlag=true;
			} else {
				immutableList = Ordering.natural().immutableSortedCopy(Arrays.asList(input));
			}
			System.out.println(Arrays.toString(input));
			sorter.sort(input);
			System.out.println(Arrays.toString(input));
			if (nullFlag) {
				Assert.assertNull(input);
			} else {
				// very usefull util from Guava
				// isOrdered check only checks if the input is ordered
				// we need it to be related to the input
				//Assert.assertTrue(Ordering.natural().isOrdered(Arrays.asList(input)));
				Assert.assertArrayEquals(immutableList.toArray(), input);
			}
		}
		System.out.println("=e=" + sorter.getClass().getName() + "===");
		
	}

}

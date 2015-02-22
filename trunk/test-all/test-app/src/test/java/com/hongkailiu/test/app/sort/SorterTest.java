package com.hongkailiu.test.app.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hongkailiu.test.app.sort.impl.BubbleSorter;

public class SorterTest {
	
	private Set<Integer[]> inputs = new HashSet<Integer[]>();
	private Sorter<Integer> sorter;
	private static final Validator<Integer> VALIDATOR = new Validator<Integer>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Integer[] input = null;
		input = new Integer[]{2, 1,3, 5};
		inputs.add(input);
		
	}

	@After
	public void tearDown() throws Exception {
		inputs.clear();
	}

	@Test
	public void testBubbleSorter() {
		sorter = new BubbleSorter<Integer>();
		for (Integer[] input : inputs) {
			System.out.println(Arrays.toString(input));
			sorter.sort(input);
			System.out.println(Arrays.toString(input));
			assertTrue(VALIDATOR.isSorted(input));
		}
	}

}

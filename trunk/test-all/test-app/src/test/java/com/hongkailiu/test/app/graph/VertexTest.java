package com.hongkailiu.test.app.graph;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VertexTest {

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
	public void testHashCode() {
		//fail("Not yet implemented");
		Vertex v1 = new Vertex("1");
		Set<Vertex> set = new HashSet<Vertex>();
		set.add(v1);
		Vertex v2 = new Vertex("1");
		boolean b = set.contains(v2);
		assertTrue(b);
	}

}

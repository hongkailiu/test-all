package com.hongkailiu.test.app.graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GraphTest {

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
	public void testBuilder() {
		Graph graph = new Graph.Builder().addEdge("1", "2").addVertex("3").addEdge("2", "1").addEdge("2", "5").build();
		System.out.println("graph: " + graph);
		assertNotNull(graph);
	}

	@Test
	public void testIsConnected1() {
		Graph graph = new Graph.Builder().addEdge("1", "2").addVertex("3").addEdge("2", "1").addEdge("2", "5").build();
		System.out.println("graph: " + graph);
		Connector c = new DFSConnector();
		graph.setConnector(c);
		assertTrue(graph.isConnected(new Vertex("1"), new Vertex("5")));
	}
	
	@Test
	public void testIsConnected2() {
		Graph graph = new Graph.Builder().addEdge("1", "2").addVertex("3").addEdge("2", "1").addEdge("2", "5").build();
		System.out.println("graph: " + graph);
		Connector c = new DFSConnector();
		graph.setConnector(c);
		assertFalse(graph.isConnected(new Vertex("1"), new Vertex("3")));
	}
	
	@Test
	public void testIsConnected3() {
		System.out.println("===b=====testIsConnected3==========");
		Graph graph = new Graph.Builder().addEdge("1", "2").addVertex("3").addEdge("2", "1").addEdge("2", "5").build();
		System.out.println("graph: " + graph);
		Connector c = new BFSConnector();
		graph.setConnector(c);
		assertTrue(graph.isConnected(new Vertex("1"), new Vertex("5")));
		System.out.println("===e=====testIsConnected3==========");
	}
	
	@Test
	public void testIsConnected4() {
		System.out.println("===b=====testIsConnected4==========");
		Graph graph = new Graph.Builder().addEdge("A", "B").addEdge("A", "C").addEdge("A", "D").addEdge("A", "E").addEdge("B", "F").addEdge("F", "H").addEdge("D", "G").addEdge("G", "I").build();
		System.out.println("graph: " + graph);
		Connector c = new BFSConnector();
		graph.setConnector(c);
		assertTrue(graph.isConnected(new Vertex("A"), new Vertex("I")));
		System.out.println("===e=====testIsConnected4==========");
	}
	
	@Test
	public void testIsConnected5() {
		System.out.println("===b=====testIsConnected5==========");
		Graph graph = new Graph.Builder().addEdge("A", "B").addEdge("A", "C").addEdge("A", "D").addEdge("A", "E").addEdge("B", "F").addEdge("F", "H").addEdge("D", "G").addEdge("G", "I").build();
		System.out.println("graph: " + graph);
		Connector c = new DFSConnector();
		graph.setConnector(c);
		assertTrue(graph.isConnected(new Vertex("A"), new Vertex("I")));
		System.out.println("===e=====testIsConnected5==========");
	}
	
	@Test
	public void testIsConnected6() {
		System.out.println("===b=====testIsConnected6==========");
		Graph graph = new Graph.Builder().addEdge("A", "B").addEdge("A", "C").addEdge("A", "D").addEdge("A", "E").addEdge("B", "F").addEdge("F", "H").addEdge("D", "G").addEdge("G", "I").build();
		System.out.println("graph: " + graph);
		Connector c = new DFSConnector();
		graph.setConnector(c);
		assertFalse(graph.isConnected(new Vertex("B"), new Vertex("I")));
		System.out.println("===e=====testIsConnected6==========");
	}
	
	@Test
	public void testIsConnected7() {
		System.out.println("===b=====testIsConnected7==========");
		Graph graph = new Graph.Builder().addEdge("A", "B").addEdge("A", "C").addEdge("A", "D").addEdge("A", "E").addEdge("B", "F").addEdge("F", "H").addEdge("D", "G").addEdge("G", "I").build();
		System.out.println("graph: " + graph);
		Connector c = new DFSConnector();
		graph.setConnector(c);
		assertFalse(graph.isConnected(new Vertex("B"), new Vertex("I")));
		System.out.println("===e=====testIsConnected7==========");
	}
}

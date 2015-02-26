package com.hongkailiu.test.app.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

public class DFSConnector implements Connector {
	
	Logger logger = Logger.getLogger(this.getClass());

	private Deque<Vertex> stack = new ArrayDeque<Vertex>();
	//private Deque<Vertex> stack = new LinkedList<Vertex>();
	
	private Graph graph;

	@Override
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public DFSConnector(Graph graph) {
		super();
		this.graph = graph;
		this.graph.setConnector(this);
	}
	
	public DFSConnector() {
		super();
	}

	@Override
	public Set<Vertex> getConectedVertices(Vertex vertex) {
		Set<Vertex> set = new HashSet<Vertex>();
		
		stack.clear();
		cleanUpMarkers();
		
		Vertex vTemp = GraphUtil.getVertex(vertex, graph.vertices);
		stack.offer(vTemp);
		
		while (!stack.isEmpty()) {
			Vertex v = stack.pollLast();
			if (!v.isVisted()) {
				v.setVisted(true);
				logger.debug("v: " + v);
				set.add(v);
				Set<Vertex> adSet = graph.getAdjacentList().get(v);
				if (adSet!=null){
					for (Vertex v1 : adSet) {
						if (!v1.isVisted()){
							stack.offer(v1);
						}
					}	
				}
			}
			
		}
		return set;
	}
	
	private void cleanUpMarkers(){
		for (Vertex v : graph.getVertices()){
			v.setVisted(false);
		}
	}

}

package com.hongkailiu.test.app.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class NonDirectedGraph extends Graph {
	
	public final static class Builder{
		private Set<Vertex> vertices = new HashSet<Vertex>();
		private Map<Vertex, Set<Vertex>> adjacentList = new HashMap<Vertex, Set<Vertex>>();
		
		public Builder addVertex(String label){
			GraphUtil.addVertex(label, vertices);
			return this;
		}
		public Builder addEdge(String l1, String l2){
			GraphUtil.addNonDirectedEdge(l1, l2, vertices, adjacentList);
			return this;
		}
		public NonDirectedGraph build(){
			return new NonDirectedGraph(vertices, adjacentList);
		}
	}

	public NonDirectedGraph(Set<Vertex> vertices, Map<Vertex, Set<Vertex>> adjacentList) {
		super(vertices, adjacentList);
	}
	
	@Override
	public void addEdge(String v1Str, String v2Str){
		GraphUtil.addNonDirectedEdge(v1Str, v2Str, vertices, adjacentList);
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	

	/**
	 * a minimum spanning tree of the graph
	 * P Lefore 643
	 * @return
	 */
	public Map<Vertex, Vertex> getAMinimumSpanningTree(){
		throw new RuntimeException("motheod not implemented yet");
	}
}

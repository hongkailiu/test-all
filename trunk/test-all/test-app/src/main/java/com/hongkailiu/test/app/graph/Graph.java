package com.hongkailiu.test.app.graph;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    protected Set<Vertex> vertices;
    protected Map<Vertex, Set<Vertex>> adjacentList;
    private Connector connector;
    public Graph(Set<Vertex> vertices, Map<Vertex, Set<Vertex>> adjacentList) {
        super();
        this.vertices = vertices;
        this.adjacentList = adjacentList;
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public Map<Vertex, Set<Vertex>> getAdjacentList() {
        return adjacentList;
    }

    // private Graph() {
    // super();
    // }

    public void addVertex(String label) {
        GraphUtil.addVertex(label, vertices);
    }

    public void addEdge(String fromLabel, String toLabel) {
        GraphUtil.addEdge(fromLabel, toLabel, vertices, adjacentList);
    }

    @Override public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public boolean isConnected() {
        throw new RuntimeException("motheod not implemented yet");
    }

    public boolean isConnected(Vertex v1, Vertex v2) {
        return connector.getConectedVertices(v1).contains(v2);
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
        this.connector.setGraph(this);
    }

    public boolean isDirected() {
        throw new RuntimeException("motheod not implemented yet");
    }


    public final static class Builder {
        private Set<Vertex> vertices = new HashSet<Vertex>();
        private Map<Vertex, Set<Vertex>> adjacentList = new HashMap<Vertex, Set<Vertex>>();

        public Builder addVertex(String label) {
            GraphUtil.addVertex(label, vertices);
            return this;
        }

        public Builder addEdge(String l1, String l2) {
            GraphUtil.addEdge(l1, l2, vertices, adjacentList);
            return this;
        }

        public Graph build() {
            return new Graph(vertices, adjacentList);
        }
    }
}

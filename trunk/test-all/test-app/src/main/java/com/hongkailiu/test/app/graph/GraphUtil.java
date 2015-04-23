package com.hongkailiu.test.app.graph;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class GraphUtil {

    private static Vertex addVertex(Vertex vertex, Set<Vertex> vertices) {
        if (vertices.contains(vertex)) {
            return getVertex(vertex, vertices);
        }
        vertices.add(vertex);
        return vertex;
    }

    public static Vertex addVertex(String label, Set<Vertex> vertices) {
        Vertex v1 = new Vertex(label);
        return addVertex(v1, vertices);
    }

    public static Vertex getVertex(Vertex vertex, Set<Vertex> vertices) {
        for (Vertex v : vertices) {
            if (vertex.equals(v)) {
                return v;
            }
        }
        throw new RuntimeException("something is wrong");
    }

    //	public static void addNonDirectedEdge(Vertex v1, Vertex v2, Set<Vertex> vertices, Map<Vertex, Set<Vertex>> adjacentList){
    //		addEdge(v1, v2, vertices, adjacentList);
    //		addEdge(v2, v1, vertices, adjacentList);
    //	}

    public static void addNonDirectedEdge(String l1, String l2, Set<Vertex> vertices,
        Map<Vertex, Set<Vertex>> adjacentList) {
        addEdge(l1, l2, vertices, adjacentList);
        addEdge(l2, l1, vertices, adjacentList);
    }

    public static void addEdge(String fromLabel, String toLabel, Set<Vertex> vertices,
        Map<Vertex, Set<Vertex>> adjacentList) {
        Vertex v1 = addVertex(fromLabel, vertices);
        Vertex v2 = addVertex(toLabel, vertices);
        if (adjacentList.get(v1) == null) {
            Set<Vertex> set = new LinkedHashSet<Vertex>();
            adjacentList.put(v1, set);
        }
        adjacentList.get(v1).add(v2);
    }

    //	private static void addEdge(Vertex from, Vertex to, Set<Vertex> vertices, Map<Vertex, Set<Vertex>> adjacentList){
    //		String fromLabel = from.getLabel();
    //		String toLabel = to.getLabel();
    //		addEdge(fromLabel, toLabel, vertices, adjacentList);
    //	}


}

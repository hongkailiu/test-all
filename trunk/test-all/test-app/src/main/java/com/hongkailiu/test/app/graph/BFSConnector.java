package com.hongkailiu.test.app.graph;

import org.apache.log4j.Logger;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * breadth-first searching
 *
 * @author Liu
 */
public class BFSConnector implements Connector {

    static Logger logger = Logger.getLogger(BFSConnector.class);

    private Queue<Vertex> queue = new ArrayDeque<Vertex>();

    private Graph graph;

    public BFSConnector(Graph graph) {
        super();
        this.graph = graph;
        this.graph.setConnector(this);
    }

    public BFSConnector() {
        super();
    }

    @Override public void setGraph(Graph graph) {
        this.graph = graph;
    }

    @Override public Set<Vertex> getConectedVertices(Vertex vertex) {
        Set<Vertex> set = new HashSet<Vertex>();

        queue.clear();
        cleanUpMarkers();

        Vertex vTemp = GraphUtil.getVertex(vertex, graph.vertices);
        queue.offer(vTemp);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            if (!v.isVisted()) {
                v.setVisted(true);
                logger.debug("v: " + v);
                set.add(v);
                Set<Vertex> adSet = graph.getAdjacentList().get(v);
                if (adSet != null) {
                    for (Vertex v1 : adSet) {
                        if (!v1.isVisted()) {
                            queue.offer(v1);
                        }
                    }
                }
            }

        }
        return set;
    }

    private void cleanUpMarkers() {
        for (Vertex v : graph.getVertices()) {
            v.setVisted(false);
        }
    }

}

package com.hongkailiu.test.app.graph;

import java.util.Set;

public interface Connector {

    public Set<Vertex> getConectedVertices(Vertex vertex);

    public void setGraph(Graph graph);
}

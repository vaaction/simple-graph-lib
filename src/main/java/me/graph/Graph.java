package me.graph;

import java.util.Collection;

public interface Graph<T> {
    boolean addVertex(T vertex);
    void addEdge(T fromVertex, T toVertex);
    Collection<T> adjacencyList(T vertex);
}

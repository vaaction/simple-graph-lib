package me.graph;

import java.util.Collection;

public class DirectedGraph<T> extends BaseGraph<T> implements Graph<T> {

    @Override
    public void addEdge(T fromVertex, T toVertex) {
        ensureEdge(fromVertex, toVertex);
        Collection<T> fromVertexAdjacencyList = adjacencyLists.get(fromVertex);
        fromVertexAdjacencyList.add(toVertex);
        adjacencyLists.put(fromVertex, fromVertexAdjacencyList);
    }
}
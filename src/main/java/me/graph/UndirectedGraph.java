package me.graph;

import java.util.Collection;

public class UndirectedGraph<T> extends AbstractGraph<T> implements Graph<T> {

    @Override
    public void addEdge(T fromVertex, T toVertex) {
        Collection<T> fromVertexAdjacencyList = adjacencyLists.get(fromVertex);
        fromVertexAdjacencyList.add(toVertex);
        adjacencyLists.put(fromVertex, fromVertexAdjacencyList);

        Collection<T> toVertexAdjacencyList = adjacencyLists.get(toVertex);
        toVertexAdjacencyList.add(fromVertex);
        adjacencyLists.put(toVertex, toVertexAdjacencyList);
    }
}
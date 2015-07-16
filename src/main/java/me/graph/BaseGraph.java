package me.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public abstract class BaseGraph<T> implements Graph<T> {
    private HashSet<T> vertices = new HashSet<>();
    protected HashMap<T, Collection<T>> adjacencyLists = new HashMap<>();

    @Override
    public boolean addVertex(T vertex) {
        boolean notPresent = vertices.add(vertex);
        if (notPresent) {
            adjacencyLists.put(vertex, new HashSet<>());
        }
        return notPresent;
    }

    @Override
    public Collection<T> adjacencyList(T vertex) {
        return adjacencyLists.get(vertex);
    }

    protected void ensureEdge(T fromVertex, T toVertex) {
        if (!vertices.contains(fromVertex)) {
            throw new IllegalArgumentException("Graph doesn't contain from vertex");
        }
        if (!vertices.contains(toVertex)) {
            throw new IllegalArgumentException("Graph doesn't contain to vertex");
        }
    }
}
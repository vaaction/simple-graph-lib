package me.graph;


import java.util.*;
import java.util.stream.Collectors;

public class DepthFirstPath<T> {
    private Graph<T> graph;
    private T toVertex;
    private T fromVertex;
    private HashSet<T> marked = new HashSet<>();
    private HashMap<T, T> edgeTo = new HashMap<>();

    public DepthFirstPath(Graph<T> graph, T fromVertex, T toVertex) {
        this.graph = graph;
        this.toVertex = toVertex;
        this.fromVertex = fromVertex;
        dfs(fromVertex);
    }

    public Iterator<T> getPath() {
        Stack<T> path = new Stack<>();
        for (T vertex = toVertex; vertex != fromVertex; vertex = edgeTo.get(vertex)) {
            path.push(vertex);
        }
        path.push(fromVertex);
        return path.stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator();
    }

    private void dfs(T vertex) {
        marked.add(vertex);
        for (T adjacencyVertex: graph.adjacencyList(vertex)) {
            if (!marked.contains(adjacencyVertex)) {
                edgeTo.put(adjacencyVertex, vertex);
                if (adjacencyVertex == toVertex) {
                    return;
                }
                else dfs(adjacencyVertex);
            }
        }
    }
}

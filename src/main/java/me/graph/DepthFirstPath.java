package me.graph;


import java.util.*;

public class DepthFirstPath<T> {
    private final Graph<T> graph;
    private final T toVertex;
    private final T fromVertex;
    private final HashSet<T> marked = new HashSet<>();
    private final HashMap<T, T> edgeTo = new HashMap<>();
    private final List<T> path = new ArrayList<>();

    public DepthFirstPath(Graph<T> graph, T fromVertex, T toVertex) {
        this.graph = graph;
        this.toVertex = toVertex;
        this.fromVertex = fromVertex;
        dfs(fromVertex);
    }

    public boolean hasPath() {
        return marked.contains(toVertex);
    }

    public Iterator<T> getPath() {
        if (hasPath()) {
            fillPath();
        }
        return path.iterator();
    }

    private void dfs(T vertex) {
        marked.add(vertex);
        graph.adjacencyList(vertex).stream()
                .filter(adjacencyVertex -> !marked.contains(adjacencyVertex))
                .forEach(adjacencyVertex -> {
                    edgeTo.put(adjacencyVertex, vertex);
                    dfs(adjacencyVertex);
                });
    }

    private void fillPath() {
        for (T vertex = toVertex; vertex != fromVertex; vertex = edgeTo.get(vertex)) {
            path.add(vertex);
        }
        path.add(fromVertex);
        Collections.reverse(path);
    }
}

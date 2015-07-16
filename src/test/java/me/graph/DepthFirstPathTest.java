package me.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class DepthFirstPathTest {
    public static void main(String[] args) {
        Graph<Integer> directedGraph = new DirectedGraph<>();
        Graph<Integer> undirectedGraph = new UndirectedGraph<>();
        List<Graph<Integer>> graphs = Arrays.asList(directedGraph, undirectedGraph);

        for (Graph<Integer> graph: graphs) {
            IntStream.range(1, 13).forEach(graph::addVertex);

            graph.addEdge(1, 2);
            graph.addEdge(2, 3);
            graph.addEdge(3, 4);
            graph.addEdge(3, 6);
            graph.addEdge(5, 3);
            graph.addEdge(6, 5);
            graph.addEdge(6, 7);
            graph.addEdge(7, 8);
            graph.addEdge(8, 6);
            graph.addEdge(6, 9);
            graph.addEdge(10, 4);
            graph.addEdge(11, 12);
        }

        directedGraph = graphs.get(0);
        undirectedGraph = graphs.get(1);
        Iterator<Integer> directedGraphPath = new DepthFirstPath<>(directedGraph, 1, 9).getPath();
        Iterator<Integer> undirectedGraphPath = new DepthFirstPath<>(undirectedGraph, 1, 9).getPath();
        System.out.print("\ndirectedGraph path 1: ");
        directedGraphPath.forEachRemaining(v -> System.out.print(v + " "));
        System.out.print("\nundirectedGraph path 1: ");
        undirectedGraphPath.forEachRemaining(v -> System.out.print(v + " "));

        directedGraphPath = new DepthFirstPath<>(directedGraph, 3, 8).getPath();
        undirectedGraphPath = new DepthFirstPath<>(undirectedGraph, 3, 8).getPath();
        System.out.print("\ndirectedGraph path 2: ");
        directedGraphPath.forEachRemaining(v -> System.out.print(v + " "));
        System.out.print("\nundirectedGraph path 2: ");
        undirectedGraphPath.forEachRemaining(v -> System.out.print(v + " "));

        directedGraphPath = new DepthFirstPath<>(directedGraph, 1, 10).getPath();
        System.out.print("\ndirectedGraph path 3 is empty: " + !directedGraphPath.hasNext());
        undirectedGraphPath = new DepthFirstPath<>(undirectedGraph, 1, 10).getPath();
        System.out.print("\nundirectedGraph path 3: ");
        undirectedGraphPath.forEachRemaining(v -> System.out.print(v + " "));

        directedGraphPath = new DepthFirstPath<>(directedGraph, 5, 11).getPath();
        System.out.print("\ndirectedGraph path 4 is empty: " + !directedGraphPath.hasNext());
        undirectedGraphPath = new DepthFirstPath<>(undirectedGraph, 5, 11).getPath();
        System.out.print("\nundirectedGraph path 4 is empty: " + !undirectedGraphPath.hasNext());

        directedGraphPath = new DepthFirstPath<>(directedGraph, 11, 12).getPath();
        undirectedGraphPath = new DepthFirstPath<>(undirectedGraph, 11, 12).getPath();
        System.out.print("\ndirectedGraph path 5: ");
        directedGraphPath.forEachRemaining(v -> System.out.print(v + " "));
        System.out.print("\nundirectedGraph path 5: ");
        undirectedGraphPath.forEachRemaining(v -> System.out.print(v + " "));
        System.out.print("\n");
    }
}

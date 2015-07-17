package me.graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.IntStream;

public class DepthFirstPathTest {
    public static void main(String[] args) {
        Graph<Integer> directedGraph = new DirectedGraph<>();
        Graph<Integer> undirectedGraph = new UndirectedGraph<>();
        Collection<Graph<Integer>> graphs = Arrays.asList(directedGraph, undirectedGraph);

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

        graphs.forEach(graph -> {
            Iterator<Integer> graphPath = new DepthFirstPath<>(graph, 1, 9).getPath();
            System.out.print("\ngraph path for " + graph + ": ");
            graphPath.forEachRemaining(v -> System.out.print(v + " "));

            graphPath = new DepthFirstPath<>(graph, 3, 8).getPath();
            System.out.print("\ngraph path for " + graph + ": ");
            graphPath.forEachRemaining(v -> System.out.print(v + " "));

            graphPath = new DepthFirstPath<>(graph, 1, 10).getPath();
            System.out.print("\ngraph path for " + graph + ": ");
            graphPath.forEachRemaining(v -> System.out.print(v + " "));

            graphPath = new DepthFirstPath<>(graph, 5, 11).getPath();
            System.out.print("\ngraph path for "+ graph + " is empty: " + !graphPath.hasNext());

            graphPath = new DepthFirstPath<>(graph, 11, 12).getPath();
            System.out.print("\ngraph path for "+ graph + ": ");
            graphPath.forEachRemaining(v -> System.out.print(v + " "));
            System.out.print("\n");
        });
    }
}

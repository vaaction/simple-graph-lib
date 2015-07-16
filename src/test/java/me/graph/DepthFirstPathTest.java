package me.graph;

import java.util.Iterator;
import java.util.stream.IntStream;

public class DepthFirstPathTest {
    public static void main(String[] args) {
        Graph<String> directedGraph = new DirectedGraph<>();
        Graph<String> undirectedGraph = new UndirectedGraph<>();
        Graph<String>[] graphs = new Graph[]{directedGraph, undirectedGraph};

        for (Graph<String> graph: graphs) {
            IntStream.range(1, 11).forEach(i -> graph.addVertex("" + i));

            graph.addEdge("1", "2");
            graph.addEdge("2", "3");
            graph.addEdge("3", "4");
            graph.addEdge("3", "6");
            graph.addEdge("5", "3");
            graph.addEdge("6", "5");
            graph.addEdge("6", "7");
            graph.addEdge("7", "8");
            graph.addEdge("8", "6");
            graph.addEdge("6", "9");
            graph.addEdge("10", "4");
        }

        directedGraph = graphs[0];
        undirectedGraph = graphs[1];
        Iterator<String> directedGraphPath = new DepthFirstPath(directedGraph, "1", "9").getPath();
        Iterator<String> undirectedGraphPath = new DepthFirstPath(undirectedGraph, "1", "9").getPath();
        System.out.println("\ndirectedGraph path 1:");
        directedGraphPath.forEachRemaining(vertex -> System.out.print(vertex + " "));
        System.out.println("\nundirectedGraph path 1:");
        undirectedGraphPath.forEachRemaining(vertex -> System.out.print(vertex + " "));

        directedGraphPath = new DepthFirstPath(directedGraph, "1", "8").getPath();
        undirectedGraphPath = new DepthFirstPath(undirectedGraph, "1", "8").getPath();
        System.out.println("\ndirectedGraph path 2:");
        directedGraphPath.forEachRemaining(vertex -> System.out.print(vertex + " "));
        System.out.println("\nundirectedGraph path 2:");
        undirectedGraphPath.forEachRemaining(vertex -> System.out.print(vertex + " "));

        undirectedGraphPath = new DepthFirstPath(undirectedGraph, "1", "10").getPath();
        System.out.println("\nundirectedGraph path 3:");
        undirectedGraphPath.forEachRemaining(vertex -> System.out.print(vertex + " "));

/*        directedGraphPath = new DepthFirstPath(directedGraph, "1", "10").getPath();
        System.out.println("directedGraph path:");
        directedGraphPath.forEachRemaining(vertex -> System.out.print(vertex + " "));
        System.out.println("\n");*/
    }
}

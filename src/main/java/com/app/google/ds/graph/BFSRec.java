package com.app.google.ds.graph;

import java.util.*;

public class BFSRec {
    private List<List<Integer>> adjList;
    private boolean[] visited;

    private Queue<Integer> queue;

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    private BFSRec(List<Edge> edges, int numVertices) {

        visited = new boolean[numVertices];
        queue = new ArrayDeque<>();

        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjList.get(edge.src).add(edge.dest);
        }
    }

    private void recursiveBFS() {

        if (queue.isEmpty()) {
            return;
        }

        int vertex = queue.poll();
        System.out.print(vertex + " ");

        for (int u : adjList.get(vertex)) {
            if (!visited[u]) {
                visited[u] = true;
                queue.add(u);
            }
        }

        recursiveBFS();

    }


    public static void main(String[] args) {
        // List of graph edges as per the above diagram
//        List<Edge> edges = Arrays.asList(
//                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4), new Edge(2, 5),
//                new Edge(2, 6), new Edge(5, 9), new Edge(5, 10), new Edge(4, 7),
//                new Edge(4, 8), new Edge(7, 11), new Edge(7, 12)
//                // vertex 0, 13, and 14 are single nodes
//        );
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(0, 2), new Edge(1, 3),
                new Edge(1, 4), new Edge(2, 4));

        // total number of nodes in the graph (labelled from 0 to 14)
        int n = 15;

        // build a graph from the given edges
        BFSRec graph = new BFSRec(edges, n);
        graph.queue.add(0);
        graph.recursiveBFS();

        // Perform BFS traversal from all undiscovered nodes to
        // cover all connected components of a graph
//        for (int i = 0; i < n; i++)
//        {
//            if (!graph.visited[i])
//            {
//                // mark the source vertex as discovered
//                graph.visited[i] = true;
//
//                // enqueue source vertex
//                q.add(i);
//
//                // start BFS traversal from vertex `i`
//                graph.recursiveBFS(graph, q, discovered);
//            }
//        }


    }
}



package com.app.google.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFSRec {

    private List<List<Integer>> adjList;
    private boolean[] visited;

    static class Edge {
        int src;
        int dst;

        public Edge(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }
    }

    private DFSRec(List<Edge> edges, int numVertices) {
        visited = new boolean[numVertices];
        adjList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjList.get(edge.src).add(edge.dst);
        }
    }

    private void dfs(int vertex) {

        visited[vertex] = true;

        System.out.print(vertex + " ");

        for (int u : adjList.get(vertex)) {

            if (!visited[u]) {
                dfs(u);
            }
        }
    }

    public static void main(String[] args) {

//        List<Edge> edges = Arrays.asList(
//                // Notice that node 0 is unconnected
//                new Edge(1, 2), new Edge(1, 7), new Edge(1, 8), new Edge(2, 3),
//                new Edge(2, 6), new Edge(3, 4), new Edge(3, 5), new Edge(8, 9),
//                new Edge(8, 12), new Edge(9, 10), new Edge(9, 11)
//        );
        List<Edge> edges = Arrays.asList(
                // Notice that node 0 is unconnected
                new Edge(0, 1), new Edge(0, 2), new Edge(1, 2), new Edge(2, 0),
                new Edge(2, 3), new Edge(3, 3)
        );

        // total number of nodes in the graph (labelled from 0 to 12)
        int n = 4;

        // build a graph from the given edges
        DFSRec graph = new DFSRec(edges, n);

        // Perform DFS traversal from all undiscovered nodes to
        // cover all connected components of a graph
//        for (int i = 0; i < n; i++) {
//            if (!graph.visited[i]) {
//                graph.dfs(i);
//            }
//        }

        graph.dfs(2);
    }
}
package com.app.google.ds.graph;

import java.util.*;

public class BFSIter {
    private List<List<Integer>> adjList;
    private boolean[] visited;

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    private BFSIter(List<Edge> edges, int numVertices) {

        visited = new boolean[numVertices];

        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjList.get(edge.src).add(edge.dest);
        }
    }

    private void bfs(int vertex) {

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(vertex);

        while (!queue.isEmpty()) {

            vertex = queue.poll();

            if (visited[vertex]) {
                continue;
            }

            visited[vertex] = true;

            System.out.print(vertex + " ");

            List<Integer> list = adjList.get(vertex);

            for (int u : list) {
                if (!visited[u]) {
                    queue.add(u);
                }
            }

        }

    }


    public static void main(String[] args) {

        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(0, 2), new Edge(1, 3),
                new Edge(1, 4), new Edge(2, 4));

        int numVertices = 5;

        BFSIter bfsIter = new BFSIter(edges, numVertices);

        bfsIter.bfs(0);

    }
}

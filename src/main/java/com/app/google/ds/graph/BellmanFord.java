package com.app.google.ds.graph;

import java.util.Arrays;

public class BellmanFord {

    private int vertex, edge;

    private Edge[] edges;

    // CreateGraph - it consists of edges
    static class Edge {
        int source, dest, weight;

        public Edge() {
            this.source = this.dest = this.weight = 0;
        }
    }

    // Creates a graph with V vertices and E edges
    public BellmanFord(int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;

        edges = new Edge[edge];

        for (int i = 0; i < edge; i++) {
            edges[i] = new Edge();
        }
    }

    private void bellmanFord(BellmanFord graph, int source) {

        int V = graph.vertex;
        int E = graph.edge;

        int[] dist = new int[V];

        //Step 1: fill the distance array and predecessor array
        Arrays.fill(dist, Integer.MAX_VALUE);

        //MArk the source vertex
        dist[source] = 0;

        // Step 2: relax edges |V| - 1 times
        for (int i = 1; i < V; i++) {

            for (int j = 0; j < E; j++) {

                int u = graph.edges[j].source;
                int v = graph.edges[j].dest;
                int w = graph.edges[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }

            }

            // Step 3: detect negative cycle
            // if value changes then we have a negative cycle in the graph
            // and we cannot find the shortest distances
            for (int j = 0; j < E; j++) {

                int u = graph.edges[j].source;
                int v = graph.edges[j].dest;
                int w = graph.edges[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    System.out.println("Graph contains negative w cycle");
                    return;
                }

                printSolution(dist, V);
            }
        }
    }

    private void printSolution(int[] dist, int V) {
        System.out.println("Vertex distance from source");

        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {

        BellmanFord graph = new BellmanFord(5, 8); // 5 vertices and 8 edges

        // edge 0 --> 1
        graph.edges[0].source = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 5;

        // edge 0 --> 2
        graph.edges[1].source = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 4;

        // edge 1 --> 3
        graph.edges[2].source = 1;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 3;

        // edge 2 --> 1
        graph.edges[3].source = 2;
        graph.edges[3].dest = 1;
        graph.edges[3].weight = 6;

        // edge 3 --> 2
        graph.edges[4].source = 3;
        graph.edges[4].dest = 2;
        graph.edges[4].weight = 2;

        graph.bellmanFord(graph, 0);
    }
}

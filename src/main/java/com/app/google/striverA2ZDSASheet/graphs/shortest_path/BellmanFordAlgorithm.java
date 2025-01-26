package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import java.util.Arrays;

public class BellmanFordAlgorithm {

    public static void main(String[] args) {
        int V = 3, src = 2;
        int[][] edges = {
                {0, 1, 5},
                {1, 0, 3},
                {1, 2, -1},
                {2, 0, 1},
        };

        BellmanFordAlgorithm obj = new BellmanFordAlgorithm();
        System.out.println(Arrays.toString(obj.bellmanFord(V, edges, src)));
    }

    private int[] bellmanFord(int V, int[][] edges, int src) {
        int infy = 100000000;

        int[] shortestPaths = new int[V];
        Arrays.fill(shortestPaths, infy);
        shortestPaths[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                if (shortestPaths[edge[0]] != infy && shortestPaths[edge[0]] + edge[2] < shortestPaths[edge[1]]) {
                    shortestPaths[edge[1]] = shortestPaths[edge[0]] + edge[2];
                }
            }
        }

        for (int[] edge : edges) {
            if (shortestPaths[edge[0]] != infy && shortestPaths[edge[0]] + edge[2] < shortestPaths[edge[1]]) {
                return new int[]{-1};
            }
        }

        return shortestPaths;
    }
}

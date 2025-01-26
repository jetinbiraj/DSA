package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import java.util.*;

public class ShortestPathUG {

    public static void main(String[] args) {

        List<List<Integer>> adj = List.of(
                List.of(1, 3),
                List.of(0, 2),
                List.of(1, 6),
                List.of(0, 4),
                List.of(3, 5),
                List.of(4, 6),
                List.of(2, 5, 7, 8),
                List.of(6, 8),
                List.of(7, 6)
        );

        int src = 0;

        ShortestPathUG obj = new ShortestPathUG();
        System.out.println(Arrays.toString(obj.shortestPath(adj, src)));
    }

    private int[] shortestPath(List<List<Integer>> adj, int src) {
        int n = adj.size();
        int[] distances = new int[n];

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(src);

        int distance = 1;
        distances[src] = -1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentNode = queue.pollFirst();

                for (int node : adj.get(currentNode)) {

                    if (distances[node] == 0) {
                        distances[node] = distance;
                        queue.add(node);
                    }
                }
            }

            distance++;
        }

        for (int i = 0; i < n; i++) {
            if (distances[i] == 0) {
                distances[i] = -1;
            }
        }

        distances[src] = 0;

        return distances;
    }
}

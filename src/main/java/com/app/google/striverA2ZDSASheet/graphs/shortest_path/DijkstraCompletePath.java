package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import java.util.*;

public class DijkstraCompletePath {

    private record Pair(int node, int weight) {

    }

    public static void main(String[] args) {

        int[][] edges = {
                {1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}
        };

        int n = 5, m = 6;

        DijkstraCompletePath obj = new DijkstraCompletePath();
        System.out.println(obj.shortestPath(n, m, edges));
    }

    public List<Integer> shortestPath(int n, int m, int[][] edges) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        int[] parent = new int[n + 1];
        int[] paths = new int[n + 1];
        Arrays.fill(paths, Integer.MAX_VALUE);
        paths[1] = 0;
        parent[1] = -1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {

            Pair entry = pq.poll();

            for (Pair pair : adj.get(entry.node)) {
                int newWeight = entry.weight + pair.weight;

                if (paths[pair.node] > newWeight) {
                    paths[pair.node] = newWeight;
                    parent[pair.node] = entry.node;
                    pq.add(new Pair(pair.node, newWeight));
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (paths[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != -1) {
            path.add(node);
            node = parent[node];
        }

        path.add(1);
        path.add(paths[n]);
        Collections.reverse(path);
        return path;
    }
}

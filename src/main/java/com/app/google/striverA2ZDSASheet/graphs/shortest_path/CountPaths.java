package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import java.util.*;

public class CountPaths {

    private record Pair(int node, long distance) {

    }

    public static void main(String[] args) {
        int[][] roads = {
                {0, 1, 1},
                {1, 2, 4},
                {0, 4, 3},
                {3, 2, 5},
                {3, 4, 1},
                {3, 0, 5},
                {1, 3, 1}
        };
        int n = 5;

        CountPaths obj = new CountPaths();
        System.out.println(obj.countPaths(n, roads));
    }

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.distance));

        long[] dist = new long[n];
        long[] ways = new long[n];
        long mod = (int) (1e9 + 7);

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair entry = pq.poll();

            for (int[] city : adj.get(entry.node)) {

                long currentDist = entry.distance + city[1];

                if (dist[city[0]] == 0 || currentDist < dist[city[0]]) {
                    dist[city[0]] = currentDist;
                    pq.add(new Pair(city[0], currentDist));
                    ways[city[0]] = ways[entry.node];
                } else if (currentDist == dist[city[0]]) {
                    ways[city[0]] += (ways[entry.node] % mod);
                }
            }
        }

        return (int) (ways[n - 1] % mod);
    }
}

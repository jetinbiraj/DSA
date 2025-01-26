package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int n = 4, k = 2;
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};

        NetworkDelayTime obj = new NetworkDelayTime();
        System.out.println(obj.networkDelayTime(times, n, k));
    }

    private int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{k, 0});
        Set<Integer> visitedSet = new HashSet<>();

        int minTime = 0;

        while (!pq.isEmpty()) {
            int[] entry = pq.poll();

            if (visitedSet.contains(entry[0])) {
                continue;
            }

            visitedSet.add(entry[0]);
            minTime = entry[1];

            for (int[] node : adj.get(entry[0])) {
                pq.add(new int[]{node[0], entry[1] + node[1]});
            }
        }

        return visitedSet.size() == n ? minTime : -1;
    }
}

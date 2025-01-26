package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import com.app.google.Pair;

import java.util.*;

public class CheapestFlightsWithKStops {

    public static void main(String[] args) {

        int n = 5, src = 0, dst = 2, k = 2;
        int[][] flights = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};

        CheapestFlightsWithKStops obj = new CheapestFlightsWithKStops();
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
        System.out.println(obj.betterFindCheapestPrice(n, flights, src, dst, k));
    }

    public int betterFindCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair<>(flight[1], flight[2]));
        }

        Deque<int[]> pq = new ArrayDeque<>();
        pq.add(new int[]{0, 0, src}); // {price, k, city}

        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(src, 0);

        int maxFair = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {

            int[] entry = pq.pollFirst();

            if (entry[2] == dst) {
                maxFair = Math.min(entry[0], maxFair);
            } else if (entry[1] > k || (visited.containsKey(entry[2]) && visited.get(entry[2]) < entry[0])) {
                continue;
            }

            visited.put(entry[2], entry[0]);

            for (var city : adj.get(entry[2])) {
                pq.add(new int[]{entry[0] + city.getValue(), entry[1] + 1, city.getKey()});
            }
        }

        return maxFair != Integer.MAX_VALUE ? maxFair : -1;
    }

    private int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<com.app.google.Pair<Integer, Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair<>(flight[1], flight[2]));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));
        pq.add(new int[]{0, 0, src}); // {price, k, city}

        while (!pq.isEmpty()) {

            int[] entry = pq.poll();

            if (entry[2] == dst) {
                return entry[0];
            }

            if (entry[1] > k) {
                continue;
            }

            for (Pair<Integer, Integer> city : adj.get(entry[2])) {
                pq.add(new int[]{entry[0] + city.getValue(), entry[1] + 1, city.getKey()});
            }
        }

        return -1;
    }
}

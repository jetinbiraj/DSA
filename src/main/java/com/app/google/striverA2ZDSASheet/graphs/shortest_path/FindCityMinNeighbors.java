package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import java.util.*;

public class FindCityMinNeighbors {

    public static void main(String[] args) {

        int n = 5, distanceThreshold = 2;
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 8},
                {1, 2, 3},
                {1, 4, 2},
                {2, 3, 1},
                {3, 4, 1},
        };

        FindCityMinNeighbors obj = new FindCityMinNeighbors();
        System.out.println(obj.findTheCity(n, edges, distanceThreshold));
        System.out.println(obj.findCityUsingFloydWarshal(n, edges, distanceThreshold));
    }

    private int findCityUsingFloydWarshal(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][via] == Integer.MAX_VALUE || dist[via][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        int maxNeighbors = Integer.MAX_VALUE;
        int minNeighborCity = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= maxNeighbors) {
                minNeighborCity = i;
                maxNeighbors = count;
            }
        }

        return minNeighborCity;
    }

    private int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] neighbors = new int[n];

        for (int i = 0; i < n; i++) {

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            boolean[] visited = new boolean[n];
            pq.add(new int[]{i, 0});
            int counter = 0;

            while (!pq.isEmpty()) {

                int[] entry = pq.poll();
                if (visited[entry[0]]) {
                    continue;
                }
                visited[entry[0]] = true;
                counter++;

                for (int[] city : adj.get(entry[0])) {

                    int dist = city[1] + entry[1];

                    if (!visited[city[0]] && dist <= distanceThreshold) {
                        pq.add(new int[]{city[0], dist});
                    }
                }

                neighbors[i] = counter;
            }
        }

        int minNeighbors = neighbors[0];
        int minNeighborCity = 0;
        for (int i = 1; i < n; i++) {
            if (neighbors[i] <= minNeighbors) {
                minNeighbors = neighbors[i];
                minNeighborCity = i;
            }
        }

        return minNeighborCity;
    }
}

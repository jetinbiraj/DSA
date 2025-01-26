package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraPQ {

    private record Pair(int node, int distance) {
    }

    public static void main(String[] args) {

        List<List<Pair>> adj = List.of(
                List.of(new Pair(1, 1), new Pair(2, 6)),
                List.of(new Pair(2, 3), new Pair(0, 1)),
                List.of(new Pair(1, 3), new Pair(0, 6))
        );

        int src = 2;

        DijkstraPQ obj = new DijkstraPQ();

        System.out.println(obj.dijkstra(adj, src));
    }

    private List<Integer> dijkstra(List<List<Pair>> adj, int src) {

        ArrayList<Integer> paths = new ArrayList<>();
        int n = adj.size();

        for (int i = 0; i < n; i++) {
            paths.add(Integer.MAX_VALUE);
        }

        paths.set(src, 0);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair currentPair = pq.poll();

            for (Pair pair : adj.get(currentPair.node)) {

                int newDistance = currentPair.distance + pair.distance;

                if (paths.get(pair.node) > newDistance) {
                    paths.set(pair.node, newDistance);
                    pq.add(new Pair(pair.node, newDistance));
                }
            }
        }

        return paths;
    }
}

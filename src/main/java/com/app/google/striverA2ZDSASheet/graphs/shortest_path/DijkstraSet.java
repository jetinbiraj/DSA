package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import java.util.*;

class Pair implements Comparable<Pair> {
    int node;
    int distance;

    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return node == pair.node;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(node);
    }

    @Override
    public int compareTo(Pair other) {
        if (this.distance != other.distance) {
            return Integer.compare(this.distance, other.distance);
        }
        return Integer.compare(this.node, other.node);
    }
}

public class DijkstraSet {

    public static void main(String[] args) {
        List<List<Pair>> adj = List.of(
                List.of(new Pair(1, 4), new Pair(2, 4)),
                List.of(new Pair(0, 4), new Pair(2, 2)),
                List.of(new Pair(1, 2), new Pair(0, 4), new Pair(3, 3), new Pair(4, 1), new Pair(5, 6)),
                List.of(new Pair(2, 3), new Pair(5, 2)),
                List.of(new Pair(2, 1), new Pair(5, 3)),
                List.of(new Pair(3, 2), new Pair(4, 3), new Pair(2, 6))
        );

        int src = 0;

        DijkstraSet obj = new DijkstraSet();
        System.out.println(obj.dijkstra(adj, src));
    }

    private List<Integer> dijkstra(List<List<Pair>> adj, int src) {

        ArrayList<Integer> paths = new ArrayList<>();
        int n = adj.size();

        for (int i = 0; i < n; i++) {
            paths.add(Integer.MAX_VALUE);
        }

        paths.set(src, 0);
        TreeSet<Pair> treeSet = new TreeSet<>();

        treeSet.add(new Pair(src, 0));

        while (!treeSet.isEmpty()) {

            Pair currentPair = treeSet.removeFirst();

            for (Pair pair : adj.get(currentPair.node)) {

                int newDistance = currentPair.distance + pair.distance;

                if (paths.get(pair.node) > newDistance) {
                    paths.set(pair.node, newDistance);
                    treeSet.add(new Pair(pair.node, newDistance));
                }
            }
        }

        return paths;
    }
}

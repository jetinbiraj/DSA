package com.app.google.striverA2ZDSASheet.graphs.min_spanning_tree_and_disjoint_set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {

    private record Edge(int src, int dest, int weight) {

    }

    public static void main(String[] args) {

        int V = 3, E = 3;

        List<List<int[]>> adj = List.of(
                List.of(new int[]{1, 5}, new int[]{2, 1}),
                List.of(new int[]{0, 5}, new int[]{2, 3}),
                List.of(new int[]{1, 3}, new int[]{0, 1})
        );

        KruskalsAlgorithm obj = new KruskalsAlgorithm();
        System.out.println(obj.spanningTree(V, E, adj));

    }

    private int spanningTree(int V, int E, List<List<int[]>> adj) {

        List<Edge> edges = new ArrayList<>(adj.size());

        for (int i = 0; i < V; i++) {
            for (int[] set : adj.get(i)) {
                edges.add(new Edge(i, set[0], set[1]));
            }
        }

        DisjointSetBySize ds = new DisjointSetBySize(V);

        edges.sort(Comparator.comparingInt(e -> e.weight));
        int mstWeight = 0;

        for (Edge edge : edges) {

            if (ds.findUltimateParent(edge.src) != ds.findUltimateParent(edge.dest)) {
                mstWeight += edge.weight;
                ds.unionBySize(edge.src, edge.dest);
            }
        }

        return mstWeight;
    }
}

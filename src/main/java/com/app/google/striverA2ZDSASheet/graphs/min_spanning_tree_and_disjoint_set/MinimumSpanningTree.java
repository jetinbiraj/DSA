package com.app.google.striverA2ZDSASheet.graphs.min_spanning_tree_and_disjoint_set;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    public static void main(String[] args) {

        int V = 3, E = 3;

        List<List<int[]>> adj = List.of(
                List.of(new int[]{1, 5}, new int[]{2, 1}),
                List.of(new int[]{0, 5}, new int[]{2, 3}),
                List.of(new int[]{1, 3}, new int[]{0, 1})
        );

        MinimumSpanningTree obj = new MinimumSpanningTree();
        System.out.println(obj.spanningTree(V, E, adj));
    }

    private int spanningTree(int V, int E, List<List<int[]>> adj) {

        int mstWeight = 0;

        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {

            int[] entry = pq.poll();
            if (visited[entry[0]]) {
                continue;
            }

            visited[entry[0]] = true;
            mstWeight += entry[1];
            pq.addAll(adj.get(entry[0]));
        }

        return mstWeight;
    }
}

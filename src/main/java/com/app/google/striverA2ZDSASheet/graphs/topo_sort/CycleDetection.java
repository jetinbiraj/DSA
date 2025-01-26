package com.app.google.striverA2ZDSASheet.graphs.topo_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CycleDetection {

    public static void main(String[] args) {

        List<List<Integer>> adj = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(3)
        );

        CycleDetection obj = new CycleDetection();

        System.out.println(obj.isCyclic(adj.size(), adj));
    }

    private boolean isCyclic(int V, List<List<Integer>> adj) {

        int vertices = adj.size();
        int[] inDegree = new int[vertices];

        for (List<Integer> integers : adj) {
            for (int node : integers) {
                inDegree[node]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int entry = queue.pollFirst();

            topo.add(entry);

            for (int node : adj.get(entry)) {
                inDegree[node]--;
                if (inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        return topo.size() < V;
    }
}

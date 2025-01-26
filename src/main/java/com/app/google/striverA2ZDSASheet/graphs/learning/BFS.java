package com.app.google.striverA2ZDSASheet.graphs.learning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BFS {

    public static void main(String[] args) {

        int v = 5;
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(2, 3, 1)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(0, 4)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(2)));

        System.out.println(bfsOfGraph(v, adj));
    }

    private static List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        Deque<Integer> queue = new ArrayDeque<>();

        List<Integer> bfs = new ArrayList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int currentNode = queue.pollFirst();
            bfs.add(currentNode);

            for (int node : adj.get(currentNode)) {
                if (!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }

        return bfs;
    }
}

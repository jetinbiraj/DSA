package com.app.google.striverA2ZDSASheet.graphs.learning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DFS {

    public static void main(String[] args) {
        int v = 5;
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(2, 3, 1)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(0, 4)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(2)));

        System.out.println(iterativeDfsOfGraph(adj));
        System.out.println(recursiveDfsOfGraph(adj));
    }

    private static List<Integer> recursiveDfsOfGraph(List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        dfs(adj, 0, dfs, new boolean[adj.size()]);
        return dfs;
    }

    private static void dfs(List<List<Integer>> adj, int currentNode, List<Integer> dfs, boolean[] visited) {

        visited[currentNode] = true;
        dfs.add(currentNode);

        for (int node : adj.get(currentNode)) {
            if (!visited[node]) {
                dfs(adj, node, dfs, visited);
            }
        }
    }

    private static List<Integer> iterativeDfsOfGraph(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Deque<Integer> queue = new ArrayDeque<>();

        List<Integer> dfs = new ArrayList<>();
        queue.add(0);

        while (!queue.isEmpty()) {

            int currentNode = queue.pollLast();

            if (visited[currentNode]) {
                continue;
            }

            visited[currentNode] = true;
            dfs.add(currentNode);

            for (int i = adj.get(currentNode).size() - 1; i >= 0; i--) {
                int node = adj.get(currentNode).get(i);
                if (!visited[node]) {
                    queue.add(node);
                }
            }
        }

        return dfs;
    }
}

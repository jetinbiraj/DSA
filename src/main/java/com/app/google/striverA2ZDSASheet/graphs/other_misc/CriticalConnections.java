package com.app.google.striverA2ZDSASheet.graphs.other_misc;

import java.util.ArrayList;
import java.util.List;

public class CriticalConnections {

    private int timer = 0;

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = List.of(
                List.of(0, 1),
                List.of(1, 2),
                List.of(2, 0),
                List.of(1, 3)
        );

        CriticalConnections obj = new CriticalConnections();
        System.out.println(obj.criticalConnections(n, connections));
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> connection : connections) {
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }

        List<List<Integer>> bridges = new ArrayList<>();
        dfs(adj, new boolean[n], new int[n], new int[n], 0, -1, bridges);
        return bridges;
    }


    private void dfs(List<List<Integer>> adj, boolean[] visited, int[] time, int[] low, int currentNode, int parent, List<List<Integer>> bridges) {

        visited[currentNode] = true;
        time[currentNode] = low[currentNode] = timer++;

        for (int node : adj.get(currentNode)) {

            if (node == parent) {
                continue;
            }

            if (!visited[node]) {

                dfs(adj, visited, time, low, node, currentNode, bridges);
                if (low[node] > time[currentNode]) {
                    bridges.add(List.of(currentNode, node));
                }
            }

            low[currentNode] = Math.min(low[currentNode], low[node]);
        }
    }
}

package com.app.google.striverA2ZDSASheet.graphs.other_misc;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ArticulationPointI {

    private int timer = 0;

    public static void main(String[] args) {

        List<List<Integer>> adj = List.of(
                List.of(1),
                List.of(0, 4),
                List.of(3, 4),
                List.of(2, 4),
                List.of(1, 2, 3)
        );

        int v = 5;

        ArticulationPointI obj = new ArticulationPointI();
        System.out.println(obj.articulationPoints(v, adj));
    }

    private List<Integer> articulationPoints(int V, List<List<Integer>> adj) {
        TreeSet<Integer> vertices = new TreeSet<>();

        boolean[] visited = new boolean[V];
        int[] time = new int[V];
        int[] low = new int[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                dfs(adj, -1, i, time, low, visited, vertices);
            }
        }

        return vertices.isEmpty() ? List.of(-1) : new ArrayList<>(vertices);
    }

    private void dfs(List<List<Integer>> adj, int parent, int currentNode, int[] time, int[] low, boolean[] visited, TreeSet<Integer> vertices) {
        visited[currentNode] = true;

        time[currentNode] = low[currentNode] = timer++;

        int child = 0;

        for (int node : adj.get(currentNode)) {

            if (node == parent) {
                continue;
            }

            if (!visited[node]) {

                dfs(adj, currentNode, node, time, low, visited, vertices);

                low[currentNode] = Math.min(low[currentNode], low[node]);

                if (low[node] >= time[currentNode] && parent != -1) {
                    vertices.add(currentNode);
                }

                child++;
            } else {
                low[currentNode] = Math.min(low[currentNode], time[node]);
            }

            if (parent == -1 && child > 1) {
                vertices.add(currentNode);
            }
        }
    }
}

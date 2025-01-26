package com.app.google.striverA2ZDSASheet.graphs.min_spanning_tree_and_disjoint_set;

import java.util.ArrayList;
import java.util.List;

public class ConnectedNetwork {

    public static void main(String[] args) {

        int n = 6;
        int[][] connections = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3},
        };

        ConnectedNetwork obj = new ConnectedNetwork();
        System.out.println(obj.makeConnected(n, connections));
        System.out.println(obj.makeConnectedUsingDisjointSet(n, connections));
    }

    private int makeConnectedUsingDisjointSet(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n], size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int components = n;

        for (int[] c : connections) {
            int p1 = findParent(parent, c[0]);
            int p2 = findParent(parent, c[1]);

            if (p1 != p2) {
                if (size[p1] < size[p2]) {
                    size[p2] += size[p1];
                    parent[p1] = p2;
                } else {
                    size[p1] += size[p2];
                    parent[p2] = p1;
                }
                components--;
            }
        }
        return components - 1;
    }

    private int findParent(int[] parent, int i) {
        if (i == parent[i]) return i;
        return parent[i] = findParent(parent, parent[i]);
    }

    private int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(connection[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, visited, adj);
            }
        }

        return components - 1;
    }

    private void dfs(int currentNode, boolean[] visited, List<List<Integer>> adj) {
        visited[currentNode] = true;

        for (int node : adj.get(currentNode)) {
            if (!visited[node]) {
                dfs(node, visited, adj);
            }
        }
    }
}

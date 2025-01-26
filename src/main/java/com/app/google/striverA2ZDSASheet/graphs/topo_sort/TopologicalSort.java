package com.app.google.striverA2ZDSASheet.graphs.topo_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalSort {

    public static void main(String[] args) {

        List<List<Integer>> adj = List.of(
                List.of(),
                List.of(3),
                List.of(3),
                List.of(),
                List.of(0, 1),
                List.of(0, 2)
        );

        TopologicalSort obj = new TopologicalSort();
        System.out.println(obj.topologicalSort(adj));
    }

    private List<Integer> topologicalSort(List<List<Integer>> adj) {

        Deque<Integer> stack = new ArrayDeque<>();
        int nodes = adj.size();

        boolean[] visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                dfs(adj, stack, visited, i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!stack.isEmpty()) {
            topo.add(stack.pop());
        }

        return topo;
    }

    private void dfs(List<List<Integer>> adj, Deque<Integer> stack, boolean[] visited, int currentNode) {
        visited[currentNode] = true;

        for (int node : adj.get(currentNode)) {
            if (!visited[node]) {
                dfs(adj, stack, visited, node);
            }
        }

        stack.push(currentNode);
    }
}

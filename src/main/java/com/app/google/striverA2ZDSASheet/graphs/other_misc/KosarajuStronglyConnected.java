package com.app.google.striverA2ZDSASheet.graphs.other_misc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class KosarajuStronglyConnected {

    public static void main(String[] args) {
        List<List<Integer>> adj = List.of(
                List.of(2, 3),
                List.of(0),
                List.of(1),
                List.of(4),
                List.of()
        );

        KosarajuStronglyConnected obj = new KosarajuStronglyConnected();
        System.out.println(obj.kosaraju(adj));
    }

    private int kosaraju(List<List<Integer>> adj) {

        int n = adj.size();

        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs1(adj, i, visited, stack, true);
            }
        }

        List<List<Integer>> adjT = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            adjT.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int node : adj.get(i)) {
                adjT.get(node).add(i);
            }
        }

        int scc = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                scc++;
                dfs1(adjT, node, visited, stack, false);
            }
        }

        return scc;
    }

    private void dfs1(List<List<Integer>> adj, int currentNode, boolean[] visited, Deque<Integer> stack, boolean isStack) {
        visited[currentNode] = true;

        for (int node : adj.get(currentNode)) {
            if (!visited[node]) {
                dfs1(adj, node, visited, stack, isStack);
            }
        }

        if (isStack) {
            stack.push(currentNode);
        }
    }

//    private void dfs2(List<List<Integer>> adjT, int currentNode, boolean[] visited) {
//        visited[currentNode] = true;
//
//        for (int node : adjT.get(currentNode)) {
//            if (!visited[node]) {
//                dfs2(adjT, node, visited);
//            }
//        }
//    }
}

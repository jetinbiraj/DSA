package com.app.google.striverA2ZDSASheet.graphs.topo_sort;

import java.util.*;

public class EventualSafeStates {

    public static void main(String[] args) {

        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};

        EventualSafeStates obj = new EventualSafeStates();
        System.out.println(obj.eventualSafeNodes(graph));
        System.out.println(obj.dfsEventualSafeNodes(graph));
    }

    public List<Integer> dfsEventualSafeNodes(int[][] graph) {

        List<Integer> safeNodes = new ArrayList<>();

        int n = graph.length;

        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                safeNodes.add(i);
            } else if (checkDfs(visited, i, graph)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean checkDfs(int[] visited, int node, int[][] graph) {

        if (visited[node] == 1) {
            return true;
        } else if (visited[node] == 2) {
            return false;
        }

        visited[node] = 2;

        for (int next : graph[node]) {
            if (!checkDfs(visited, next, graph)) {
                return false;
            }
        }

        visited[node] = 1;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i);
                inDegree[i]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        boolean[] safe = new boolean[n];

        while (!queue.isEmpty()) {
            int entry = queue.pollFirst();
            safe[entry] = true;

            for (int node : adj.get(entry)) {
                if (--inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}

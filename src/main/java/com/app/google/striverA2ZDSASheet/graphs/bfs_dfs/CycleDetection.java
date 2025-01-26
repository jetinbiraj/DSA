package com.app.google.striverA2ZDSASheet.graphs.bfs_dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CycleDetection {

    public static void main(String[] args) {
        List<List<Integer>> adj = List.of(List.of(1), List.of(0, 2, 4), List.of(1, 3), List.of(2, 4), List.of(1, 3));

        CycleDetection obj = new CycleDetection();
        System.out.println(obj.bfsIsCycle(adj));
        System.out.println(obj.dfsIsCycle(adj));
    }

    private boolean dfsIsCycle(List<List<Integer>> adj) {
        int size = adj.size();
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i] && dfs(adj, -1, i, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(List<List<Integer>> adj, int prevNode, int currentNode, boolean[] visited) {
        visited[currentNode] = true;

        for (int node : adj.get(currentNode)) {
            if (!visited[node]) {
                if (dfs(adj, currentNode, node, visited)) {
                    return true;
                }
            } else if (node != prevNode) {
                return true;
            }
        }

        return false;
    }

    public boolean bfsIsCycle(List<List<Integer>> adj) {
        int size = adj.size();
        boolean[] visited = new boolean[size];

        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {

            if (visited[i]) {
                continue;
            }

            queue.add(new int[]{i, -1});
            visited[i] = true;

            while (!queue.isEmpty()) {

                int[] currentEntry = queue.pollFirst();

                for (int entry : adj.get(currentEntry[0])) {

                    if (!visited[entry]) {
                        queue.add(new int[]{entry, currentEntry[0]});
                        visited[entry] = true;
                    } else if (entry != currentEntry[1]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import java.util.*;

public class ShortestPathDAG {

    private record Pair(int node, int weight) {

    }

    public static void main(String[] args) {

        int V = 6, E = 7;
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1},
        };

        ShortestPathDAG obj = new ShortestPathDAG();
        System.out.println(Arrays.toString(obj.shortestPath(V, E, edges)));
        System.out.println(Arrays.toString(obj.shortestPathUsingTopoSort(V, E, edges)));
    }

    private int[] shortestPathUsingTopoSort(int V, int E, int[][] edges) { //This solution is preferred one
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int node = 0; node < V; node++) {
            if (!visited[node]) {
                topoSort(node, visited, stack, adj);
            }
        }

        int[] paths = new int[V];
        Arrays.fill(paths, Integer.MAX_VALUE);
        paths[5] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (Pair pair : adj.get(node)) {

                int newWeight = paths[node] + pair.weight;
                if (paths[pair.node] > newWeight && newWeight >= 0) {
                    paths[pair.node] = newWeight;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (paths[i] == Integer.MAX_VALUE) {
                paths[i] = -1;
            }
        }

        return paths;
    }

    private void topoSort(int currentNode, boolean[] visited, Deque<Integer> stack, List<List<Pair>> adj) {

        visited[currentNode] = true;

        for (Pair pair : adj.get(currentNode)) {
            if (!visited[pair.node]) {
                topoSort(pair.node, visited, stack, adj);
            }
        }

        stack.push(currentNode);
    }

    private int[] shortestPath(int V, int E, int[][] edges) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        int[] paths = new int[V];
        Arrays.fill(paths, Integer.MAX_VALUE);

        Deque<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(0, 0));
        paths[0] = 0;

        while (!queue.isEmpty()) {

            Pair entry = queue.pollFirst();

            for (Pair pair : adj.get(entry.node)) {

                int newWeight = pair.weight + paths[entry.node];

                if (paths[pair.node] > newWeight) {
                    paths[pair.node] = newWeight;
                    queue.add(pair);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (paths[i] == Integer.MAX_VALUE) {
                paths[i] = -1;
            }
        }

        return paths;
    }
}

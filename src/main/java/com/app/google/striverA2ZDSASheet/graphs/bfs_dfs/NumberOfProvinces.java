package com.app.google.striverA2ZDSASheet.graphs.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1},
        };

        NumberOfProvinces obj = new NumberOfProvinces();

        System.out.println(obj.findCircleNum(isConnected));
        System.out.println(obj.betterFindCircleNum(isConnected));
    }

    public int betterFindCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] cityVisitTracker = new boolean[n];

        int provinces = 0;

        for (int city = 0; city < n; city++) {

            if (!cityVisitTracker[city]) {
                dfs(isConnected, cityVisitTracker, city);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] cityVisitTracker, int currentCity) {
        cityVisitTracker[currentCity] = true;

        for (int city = 0; city < isConnected.length; city++) {
            if (isConnected[currentCity][city] == 1 && !cityVisitTracker[city]) {
                dfs(isConnected, cityVisitTracker, city);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];

        int provinces = 0;

        List<List<Integer>> adjList = getAdjList(isConnected);

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i]) {
                dfs(adjList, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(List<List<Integer>> adjList, boolean[] visited, int currentNode) {
        visited[currentNode] = true;

        for (int node : adjList.get(currentNode)) {
            if (!visited[node]) {
                dfs(adjList, visited, node);
            }
        }
    }

    private List<List<Integer>> getAdjList(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();

        int n = isConnected.length;

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                }
            }
        }

        return adjList;
    }
}

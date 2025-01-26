package com.app.google.striverA2ZDSASheet.graphs.bfs_dfs;

public class IsBipartite {

    public static void main(String[] args) {
        int[][] graph = {{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}};
//        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};

        IsBipartite obj = new IsBipartite();

        System.out.println(obj.isBipartite(graph));
    }

    private boolean isBipartite(int[][] graph) {

        int length = graph.length;
        int[] visited = new int[length];

        for (int i = 0; i < length; i++) {
            if (visited[i] == 0 && !isBipartite(graph, visited, 1, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isBipartite(int[][] graph, int[] visited, int mark, int currentNode) {

        visited[currentNode] = mark;

        for (int node : graph[currentNode]) {
            if ((visited[node] == 0 && !isBipartite(graph, visited, -mark, node)) || visited[node] == mark) {
                return false;
            }
        }

        return true;
    }
}

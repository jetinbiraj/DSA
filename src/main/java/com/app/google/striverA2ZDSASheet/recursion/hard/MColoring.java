package com.app.google.striverA2ZDSASheet.recursion.hard;

public class MColoring {

    public static void main(String[] args) {

        int n = 4;
        int m = 3;
        boolean[][] graph = {
                {false, true, true, true},
                {true, false, true, false},
                {true, true, false, true},
                {true, false, true, false}
        };

        System.out.println(graphColoring(graph, m, n));
    }

    //TODO: Most bullshit question on gfg :- https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

    private static boolean graphColoring(boolean[][] graph, int m, int n) {

        int[] color = new int[n];

        return graphColoring(graph, m, n, 0, color);
    }

    private static boolean graphColoring(boolean[][] graph, int m, int n, int node, int[] color) {

        if (node == n) {
            return true;
        }

        for (int currentColor = 1; currentColor <= m; currentColor++) {

            if (canColored(currentColor, node, graph, color, n)) {

                color[node] = currentColor;

                if (graphColoring(graph, m, n, node + 1, color)) {
                    return true;
                }
                color[node] = 0;
            }
        }

        return false;
    }

    private static boolean canColored(int currentColor, int node, boolean[][] graph, int[] color, int n) {

        for (int i = 0; i < n; i++) {

            if (graph[node][i] && currentColor == color[i]) {
                return false;
            }
        }

        return true;
    }
}

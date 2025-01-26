package com.app.google.striverA2ZDSASheet.graphs.learning;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

    public static void main(String[] args) {

        int vertices = 5;
        int[][] edges = {
                {0, 1},
                {0, 4},
                {4, 1},
                {4, 3},
                {1, 3},
                {1, 2},
                {3, 2}
        };

        System.out.println(printGraph(vertices, edges));
    }

    public static List<List<Integer>> printGraph(int vertices, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 1; i <= vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        return adjacencyList;
    }
}

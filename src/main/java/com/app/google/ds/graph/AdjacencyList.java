package com.app.google.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    private int numVertices;
    private List<List<Integer>> adjList;

    public AdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    private void addEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public void print() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("\nVertex " + i + ": ");

            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(" -> " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        AdjacencyList adjacencyList = new AdjacencyList(5);

        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(0, 3);
        adjacencyList.addEdge(1, 2);

        adjacencyList.print();
    }
}

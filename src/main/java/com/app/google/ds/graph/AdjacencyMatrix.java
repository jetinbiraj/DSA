package com.app.google.ds.graph;

import java.util.Arrays;

public class AdjacencyMatrix {
    private boolean[][] adjMatrix;
    private int numVertices;

    private AdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new boolean[numVertices][numVertices];
    }

    private void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    private void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    // Print the matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i).append(": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j ? 1 : 0)).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        AdjacencyMatrix matrix = new AdjacencyMatrix(4);

        matrix.addEdge(0,1);
        matrix.addEdge(0,2);
        matrix.addEdge(1,2);
        matrix.addEdge(2,0);
        matrix.addEdge(2,3);

        System.out.println(matrix);
    }
}

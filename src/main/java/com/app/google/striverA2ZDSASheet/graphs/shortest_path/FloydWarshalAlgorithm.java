package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import java.util.Arrays;

public class FloydWarshalAlgorithm {

    public static void main(String[] args) {

        int[][] mat = {
                {0, 1, 43},
                {1, 0, 6},
                {-1, -1, 0}
        };

        FloydWarshalAlgorithm obj = new FloydWarshalAlgorithm();
        obj.shortestDistance(mat);

        System.out.println(Arrays.deepToString(mat));
    }

    private void shortestDistance(int[][] mat) {

        int n = mat.length;
        int infy = 100000000;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = infy;
                } else if (i == j) {
                    mat[i][j] = 0;
                }
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == infy) {
                    mat[i][j] = -1;
                }
            }
        }
    }
}



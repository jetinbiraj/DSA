package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.Arrays;

public class RotateMatrix90 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


//        int[][] matrix = {
//                {1, 4, 7},
//                {2, 5, 8},
//                {3, 6, 9}
//        };

//        int[][] matrix = {
//                {7, 4, 1},
//                {8, 5, 2},
//                {9, 6, 3}
//        };

//        bruteRotateClockwise(matrix);
        optimalRotateClockwise(matrix);

        System.out.println(Arrays.deepToString(matrix));

    }

    private static void optimalRotateClockwise(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n / 2; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    private static void bruteRotateClockwise(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] tempMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                tempMatrix[i][j] = matrix[n - j - 1][i];

            }
        }

        for (int i = 0; i < m; i++) {
            System.arraycopy(tempMatrix[i], 0, matrix[i], 0, n);
        }
    }
}

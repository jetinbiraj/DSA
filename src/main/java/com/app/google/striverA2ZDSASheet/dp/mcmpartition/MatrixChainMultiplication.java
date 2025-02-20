package com.app.google.striverA2ZDSASheet.dp.mcmpartition;

import java.util.Arrays;

public class MatrixChainMultiplication {

    public static void main(String[] args) {

        int[] arr = {2, 1, 3, 4};

        MatrixChainMultiplication obj = new MatrixChainMultiplication();
        System.out.println(obj.bruteForceMatrixMultiplication(arr));
        System.out.println(obj.matrixMultiplicationUsingMemoization(arr));
        System.out.println(obj.matrixMultiplicationUsingTabulation(arr));
        System.out.println(obj.matrixMultiplicationUsingTabulation(arr));
    }

    private int matrixMultiplicationUsingTabulation(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 1; i--) {

            for (int j = i + 1; j < n; j++) {

                int min = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];

                    min = Math.min(min, steps);
                }

                dp[i][j] = min;
            }
        }
        return dp[1][n - 1];
    }

    private int matrixMultiplicationUsingMemoization(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return matrixMultiplicationUsingMemoization(1, arr.length - 1, arr, dp);
    }

    private int matrixMultiplicationUsingMemoization(int i, int j, int[] arr, int[][] dp) {

        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + matrixMultiplicationUsingMemoization(i, k, arr, dp) +
                    matrixMultiplicationUsingMemoization(k + 1, j, arr, dp);

            min = Math.min(min, steps);
        }

        return dp[i][j] = min;
    }

    private int bruteForceMatrixMultiplication(int[] arr) {
        return bruteForceMatrixMultiplication(1, arr.length - 1, arr);
    }

    private int bruteForceMatrixMultiplication(int i, int j, int[] arr) {

        if (i == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + bruteForceMatrixMultiplication(i, k, arr) +
                    bruteForceMatrixMultiplication(k + 1, j, arr);

            min = Math.min(min, steps);
        }

        return min;
    }
}

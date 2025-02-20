package com.app.google.striverA2ZDSASheet.dp.twothreeDGrids;

import java.util.Arrays;

public class MinFailingPathSum {

    public static void main(String[] args) {

        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};

        MinFailingPathSum obj = new MinFailingPathSum();
        System.out.println(obj.bruteForceMinFallingPathSum(matrix));
        System.out.println(obj.minFallingPathSumUsingMemoization(matrix));
        System.out.println(obj.minFallingPathSumUsingTabulation(matrix));
        System.out.println(obj.minFallingPathSumUsingSpaceOptimisation(matrix));
    }

    private int minFallingPathSumUsingSpaceOptimisation(int[][] matrix) {

        int n = matrix.length;
        int[] dp = matrix[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {

                int nextLeft = j - 1 >= 0 ? dp[j - 1] : Integer.MAX_VALUE;
                int nextRight = j + 1 < n ? dp[j + 1] : Integer.MAX_VALUE;

                temp[j] = matrix[i][j] + Math.min(dp[j], Math.min(nextLeft, nextRight));
            }
            dp = temp;
        }

        return Arrays.stream(dp).min().orElse(0);
    }

    private int minFallingPathSumUsingTabulation(int[][] matrix) {

        int n = matrix.length, minPathSum = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];

        dp[n - 1] = matrix[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {

                int nextLeft = j - 1 >= 0 ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int nextRight = j + 1 < n ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(nextLeft, nextRight));
            }
        }

        for (int sum : dp[0]) {
            minPathSum = Math.min(minPathSum, sum);
        }

        return minPathSum;
    }

    private int minFallingPathSumUsingMemoization(int[][] matrix) {

        int n = matrix.length, minPathSum = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            minPathSum = Math.min(minPathSum, minFallingPathSumUsingMemoization(matrix, n, 0, i, dp));
        }

        return minPathSum;
    }

    private int minFallingPathSumUsingMemoization(int[][] matrix, int n, int row, int col, int[][] dp) {

        if (col < 0 || col >= n) {
            return Integer.MAX_VALUE;
        }

        if (row == n - 1) {
            return matrix[row][col];
        }

        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        int nextLeft = minFallingPathSumUsingMemoization(matrix, n, row + 1, col - 1, dp);
        int next = minFallingPathSumUsingMemoization(matrix, n, row + 1, col, dp);
        int nextRight = minFallingPathSumUsingMemoization(matrix, n, row + 1, col + 1, dp);

        return dp[row][col] = matrix[row][col] + Math.min(nextLeft, Math.min(next, nextRight));
    }

    private int bruteForceMinFallingPathSum(int[][] matrix) {

        int n = matrix.length, minPathSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minPathSum = Math.min(minPathSum, bruteForceMinFallingPathSum(matrix, n, 0, i));
        }

        return minPathSum;
    }

    private int bruteForceMinFallingPathSum(int[][] matrix, int n, int row, int col) {

        if (col < 0 || col >= n) {
            return Integer.MAX_VALUE;
        }

        if (row == n - 1) {
            return matrix[row][col];
        }

        int nextLeft = bruteForceMinFallingPathSum(matrix, n, row + 1, col - 1);
        int next = bruteForceMinFallingPathSum(matrix, n, row + 1, col);
        int nextRight = bruteForceMinFallingPathSum(matrix, n, row + 1, col + 1);

        return matrix[row][col] + Math.min(nextLeft, Math.min(next, nextRight));
    }
}

package com.app.google.striverA2ZDSASheet.dp.twothreeDGrids;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {

        int m = 3, n = 7;

        UniquePaths obj = new UniquePaths();
        System.out.println(obj.bruteForceUniquePaths(m, n));
        System.out.println(obj.uniquePathsUsingMemoization(m, n));
        System.out.println(obj.uniquePathsUsingTabulation(m, n));
        System.out.println(obj.uniquePathsUsingSpaceOptimization(m, n));
    }

    private int uniquePathsUsingSpaceOptimization(int m, int n) {

        int[] prevRow = new int[n];

        for (int i = 0; i < m; i++) {

            int[] currentRow = new int[n];

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    currentRow[0] = 1;
                    continue;
                }

                currentRow[j] = (j > 0 ? currentRow[j - 1] : 0) + (i > 0 ? prevRow[j] : 0);
            }

            prevRow = currentRow;
        }

        return prevRow[n - 1];
    }

    private int uniquePathsUsingTabulation(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = (j > 0 ? dp[i][j - 1] : 0) + (i > 0 ? dp[i - 1][j] : 0);
            }
        }

        return dp[m - 1][n - 1];
    }

    private int uniquePathsUsingMemoization(int m, int n) {

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return uniquePathsUsingMemoization(m, n, 0, 0, dp);
    }

    private int uniquePathsUsingMemoization(int m, int n, int i, int j, int[][] dp) {
        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = uniquePathsUsingMemoization(m, n, i, j + 1, dp) + uniquePathsUsingMemoization(m, n, i + 1, j, dp);
    }

    private int bruteForceUniquePaths(int m, int n) {
        return bruteForceUniquePaths(m, n, 0, 0);
    }

    private int bruteForceUniquePaths(int m, int n, int i, int j) {
        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        return bruteForceUniquePaths(m, n, i, j + 1) + bruteForceUniquePaths(m, n, i + 1, j);
    }
}

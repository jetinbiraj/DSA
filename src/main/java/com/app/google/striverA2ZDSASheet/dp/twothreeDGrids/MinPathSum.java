package com.app.google.striverA2ZDSASheet.dp.twothreeDGrids;

import java.util.Arrays;

public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        MinPathSum obj = new MinPathSum();
        System.out.println(obj.bruteForceMinPathSum(grid));
        System.out.println(obj.minPathSumUsingMemoization(grid));
        System.out.println(obj.minPathSumUsingTabulation(grid));
        System.out.println(obj.minPathSumUsingSpaceOptimization(grid));
    }

    private int minPathSumUsingSpaceOptimization(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] nextRow = new int[n];

        for (int i = m - 1; i >= 0; i--) {

            int[] currentRow = new int[n];

            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    currentRow[j] = grid[i][j];
                } else {
                    currentRow[j] = grid[i][j] + Math.min((i + 1 < m ? nextRow[j] : Integer.MAX_VALUE), (j + 1 < n ? currentRow[j + 1] : Integer.MAX_VALUE));
                }
            }

            nextRow = currentRow;
        }

        return nextRow[0];
    }

    private int minPathSumUsingTabulation(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min((i + 1 < m ? dp[i + 1][j] : Integer.MAX_VALUE), (j + 1 < n ? dp[i][j + 1] : Integer.MAX_VALUE));
                }
            }
        }

        return dp[0][0];
    }

    public int minPathSumUsingMemoization(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minPathSumUsingMemoization(grid, m, n, 0, 0, dp);
    }

    private int minPathSumUsingMemoization(int[][] grid, int m, int n, int i, int j, int[][] dp) {
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        return dp[i][j] == -1 ? dp[i][j] = grid[i][j] + Math.min(minPathSumUsingMemoization(grid, m, n, i + 1, j, dp),
                minPathSumUsingMemoization(grid, m, n, i, j + 1, dp)) : dp[i][j];
    }

    public int bruteForceMinPathSum(int[][] grid) {
        return bruteForceMinPathSum(grid, grid.length, grid[0].length, 0, 0);
    }

    private int bruteForceMinPathSum(int[][] grid, int m, int n, int i, int j) {
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        return grid[i][j] + Math.min(bruteForceMinPathSum(grid, m, n, i + 1, j), bruteForceMinPathSum(grid, m, n, i, j + 1));
    }
}

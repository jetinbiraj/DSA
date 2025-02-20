package com.app.google.striverA2ZDSASheet.dp.twothreeDGrids;

import java.util.Arrays;

public class UniquePathsII {

    public static void main(String[] args) {

        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        UniquePathsII obj = new UniquePathsII();
        System.out.println(obj.bruteForceUniquePathsWithObstacles(obstacleGrid));
        System.out.println(obj.uniquePathsWithObstaclesWithMemoization(obstacleGrid));
        System.out.println(obj.uniquePathsWithObstaclesWithTabulation(obstacleGrid));
        System.out.println(obj.uniquePathsWithObstaclesWithSpaceOptimization(obstacleGrid));
    }

    private int uniquePathsWithObstaclesWithSpaceOptimization(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[] nextRow = new int[n];

        for (int i = m - 1; i >= 0; i--) {

            int[] currentRow = new int[n];

            for (int j = n - 1; j >= 0; j--) {

                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                if (i == m - 1 && j == n - 1) {
                    currentRow[j] = 1;
                } else {
                    currentRow[j] = (i + 1 < m ? nextRow[j] : 0) + (j + 1 < n ? currentRow[j + 1] : 0);
                }
            }

            nextRow = currentRow;
        }

        return nextRow[0];
    }

    private int uniquePathsWithObstaclesWithTabulation(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (i + 1 < m ? dp[i + 1][j] : 0) + (j + 1 < n ? dp[i][j + 1] : 0);
                }
            }
        }

        return dp[0][0];
    }

    private int uniquePathsWithObstaclesWithMemoization(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return uniquePathsWithObstaclesWithMemoization(obstacleGrid, m, n, 0, 0, dp);
    }

    private int uniquePathsWithObstaclesWithMemoization(int[][] obstacleGrid, int m, int n, int i, int j, int[][] dp) {

        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = uniquePathsWithObstaclesWithMemoization(obstacleGrid, m, n, i + 1, j, dp) +
                uniquePathsWithObstaclesWithMemoization(obstacleGrid, m, n, i, j + 1, dp);
    }

    public int bruteForceUniquePathsWithObstacles(int[][] obstacleGrid) {

        return bruteForceUniquePathsWithObstacles(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length, 0, 0);
    }

    private int bruteForceUniquePathsWithObstacles(int[][] obstacleGrid, int m, int n, int i, int j) {

        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        return bruteForceUniquePathsWithObstacles(obstacleGrid, m, n, i + 1, j) + bruteForceUniquePathsWithObstacles(obstacleGrid, m, n, i, j + 1);
    }
}

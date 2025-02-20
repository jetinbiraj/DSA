package com.app.google.striverA2ZDSASheet.dp.twothreeDGrids;

public class ChocolatePickups {

    public static void main(String[] args) {
        int n = 4, m = 3;
        int[][] grid = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };

        ChocolatePickups obj = new ChocolatePickups();
        System.out.println(obj.bruteForceSolve(n, m, grid));
        System.out.println(obj.solveUsingMemoization(n, m, grid));
        System.out.println(obj.solveUsingTabulation(n, m, grid));
        System.out.println(obj.solveUsingSpaceOptimisation(n, m, grid));
    }

    private int solveUsingSpaceOptimisation(int n, int m, int[][] grid) {

        int[][] front = new int[m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                front[j1][j2] = j1 == j2 ? grid[n - 1][j1] : grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {

            int[][] current = new int[m][m];

            for (int j1 = 0; j1 < m; j1++) {

                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = (int) -1e8;

                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {

                            int val = j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2];

                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                val += front[j1 + dj1][j2 + dj2];
                            } else {
                                val += (int) -1e8;
                            }

                            maxi = Math.max(maxi, val);
                        }
                    }

                    current[j1][j2] = maxi;
                }
            }

            front = current;
        }

        return front[0][m - 1];
    }

    private int solveUsingTabulation(int n, int m, int[][] grid) {

        int[][][] dp = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                dp[n - 1][j1][j2] = j1 == j2 ? grid[n - 1][j1] : grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = (int) -1e8;

                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {

                            int val = j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2];

                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                val += dp[i + 1][j1 + dj1][j2 + dj2];
                            } else {
                                val += (int) -1e8;
                            }

                            maxi = Math.max(maxi, val);
                        }
                    }

                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][m - 1];
    }

    private int solveUsingMemoization(int n, int m, int[][] grid) {
        return solveUsingMemoization(n, m, grid, 0, 0, m - 1, new int[n][m][m]);
    }

    private int solveUsingMemoization(int r, int c, int[][] grid, int r1, int c1, int c2, int[][][] dp) {

        if (c1 < 0 || c2 < 0 || c1 >= c || c2 >= c) {
            return (int) -1e8;
        }

        if (r1 == r - 1) {
            return c1 == c2 ? grid[r1][c1] : grid[r1][c1] + grid[r1][c2];
        }

        if (dp[r1][c1][c2] != 0) {
            return dp[r1][c1][c2];
        }

        int maxi = (int) -1e8;

        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {

                int val = c1 == c2 ? grid[r1][c1] : grid[r1][c1] + grid[r1][c2];

                val += solveUsingMemoization(r, c, grid, r1 + 1, c1 + dj1, c2 + dj2, dp);

                maxi = Math.max(maxi, val);
            }
        }

        return dp[r1][c1][c2] = maxi;
    }

    private int bruteForceSolve(int n, int m, int[][] grid) {
        return bruteForceSolve(n, m, grid, 0, 0, m - 1);
    }

    private int bruteForceSolve(int r, int c, int[][] grid, int r1, int c1, int c2) {

        if (c1 < 0 || c2 < 0 || c1 >= c || c2 >= c) {
            return (int) -1e8;
        }

        if (r1 == r - 1) {
            return c1 == c2 ? grid[r1][c1] : grid[r1][c1] + grid[r1][c2];
        }


        int maxi = (int) -1e8;

        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {

                int val = c1 == c2 ? grid[r1][c1] : grid[r1][c1] + grid[r1][c2];

                val += bruteForceSolve(r, c, grid, r1 + 1, c1 + dj1, c2 + dj2);

                maxi = Math.max(maxi, val);
            }
        }

        return maxi;
    }
}

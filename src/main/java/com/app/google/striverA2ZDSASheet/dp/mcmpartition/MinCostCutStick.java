package com.app.google.striverA2ZDSASheet.dp.mcmpartition;


import java.util.Arrays;

public class MinCostCutStick {

    public static void main(String[] args) {

        int n = 7;
        int[] cuts = {1, 3, 4, 5};

        MinCostCutStick obj = new MinCostCutStick();
        System.out.println(obj.bruteForceMinCost(n, cuts));
        System.out.println(obj.minCostUsingMemoization(n, cuts));
        System.out.println(obj.minCostUsingTabulation(n, cuts));
    }

    private int minCostUsingTabulation(int n, int[] cuts) {

        int len = cuts.length;

        int[] newCuts = new int[len + 2];
        System.arraycopy(cuts, 0, newCuts, 1, len);

        newCuts[len + 1] = n;
        Arrays.sort(newCuts);

        int[][] dp = new int[len + 2][len + 2];

        for (int i = len; i >= 1; i--) {

            for (int j = 1; j <= len; j++) {

                if (i > j) {
                    continue;
                }

                int minCost = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    minCost = Math.min(minCost, newCuts[j + 1] - newCuts[i - 1] + dp[i][k - 1] + dp[k + 1][j]);
                }

                dp[i][j] = minCost;
            }
        }

        return dp[1][len];
    }

    private int minCostUsingMemoization(int n, int[] cuts) {

        int len = cuts.length;

        int[] newCuts = new int[len + 2];
        System.arraycopy(cuts, 0, newCuts, 1, len);

        newCuts[len + 1] = n;
        Arrays.sort(newCuts);

        int[][] dp = new int[len + 1][len + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return minCostUsingMemoization(newCuts, 1, len, dp);
    }

    private int minCostUsingMemoization(int[] cuts, int i, int j, int[][] dp) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE;

        for (int x = i; x <= j; x++) {
            minCost = Math.min(minCost, cuts[j + 1] - cuts[i - 1] + minCostUsingMemoization(cuts, i, x - 1, dp) +
                    minCostUsingMemoization(cuts, x + 1, j, dp));
        }

        return dp[i][j] = minCost;
    }

    private int bruteForceMinCost(int n, int[] cuts) {

        int len = cuts.length;

        int[] newCuts = new int[len + 2];
        System.arraycopy(cuts, 0, newCuts, 1, len);

        newCuts[len + 1] = n;
        Arrays.sort(newCuts);

        return bruteForceMinCost(newCuts, 1, len);
    }

    private int bruteForceMinCost(int[] cuts, int i, int j) {

        if (i > j) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int x = i; x <= j; x++) {
            minCost = Math.min(minCost, cuts[j + 1] - cuts[i - 1] + bruteForceMinCost(cuts, i, x - 1) + bruteForceMinCost(cuts, x + 1, j));
        }

        return minCost;
    }
}

package com.app.google.striverA2ZDSASheet.dp.subsequences;

import java.util.Arrays;

public class KnapSack {

    public static void main(String[] args) {

        int[] val = {3, 1, 3}, wt = {7, 3, 3};
        int capacity = 4;


        KnapSack obj = new KnapSack();
        System.out.println(obj.bruteForceKnapSack(val, wt, capacity));
        System.out.println(obj.KnapSackUsingMemoization(val, wt, capacity));
        System.out.println(obj.knapSackUsingTabulation(val, wt, capacity));
        System.out.println(obj.knapSackUsingSpaceOptimisation(val, wt, capacity));
    }

    private int knapSackUsingSpaceOptimisation(int[] val, int[] wt, int capacity) {

        int n = val.length;
        int[] dp = new int[capacity + 1];

        for (int cap = 0; cap <= capacity; cap++) {
            if (wt[0] <= cap) {
                dp[cap] = (cap / wt[0]) * val[0];
            }
        }

        for (int index = 1; index < n; index++) {
            for (int cap = 0; cap <= capacity; cap++) {

                int notPick = dp[cap];
                int pick = wt[index] <= cap ? (val[index] + dp[cap - wt[index]]) : Integer.MIN_VALUE;

                dp[cap] = Math.max(pick, notPick);
            }
        }

        return dp[capacity];
    }

    private int knapSackUsingTabulation(int[] val, int[] wt, int capacity) {

        int n = val.length;
        int[][] dp = new int[n][capacity + 1];


        for (int cap = 0; cap <= capacity; cap++) {
            if (wt[0] <= cap) {
                dp[0][cap] = (cap / wt[0]) * val[0];
            }
        }

        for (int index = 1; index < n; index++) {
            for (int cap = 0; cap <= capacity; cap++) {

                int notPick = dp[index - 1][cap];
                int pick = wt[index] <= cap ? (val[index] + dp[index][cap - wt[index]]) : Integer.MIN_VALUE;

                dp[index][cap] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][capacity];
    }

    private int KnapSackUsingMemoization(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[][] dp = new int[n][capacity + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return KnapSackUsingMemoization(val, wt, capacity, val.length - 1, dp);
    }

    private int KnapSackUsingMemoization(int[] val, int[] wt, int capacity, int index, int[][] dp) {

        if (index == 0) {
            return wt[0] != 0 ? (capacity / wt[0] * val[0]) : 0;
        }

        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        int notPick = KnapSackUsingMemoization(val, wt, capacity, index - 1, dp);

        int pick = Integer.MIN_VALUE;

        if (wt[index] <= capacity) {
            pick = val[index] + KnapSackUsingMemoization(val, wt, capacity - wt[index], index, dp);
        }

        return dp[index][capacity] = Math.max(pick, notPick);
    }

    private int bruteForceKnapSack(int[] val, int[] wt, int capacity) {
        return bruteForceKnapSack(val, wt, capacity, val.length - 1);
    }

    private int bruteForceKnapSack(int[] val, int[] wt, int capacity, int index) {

        if (index == 0) {
            return wt[0] != 0 ? (capacity / wt[0] * val[0]) : 0;
        }

        int notPick = bruteForceKnapSack(val, wt, capacity, index - 1);

        int pick = Integer.MIN_VALUE;

        if (wt[index] <= capacity) {
            pick = val[index] + bruteForceKnapSack(val, wt, capacity - wt[index], index);
        }

        return Math.max(pick, notPick);
    }
}

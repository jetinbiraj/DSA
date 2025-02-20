package com.app.google.striverA2ZDSASheet.dp.subsequences;

import java.util.Arrays;

public class RodCutting {

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        RodCutting obj = new RodCutting();
        System.out.println(obj.bruteForceCutRod(price));
        System.out.println(obj.cutRodUsingMemoization(price));
        System.out.println(obj.cutRodUsingTabulation(price));
        System.out.println(obj.cutRodUsingSpaceOptimisation(price));
    }

    private int cutRodUsingSpaceOptimisation(int[] price) {
        int size = price.length;

        int[] dp = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            dp[i] = i * price[0];
        }

        for (int index = 1; index < size; index++) {
            for (int s = 1; s <= size; s++) {

                int noCut = dp[s];
                int cut = index + 1 <= s ? (price[index] + dp[s - index - 1]) : Integer.MIN_VALUE;

                dp[s] = Math.max(noCut, cut);
            }
        }

        return dp[size];
    }

    private int cutRodUsingTabulation(int[] price) {
        int size = price.length;

        int[][] dp = new int[size][size + 1];

        for (int i = 1; i <= size; i++) {
            dp[0][i] = i * price[0];
        }

        for (int index = 1; index < size; index++) {
            for (int s = 1; s <= size; s++) {

                int noCut = dp[index - 1][s];
                int cut = index + 1 <= s ? (price[index] + dp[index][s - index - 1]) : Integer.MIN_VALUE;

                dp[index][s] = Math.max(noCut, cut);
            }
        }

        return dp[size - 1][size];
    }

    private int cutRodUsingMemoization(int[] price) {
        int size = price.length;

        int[][] dp = new int[size][size + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return cutRodUsingMemoization(price, size, size - 1, dp);
    }

    private int cutRodUsingMemoization(int[] price, int size, int index, int[][] dp) {
        if (index == 0) {
            return size * price[0];
        }

        if (dp[index][size] != -1) {
            return dp[index][size];
        }

        int noCut = cutRodUsingMemoization(price, size, index - 1, dp);
        int cut = index + 1 <= size ? (price[index] + cutRodUsingMemoization(price, size - index - 1, index, dp)) : Integer.MIN_VALUE;

        return dp[index][size] = Math.max(cut, noCut);
    }

    private int bruteForceCutRod(int[] price) {
        int size = price.length;

        return bruteForceCutRod(price, size, size - 1);
    }

    private int bruteForceCutRod(int[] price, int size, int index) {
        if (index == 0) {
            return size * price[0];
        }

        int noCut = bruteForceCutRod(price, size, index - 1);
        int cut = index + 1 <= size ? (price[index] + bruteForceCutRod(price, size - index - 1, index)) : Integer.MIN_VALUE;

        return Math.max(cut, noCut);
    }
}

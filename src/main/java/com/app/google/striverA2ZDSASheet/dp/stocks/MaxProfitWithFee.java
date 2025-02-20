package com.app.google.striverA2ZDSASheet.dp.stocks;

import java.util.Arrays;

public class MaxProfitWithFee {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        MaxProfitWithFee obj = new MaxProfitWithFee();
        System.out.println(obj.bruteForceMaxProfit(prices, fee));
        System.out.println(obj.maxProfitUsingMemoization(prices, fee));
        System.out.println(obj.maxProfitUsingTabulation(prices, fee));
        System.out.println(obj.maxProfitUsingSpaceOptimisation(prices, fee));
    }

    private int maxProfitUsingSpaceOptimisation(int[] prices, int fee) {

        int n = prices.length;

        int[] dp = new int[2];

        for (int index = n - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy < 2; isBuy++) {

                if (isBuy == 1) {
                    dp[isBuy] = Math.max(-prices[index] + dp[0], dp[1]);
                } else {
                    dp[isBuy] = Math.max(prices[index] - fee + dp[1], dp[0]);
                }
            }
        }

        return dp[1];
    }

    private int maxProfitUsingTabulation(int[] prices, int fee) {

        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy < 2; isBuy++) {

                if (isBuy == 1) {
                    dp[index][isBuy] = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);
                } else {
                    dp[index][isBuy] = Math.max(prices[index] - fee + dp[index + 1][1], dp[index + 1][0]);
                }
            }
        }

        return dp[0][1];
    }

    private int maxProfitUsingMemoization(int[] prices, int fee) {

        int n = prices.length;

        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return maxProfitUsingMemoization(prices, fee, 0, 1, dp);
    }

    private int maxProfitUsingMemoization(int[] prices, int fee, int index, int isBuy, int[][] dp) {

        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][isBuy] != -1) {
            return dp[index][isBuy];
        }

        if (isBuy == 1) {
            return dp[index][isBuy] = Math.max(-prices[index] + maxProfitUsingMemoization(prices, fee, index + 1, 0, dp),
                    maxProfitUsingMemoization(prices, fee, index + 1, 1, dp));
        }

        return dp[index][isBuy] = Math.max(prices[index] - fee + maxProfitUsingMemoization(prices, fee, index + 1, 1, dp),
                maxProfitUsingMemoization(prices, fee, index + 1, 0, dp));
    }

    private int bruteForceMaxProfit(int[] prices, int fee) {
        return bruteForceMaxProfit(prices, fee, 0, true);
    }

    private int bruteForceMaxProfit(int[] prices, int fee, int index, boolean isBuy) {

        if (index >= prices.length) {
            return 0;
        }

        if (isBuy) {
            return Math.max(-prices[index] + bruteForceMaxProfit(prices, fee, index + 1, false),
                    bruteForceMaxProfit(prices, fee, index + 1, true));
        }

        return Math.max(prices[index] - fee + bruteForceMaxProfit(prices, fee, index + 1, true),
                bruteForceMaxProfit(prices, fee, index + 1, false));
    }
}

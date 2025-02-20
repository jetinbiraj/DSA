package com.app.google.striverA2ZDSASheet.dp.stocks;

import java.util.Arrays;

public class MaxProfitII {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        MaxProfitII obj = new MaxProfitII();
        System.out.println(obj.bruteForceMaxProfit(prices));
        System.out.println(obj.maxProfitUsingMemoization(prices));
        System.out.println(obj.maxProfitUsingTabulation(prices));
        System.out.println(obj.maxProfitUsingSpaceOptimisation(prices));
        System.out.println(obj.maxProfitUsingGreedy(prices));
        System.out.println(obj.maxProfitClean(prices));
    }

    private int maxProfitClean(int[] prices) {

        int maxProfit = 0, n = prices.length;

        for (int i = 1; i < n; i++) {

            if (prices[i - 1] < prices[i]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    private int maxProfitUsingGreedy(int[] prices) {

        int maxProfit = 0, n = prices.length, buy = prices[0];

        for (int i = 1; i < n; i++) {

            if (buy < prices[i]) {
                maxProfit += prices[i] - buy;
            }

            buy = prices[i];
        }

        return maxProfit;
    }

    private int maxProfitUsingSpaceOptimisation(int[] prices) {

        int n = prices.length;

        int[] dp = new int[2];

        for (int index = n - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy < 2; isBuy++) {

                int profit;
                if (isBuy == 1) {
                    profit = Math.max(-prices[index] + dp[0], dp[1]);
                } else {
                    profit = Math.max(prices[index] + dp[1], dp[0]);
                }

                dp[isBuy] = profit;
            }
        }

        return dp[1];
    }

    private int maxProfitUsingTabulation(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy < 2; isBuy++) {

                int profit;
                if (isBuy == 1) {
                    profit = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);
                } else {
                    profit = Math.max(prices[index] + dp[index + 1][1], dp[index + 1][0]);
                }

                dp[index][isBuy] = profit;
            }
        }

        return dp[0][1];
    }

    private int maxProfitUsingMemoization(int[] prices) {

        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return maxProfitUsingMemoization(prices, 1, 0, dp);
    }

    private int maxProfitUsingMemoization(int[] prices, int isBuy, int index, int[][] dp) {

        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][isBuy] != -1) {
            return dp[index][isBuy];
        }

        if (isBuy == 1) {
            dp[index][isBuy] = Math.max(-prices[index] + maxProfitUsingMemoization(prices, 0, index + 1, dp),
                    maxProfitUsingMemoization(prices, 1, index + 1, dp));
        }

        return dp[index][isBuy] = Math.max(prices[index] + maxProfitUsingMemoization(prices, 1, index + 1, dp),
                maxProfitUsingMemoization(prices, 0, index + 1, dp));
    }

    private int bruteForceMaxProfit(int[] prices) {

        return maxProfitUsingGreedy(prices, true, 0);
    }

    private int maxProfitUsingGreedy(int[] prices, boolean isBuy, int index) {

        if (index >= prices.length) {
            return 0;
        }

        if (isBuy) {
            return Math.max(-prices[index] + maxProfitUsingGreedy(prices, false, index + 1),
                    maxProfitUsingGreedy(prices, true, index + 1));
        }

        return Math.max(prices[index] + maxProfitUsingGreedy(prices, true, index + 1),
                maxProfitUsingGreedy(prices, false, index + 1));
    }
}

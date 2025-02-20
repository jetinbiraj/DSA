package com.app.google.striverA2ZDSASheet.dp.stocks;

import java.util.Arrays;

public class MaxProfitIII {

    public static void main(String[] args) {

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};


        MaxProfitIII obj = new MaxProfitIII();
        System.out.println(obj.bruteForceMaxProfit(prices));
        System.out.println(obj.maxProfitUsingMemoization(prices));
        System.out.println(obj.maxProfitUsingTabulation(prices));
        System.out.println(obj.maxProfitUsingSpaceOptimisation(prices));
    }

    // TODO: Write N * 4 solution approach

    private int maxProfitUsingSpaceOptimisation(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy < 2; isBuy++) {
                for (int transaction = 0; transaction < 2; transaction++) {

                    int profit;

                    if (isBuy == 1) {
                        profit = Math.max(-prices[index] + dp[0][transaction], dp[1][transaction]);
                    } else {

                        profit = Math.max(prices[index] + dp[1][transaction + 1], dp[0][transaction]);
                    }

                    dp[isBuy][transaction] = profit;
                }
            }
        }

        return dp[1][0];
    }

    private int maxProfitUsingTabulation(int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy < 2; isBuy++) {
                for (int transaction = 0; transaction < 2; transaction++) {

                    int profit;

                    if (isBuy == 1) {
                        profit = Math.max(-prices[index] + dp[index + 1][0][transaction], dp[index + 1][1][transaction]);
                    } else {

                        profit = Math.max(prices[index] + dp[index + 1][1][transaction + 1], dp[index + 1][0][transaction]);
                    }

                    dp[index][isBuy][transaction] = profit;
                }
            }
        }

        return dp[0][1][0];
    }

    private int maxProfitUsingMemoization(int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n][2][2];
        for (int i = 0; i < n; i++) {
            for (int[] row : dp[i]) {
                Arrays.fill(row, -1);
            }
        }

        return maxProfit(prices, 0, 1, 0, dp);
    }

    private int maxProfit(int[] prices, int index, int isBuy, int transaction, int[][][] dp) {

        if (transaction >= 2 || index >= prices.length) {
            return 0;
        }

        if (dp[index][isBuy][transaction] != -1) {
            return dp[index][isBuy][transaction];
        }

        if (isBuy == 1) {
            return dp[index][isBuy][transaction] = Math.max(-prices[index] + maxProfit(prices, index + 1, 0, transaction, dp),
                    maxProfit(prices, index + 1, 1, transaction, dp));
        }

        return dp[index][isBuy][transaction] = Math.max(prices[index] + maxProfit(prices, index + 1, 1, transaction + 1, dp),
                maxProfit(prices, index + 1, 0, transaction, dp));
    }

    private int bruteForceMaxProfit(int[] prices) {

        return bruteForceMaxProfit(prices, 0, true, 1);
    }

    private int bruteForceMaxProfit(int[] prices, int index, boolean isBuy, int transaction) {

        if (transaction > 2 || index >= prices.length) {
            return 0;
        }

        if (isBuy) {
            return Math.max(-prices[index] + bruteForceMaxProfit(prices, index + 1, false, transaction),
                    bruteForceMaxProfit(prices, index + 1, true, transaction));
        }

        return Math.max(prices[index] + bruteForceMaxProfit(prices, index + 1, true, transaction + 1),
                bruteForceMaxProfit(prices, index + 1, false, transaction));
    }
}

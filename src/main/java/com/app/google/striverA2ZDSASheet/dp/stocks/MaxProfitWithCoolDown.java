package com.app.google.striverA2ZDSASheet.dp.stocks;

import java.util.Arrays;

public class MaxProfitWithCoolDown {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};

        MaxProfitWithCoolDown obj = new MaxProfitWithCoolDown();
        System.out.println(obj.bruteForceMaxProfit(prices));
        System.out.println(obj.maxProfitUSingMemoization(prices));
        System.out.println(obj.maxProfitUsingTabulation(prices));
        System.out.println(obj.maxProfitUsingSpaceOptimisation(prices));
    }

    private int maxProfitUsingSpaceOptimisation(int[] prices) {
        int n = prices.length;

        int[] next = new int[2], next2 = new int[2];

        for (int index = n - 1; index >= 0; index--) {

            int[] temp = next.clone();

            for (int isBuy = 0; isBuy < 2; isBuy++) {

                if (isBuy == 1) {
                    next[isBuy] = Math.max(-prices[index] + next[0], next[1]);
                } else {
                    next[isBuy] = Math.max(prices[index] + next2[1], next[0]);
                }
            }

            next2 = temp;
        }

        return next[1];
    }

    private int maxProfitUsingTabulation(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {

            for (int isBuy = 0; isBuy < 2; isBuy++) {

                if (isBuy == 1) {
                    dp[index][isBuy] = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);
                } else {
                    dp[index][isBuy] = Math.max(prices[index] + dp[index + 2][1], dp[index + 1][0]);
                }
            }
        }

        return dp[0][1];
    }

    private int maxProfitUSingMemoization(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxProfitUSingMemoization(prices, 0, 1, dp);
    }

    private int maxProfitUSingMemoization(int[] prices, int index, int isBuy, int[][] dp) {

        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][isBuy] != -1) {
            return dp[index][isBuy];
        }

        if (isBuy == 1) {
            return dp[index][isBuy] = Math.max(-prices[index] + maxProfitUSingMemoization(prices, index + 1, 0, dp),
                    maxProfitUSingMemoization(prices, index + 1, 1, dp));
        }

        return dp[index][isBuy] = Math.max(prices[index] + maxProfitUSingMemoization(prices, index + 2, 1, dp),
                maxProfitUSingMemoization(prices, index + 1, 0, dp));
    }

    private int bruteForceMaxProfit(int[] prices) {
        return bruteForceMaxProfit(prices, 0, true);
    }

    private int bruteForceMaxProfit(int[] prices, int index, boolean isBuy) {

        if (index >= prices.length) {
            return 0;
        }

        if (isBuy) {
            return Math.max(-prices[index] + bruteForceMaxProfit(prices, index + 1, false),
                    bruteForceMaxProfit(prices, index + 1, true));
        }

        return Math.max(prices[index] + bruteForceMaxProfit(prices, index + 2, true),
                bruteForceMaxProfit(prices, index + 1, false));
    }
}

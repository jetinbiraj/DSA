package com.app.google.striverA2ZDSASheet.dp.stocks;

public class MaxProfitIV {

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};

        MaxProfitIV obj = new MaxProfitIV();
        System.out.println(obj.maxProfitUsingSpaceOptimisation(k, prices));
    }

    //TODO: refer all other approaches of MaxProfitIII, there's limit of 2 transaction and in this question transactions = k

    private int maxProfitUsingSpaceOptimisation(int k, int[] prices) {
        int n = prices.length;

        int[][] dp = new int[2][k + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy < 2; isBuy++) {
                for (int transaction = 0; transaction < k; transaction++) {

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
}

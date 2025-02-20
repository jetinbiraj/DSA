package com.app.google.striverA2ZDSASheet.dp.stocks;

public class MaxProfitI {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        MaxProfitI obj = new MaxProfitI();
        System.out.println(obj.bruteForceMaxProfit(prices));
        System.out.println(obj.betterMaxProfit(prices));
    }

    private int betterMaxProfit(int[] prices) {

        int maxProfit = 0;
        int n = prices.length;

        int buy = prices[0];
        for (int i = 1; i < n; i++) {

            if (buy < prices[i]) {
                maxProfit = Math.max(prices[i] - buy, maxProfit);
            } else {
                buy = prices[i];
            }
        }

        return maxProfit;
    }

    private int bruteForceMaxProfit(int[] prices) {

        int maxProfit = 0;
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            int buy = prices[i];
            int sell = 0;
            for (int j = i + 1; j < n; j++) {
                sell = Math.max(sell, prices[j]);
            }

            maxProfit = Math.max(maxProfit, sell - buy);
        }

        return maxProfit;
    }
}

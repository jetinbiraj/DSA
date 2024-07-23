package com.app.google.striverA2ZDSASheet.arrays.medium;

public class StockBuySell {

    public static void main(String[] args) {

        int[] arr = {7, 1, 5, 3, 6, 4};

        System.out.println("Max profit would be: " + bruteForceMaxProfit(arr));
        System.out.println("Max profit would be: " + optimalMaxProfit(arr));
    }

    private static int optimalMaxProfit(int[] arr) {

        int maxProfit = 0;

        int minElement = arr[0];

        for (int i = 1; i < arr.length; i++) {

            minElement = Math.min(minElement, arr[i]);

            maxProfit = Math.max(maxProfit, arr[i] - minElement);
        }

        return maxProfit;
    }

    private static int bruteForceMaxProfit(int[] arr) {

        int maxProfit = 0;

        for (int i = 0; i < arr.length; i++) {

            int profit = 0;

            for (int j = i + 1; j < arr.length; j++) {

                profit = Math.max(profit, arr[j] - arr[i]);

                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
    }
}

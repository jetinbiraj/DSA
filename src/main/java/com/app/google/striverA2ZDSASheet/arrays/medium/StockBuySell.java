package com.app.google.striverA2ZDSASheet.arrays.medium;

public class StockBuySell {

    public static void main(String[] args) {

        int[] arr = {7,1,5,3,6,4};

        System.out.println("Max profit would be: "+ betterMaxProfit(arr));
    }

    private static int betterMaxProfit(int[] arr) {

        int min = arr[0];

        int profit = 0;


        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < min) {
                min = arr[i];
                continue;
            }

           profit = Math.max(profit, arr[i] - min);
        }

        return profit;
    }

    //Try adding functionality for brute force
}

package com.app.google.striverA2ZDSASheet.dp.mcmpartition;

import java.util.Arrays;

public class MaxSumPartition {

    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;

        MaxSumPartition obj = new MaxSumPartition();
        System.out.println(obj.bruteForceMaxSumAfterPartitioning(arr, k));
        System.out.println(obj.maxSumAfterPartitioningUsingMemoization(arr, k));
        System.out.println(obj.maxSumAfterPartitioningUsingTabulation(arr, k));
    }

    private int maxSumAfterPartitioningUsingTabulation(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int index = n - 1; index >= 0; index--) {

            int maxSum = 0, maxNum = 0;

            for (int i = index; i < index + k && i < arr.length; i++) {
                maxNum = Math.max(maxNum, arr[i]);

                maxSum = Math.max(maxSum, ((i - index + 1) * maxNum) + dp[i + 1]);
            }

            dp[index] = maxSum;
        }

        return dp[0];
    }

    private int maxSumAfterPartitioningUsingMemoization(int[] arr, int k) {

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return maxSumAfterPartitioningUsingMemoization(arr, k, 0, dp);
    }

    private int maxSumAfterPartitioningUsingMemoization(int[] arr, int k, int index, int[] dp) {

        if (index >= arr.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int maxSum = 0, maxNum = 0;

        for (int i = index; i < index + k && i < arr.length; i++) {
            maxNum = Math.max(maxNum, arr[i]);

            maxSum = Math.max(maxSum, ((i - index + 1) * maxNum) +
                    maxSumAfterPartitioningUsingMemoization(arr, k, i + 1, dp));
        }

        return dp[index] = maxSum;
    }

    private int bruteForceMaxSumAfterPartitioning(int[] arr, int k) {

        return bruteForceMaxSumAfterPartitioning(arr, k, 0);
    }

    private int bruteForceMaxSumAfterPartitioning(int[] arr, int k, int index) {

        if (index >= arr.length) {
            return 0;
        }

        int maxSum = 0, maxNum = 0;

        for (int i = index; i < index + k && i < arr.length; i++) {
            maxNum = Math.max(maxNum, arr[i]);

            maxSum = Math.max(maxSum, ((i - index + 1) * maxNum) + bruteForceMaxSumAfterPartitioning(arr, k, i + 1));
        }

        return maxSum;
    }
}

package com.app.google.striverA2ZDSASheet.dp.oneD;

import java.util.HashMap;

public class FrogJumpKDistance {

    public static void main(String[] args) {

        int[] arr = {10, 30, 40, 50, 20};
        int k = 3;

        FrogJumpKDistance obj = new FrogJumpKDistance();
        System.out.println(obj.bruteForceMinimizeCost(k, arr));
        System.out.println(obj.minimizeCostUsingMemoization(k, arr));
        System.out.println(obj.minimizeCostUsingTabulation(k, arr));
        System.out.println(obj.minimizeCostUsingTabulation(k, arr));
        System.out.println(obj.minimizeCostUsingSpaceOptimization(k, arr));
    }

    private int minimizeCostUsingSpaceOptimization(int k, int[] arr) {

        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        int[] dp = new int[k];

        for (int i = 1; i < n; i++) {

            int minCost = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                minCost = Math.min(minCost, dp[j % k] + Math.abs(arr[i] - arr[j]));
            }
            dp[i % k] = minCost;
        }

        return dp[(n - 1) % k];
    }

    private int minimizeCostUsingTabulation(int k, int[] arr) {

        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {

            dp[i] = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            for (int j = i - 2; j >= 0 && j >= i - k; j--) {
                dp[i] = Math.min(dp[i], dp[j] + Math.abs(arr[i] - arr[j]));
            }
        }

        return dp[n - 1];
    }

    private int minimizeCostUsingTabulation(int k, int[] arr, int index, int[] dp) {


        if (index == 0) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = index - 1; i >= 0 && i >= index - k; i--) {

            if (dp[i] == -1) {
                minCost = Math.min(minCost, minimizeCostUsingTabulation(k, arr, i, dp) + Math.abs(arr[index] - arr[i]));
            } else {
                minCost = Math.min(minCost, dp[i] + Math.abs(arr[index] - arr[i]));
            }
        }

        return dp[index] = minCost;
    }

    private int minimizeCostUsingMemoization(int k, int[] arr) {
        return minimizeCostUsingMemoization(k, arr, arr.length - 1, new HashMap<>());
    }

    private int minimizeCostUsingMemoization(int k, int[] arr, int index, HashMap<Integer, Integer> memo) {


        if (index == 0) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = index - 1; i >= 0 && i >= index - k; i--) {

            if (!memo.containsKey(i)) {
                minCost = Math.min(minCost, minimizeCostUsingMemoization(k, arr, i, memo) + Math.abs(arr[index] - arr[i]));
            } else {
                minCost = Math.min(minCost, memo.get(i) + Math.abs(arr[index] - arr[i]));
            }
        }

        memo.put(index, minCost);

        return minCost;
    }

    private int bruteForceMinimizeCost(int k, int[] arr) {
        return bruteForceMinimizeCost(k, arr, arr.length - 1);
    }

    private int bruteForceMinimizeCost(int k, int[] arr, int index) {

        if (index == 0) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = index - 1; i >= 0 && i >= index - k; i--) {
            minCost = Math.min(minCost, bruteForceMinimizeCost(k, arr, i) + Math.abs(arr[index] - arr[i]));
        }

        return minCost;
    }
}

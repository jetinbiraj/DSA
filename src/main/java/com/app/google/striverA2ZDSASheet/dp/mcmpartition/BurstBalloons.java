package com.app.google.striverA2ZDSASheet.dp.mcmpartition;

import java.util.Arrays;

public class BurstBalloons {

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        BurstBalloons obj = new BurstBalloons();
        System.out.println(obj.bruteForceMaxCoins(nums));
        System.out.println(obj.maxCoinsUsingMemoization(nums));
        System.out.println(obj.maxCoinsUsingTabulation(nums));
    }

    private int maxCoinsUsingTabulation(int[] nums) {
        int n = nums.length;

        int[] newNums = new int[n + 2];
        System.arraycopy(nums, 0, newNums, 1, n);
        newNums[0] = newNums[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) {
                    continue;
                }
                int maxCoins = Integer.MIN_VALUE;

                for (int k = i; k <= j; k++) {

                    int burst = newNums[k] * newNums[i - 1] * newNums[j + 1];

                    maxCoins = Math.max(maxCoins, burst + dp[i][k - 1] + dp[k + 1][j]);
                }

                dp[i][j] = maxCoins;
            }
        }

        return dp[1][n];
    }

    private int maxCoinsUsingMemoization(int[] nums) {
        int n = nums.length;

        int[] newNums = new int[n + 2];
        System.arraycopy(nums, 0, newNums, 1, n);
        newNums[0] = newNums[n + 1] = 1;

        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return maxCoinsUsingMemoization(newNums, 1, n, dp);
    }

    private int maxCoinsUsingMemoization(int[] nums, int i, int j, int[][] dp) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int maxCoins = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {

            int burst = nums[k] * nums[i - 1] * nums[j + 1];

            maxCoins = Math.max(maxCoins, burst + maxCoinsUsingMemoization(nums, i, k - 1, dp) +
                    maxCoinsUsingMemoization(nums, k + 1, j, dp));
        }

        return dp[i][j] = maxCoins;
    }

    private int bruteForceMaxCoins(int[] nums) {
        int n = nums.length;

        int[] newNums = new int[n + 2];
        System.arraycopy(nums, 0, newNums, 1, n);
        newNums[0] = newNums[n + 1] = 1;

        return bruteForceMaxCoins(newNums, 1, n);
    }

    private int bruteForceMaxCoins(int[] nums, int i, int j) {

        if (i > j) {
            return 0;
        }

        int maxCoins = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {

            int burst = nums[k] * nums[i - 1] * nums[j + 1];

            maxCoins = Math.max(maxCoins, burst + bruteForceMaxCoins(nums, i, k - 1) +
                    bruteForceMaxCoins(nums, k + 1, j));
        }

        return maxCoins;
    }
}

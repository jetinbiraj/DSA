package com.app.google.striverA2ZDSASheet.dp.subsequences;

import java.util.Arrays;

public class PerfectSum {

    public static void main(String[] args) {
        int[] nums = {0, 10, 0};
        int target = 0;

        PerfectSum obj = new PerfectSum();
        System.out.println(obj.bruteForcePerfectSum(nums, target));
        System.out.println(obj.perfectSumUsingMemoization(nums, target));
        System.out.println(obj.perfectSumUsingTabulation(nums, target));
        System.out.println(obj.perfectSumUsingSpaceOptimisation(nums, target));
    }

    private int perfectSumUsingSpaceOptimisation(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];

        for (int i = 0; i < n; i++) {
            dp[0] = 1;
        }
        if (nums[0] <= target) {
            dp[nums[0]] = 1;
        }

        if (nums[0] == 0) {
            dp[0] = 2;
        }

        for (int index = 1; index < n; index++) {
            int[] current = new int[target+1];
            for (int tar = 0; tar <= target; tar++) {
                int notTake = dp[tar];
                int take = nums[index] <= tar ? dp[tar - nums[index]] : 0;

                current[tar] = notTake + take;
            }
            dp = current;
        }

        return dp[target];
    }

    private int perfectSumUsingTabulation(int[] nums, int target) { //TODO: More understanding required for tabulation solutions
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = 1;
        }

        if (nums[0] == 0) {
            dp[0][0] = 2;
        }

        for (int index = 1; index < n; index++) {
            for (int tar = 0; tar <= target; tar++) {
                int notTake = dp[index - 1][tar];
                int take = nums[index] <= tar ? dp[index - 1][tar - nums[index]] : 0;

                dp[index][tar] = notTake + take;
            }
        }

        return dp[n - 1][target];
    }

    private int perfectSumUsingMemoization(int[] nums, int target) {
        int[][] dp = new int[nums.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return perfectSumUsingMemoization(nums, target, nums.length - 1, dp);
    }

    private int perfectSumUsingMemoization(int[] nums, int target, int index, int[][] dp) {
        if (index == -1) {
            return target == 0 ? 1 : 0;
        }

        if (target < 0) {
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        return dp[index][target] = perfectSumUsingMemoization(nums, target - nums[index], index - 1, dp) +
                perfectSumUsingMemoization(nums, target, index - 1, dp);
    }

    private int bruteForcePerfectSum(int[] nums, int target) {
        return bruteForcePerfectSum(nums, target, 0);
    }

    private int bruteForcePerfectSum(int[] nums, int target, int index) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        if (index > nums.length || target < 0) {
            return 0;
        }

        return bruteForcePerfectSum(nums, target - nums[index], index + 1) + bruteForcePerfectSum(nums, target, index + 1);
    }
}

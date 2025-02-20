package com.app.google.striverA2ZDSASheet.dp.subsequences;

import java.util.Arrays;

public class PartitionWithDifference {

    public static void main(String[] args) {

        int[] arr = {5, 2, 6, 4};
        int d = 3;

        PartitionWithDifference obj = new PartitionWithDifference();
        System.out.println(obj.bruteForceCountPartitions(arr, d));
        System.out.println(obj.countPartitionsUsingMemoization(arr, d));
        System.out.println(obj.countPartitionsUsingTabulation(arr, d));
        System.out.println(obj.countPartitionsUsingSpaceOptimisation(arr, d));
    }

    private int countPartitionsUsingSpaceOptimisation(int[] nums, int d) {
        int n = nums.length;

        int totalSum = Arrays.stream(nums).sum();
        if (totalSum - d < 0 || (totalSum - d) % 2 == 1) {
            return 0;
        }

        int target = (totalSum - d) / 2;

        int[] dp = new int[target + 1];

        if (nums[0] == 0) {
            dp[0] = 2;
        } else {
            dp[0] = 1;
        }

        if (nums[0] != 0 && nums[0] <= target) {
            dp[nums[0]] = 1;
        }

        for (int index = 1; index < n; index++) {
            int[] current = new int[target + 1];
            for (int tar = 0; tar <= target; tar++) {
                int notTake = dp[tar];
                int take = nums[index] <= tar ? dp[tar - nums[index]] : 0;

                current[tar] = notTake + take;
            }

            dp = current;
        }

        return dp[target];
    }

    private int countPartitionsUsingTabulation(int[] nums, int d) { //TODO: More understanding required for tabulation solutions
        int n = nums.length;

        int totalSum = Arrays.stream(nums).sum();
        if (totalSum - d < 0 || (totalSum - d) % 2 == 1) {
            return 0;
        }

        int target = (totalSum - d) / 2;

        int[][] dp = new int[n][target + 1];

        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        if (nums[0] != 0 && nums[0] <= target) {
            dp[0][nums[0]] = 1;
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

    private int countPartitionsUsingMemoization(int[] arr, int d) {

        int totalSum = Arrays.stream(arr).sum();
        if (totalSum - d < 0 || (totalSum - d) % 2 == 1) {
            return 0;
        }

        int s2 = (totalSum - d) / 2;
        int[][] dp = new int[arr.length][s2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countPartitionsUsingMemoization(arr, s2, arr.length - 1, dp);
    }

    private int countPartitionsUsingMemoization(int[] nums, int target, int index, int[][] dp) {
        if (index == -1) {
            return target == 0 ? 1 : 0;
        }

        if (target < 0) {
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        return dp[index][target] = countPartitionsUsingMemoization(nums, target - nums[index], index - 1, dp) +
                countPartitionsUsingMemoization(nums, target, index - 1, dp);
    }

    private int bruteForceCountPartitions(int[] arr, int d) {

        // s1 - s2 = d
        // s1 = sum - s2
        // s2 = (sum - d)/2

        int totalSum = Arrays.stream(arr).sum();
        if (totalSum - d < 0 || (totalSum - d) % 2 == 1) {
            return 0;
        }

        int s2 = (totalSum - d) / 2;

        return bruteForcePerfectSum(arr, s2, 0);
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

package com.app.google.striverA2ZDSASheet.dp.subsequences;

import java.util.Arrays;

public class EqualPartitionSubsetSum {

    public static void main(String[] args) {
        int[] nums = {28, 4, 26, 1, 36, 42, 10, 32, 27};

        EqualPartitionSubsetSum obj = new EqualPartitionSubsetSum();
        System.out.println(obj.bruteForceCanPartition(nums));
        System.out.println(obj.canPartitionUsingMemoization(nums));
    }

    private boolean canPartitionUsingMemoization(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        Boolean[] dp = new Boolean[target + 1];

        return isSubsetSum(nums, target, nums.length - 1, dp);
    }

    private boolean isSubsetSum(int[] nums, int target, int index, Boolean[] dp) {
        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        if (index == 0) {
            return nums[index] == target;
        }

        if (dp[target] != null) {
            return dp[target];
        }

        return dp[target] = isSubsetSum(nums, target - nums[index], index - 1, dp) ||
                isSubsetSum(nums, target, index - 1, dp);
    }

    private boolean bruteForceCanPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();

        if (totalSum % 2 != 0) {
            return false;
        }

        return isSubsetSum(nums, totalSum / 2, 0);
    }

    private boolean isSubsetSum(int[] arr, int target, int index) {
        if (target == 0) {
            return true;
        }

        if (target < 0 || index >= arr.length) {
            return false;
        }

        return isSubsetSum(arr, target - arr[index], index + 1) || isSubsetSum(arr, target, index + 1);
    }
}

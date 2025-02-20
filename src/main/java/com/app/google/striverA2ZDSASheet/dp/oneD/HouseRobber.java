package com.app.google.striverA2ZDSASheet.dp.oneD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};

        HouseRobber obj = new HouseRobber();
        System.out.println(obj.bruteForceRob(nums));
        System.out.println(obj.robUsingMemoization1(nums));
        System.out.println(obj.robUsingMemoization2(nums));
        System.out.println(obj.robUsingMemoization3(nums));
        System.out.println(obj.robUsingTabulation(nums));
        System.out.println(obj.robUsingSpaceOptimization(nums));
    }

    private int robUsingSpaceOptimization(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int prev = nums[0], current = Math.max(prev, nums[1]);

        for (int i = 2; i < n; i++) {
            int temp = current;
            current = Math.max(nums[i] + prev, current);
            prev = temp;
        }

        return current;
    }

    private int robUsingTabulation(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }

    private int robUsingMemoization3(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return robUsingMemoization3(nums, 0, dp);
    }

    private int robUsingMemoization3(int[] nums, int index, int[] dp) {

        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        return dp[index] = Math.max(nums[index] + robUsingMemoization3(nums, index + 2, dp), robUsingMemoization3(nums, index + 1, dp));
    }

    private int robUsingMemoization2(int[] nums) {
        int n = nums.length, max = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            max = Math.max(max, robUsingMemoization2(nums, i, dp));
        }

        return max;
    }

    private int robUsingMemoization2(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }

        int max = 0;
        for (int i = index + 2; i < nums.length; i++) {

            int currentMax = 0;
            for (int j = i; j < nums.length; j = j + 2) {

                if (dp[j] == -1) {
                    currentMax = Math.max(currentMax, robUsingMemoization2(nums, j, dp));
                } else {
                    currentMax = Math.max(currentMax, dp[j]);
                }
            }

            max = Math.max(max, currentMax);
        }

        return dp[index] = max + nums[index];
    }

    private int robUsingMemoization1(int[] nums) {
        int n = nums.length, max = 0;

        Map<Integer, Integer> memo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            max = Math.max(max, robUsingMemoization1(nums, i, memo));
        }

        return max;
    }

    private int robUsingMemoization1(int[] nums, int index, Map<Integer, Integer> memo) {
        if (index >= nums.length) {
            return 0;
        }

        int max = 0;
        for (int i = index + 2; i < nums.length; i++) {

            int currentMax = 0;
            for (int j = i; j < nums.length; j = j + 2) {

                Integer val = memo.get(j);
                if (val != null) {
                    currentMax = Math.max(currentMax, val);
                } else {
                    currentMax = Math.max(currentMax, robUsingMemoization1(nums, j, memo));
                }
            }

            max = Math.max(max, currentMax);
        }

        memo.put(index, max + nums[index]);

        return max + nums[index];
    }

    private int bruteForceRob(int[] nums) {
        int n = nums.length, max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, bruteForceRob(nums, i));
        }

        return max;
    }

    private int bruteForceRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        int max = 0;
        for (int i = index + 2; i < nums.length; i++) {

            int currentMax = 0;
            for (int j = i; j < nums.length; j = j + 2) {
                currentMax = Math.max(currentMax, bruteForceRob(nums, j));
            }

            max = Math.max(max, currentMax);
        }

        return max + nums[index];
    }
}

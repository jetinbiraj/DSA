package com.app.google.striverA2ZDSASheet.dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {4, 10, 4, 3, 8, 9};

        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.bruteForceLengthOfLIS(nums));
        System.out.println(obj.lengthOfLISUsingMemoization(nums));
        System.out.println(obj.lengthOfLISUsingTabulation(nums));
        System.out.println(obj.lengthOfLISUsingSpaceOptimisation(nums));
        System.out.println(obj.lengthOfLIS(nums));
        System.out.println(obj.lengthOfLISUsingBinarySearch(nums));
    }

    private int lengthOfLISUsingBinarySearch(int[] nums) {

        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {

            if (lis.isEmpty() || lis.getLast() < num) {
                lis.add(num);
            } else {

                int left = 0, right = lis.size() - 1;
                boolean set = false;
                while (left < right) {

                    int mid = (left + right) / 2;
                    int midElement = lis.get(mid);
                    if (lis.get(mid) == num) {
                        set = true;
                        break;
                    } else if (midElement < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                if (!set) {
                    lis.set(right, num);
                }
            }
        }

        return lis.size();
    }

    private int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int maxLength = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    private int lengthOfLISUsingSpaceOptimisation(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {

                int taken = 0;

                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    taken = 1 + dp[index + 1];
                }

                int notTaken = dp[prevIndex + 1];

                dp[prevIndex + 1] = Math.max(taken, notTaken);
            }
        }

        return dp[0];
    }

    private int lengthOfLISUsingTabulation(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {

                int taken = 0;

                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    taken = 1 + dp[index + 1][index + 1];
                }

                int notTaken = dp[index + 1][prevIndex + 1];

                dp[index][prevIndex + 1] = Math.max(taken, notTaken);
            }
        }

        return dp[0][0];
    }

    private int lengthOfLISUsingMemoization(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return lengthOfLISUsingMemoization(nums, -1, 0, dp);
    }

    private int lengthOfLISUsingMemoization(int[] nums, int prevIndex, int index, int[][] dp) {

        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != Integer.MIN_VALUE) {
            return dp[index][prevIndex + 1];
        }

        int taken = 0;

        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            taken = 1 + lengthOfLISUsingMemoization(nums, index, index + 1, dp);
        }

        int notTaken = lengthOfLISUsingMemoization(nums, prevIndex, index + 1, dp);

        return dp[index][prevIndex + 1] = Math.max(taken, notTaken);
    }

    private int bruteForceLengthOfLIS(int[] nums) {
        return bruteForceLengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    private int bruteForceLengthOfLIS(int[] nums, int prevNum, int index) {

        if (index >= nums.length) {
            return 0;
        }

        int taken = 0;

        if (nums[index] > prevNum) {
            taken = 1 + bruteForceLengthOfLIS(nums, nums[index], index + 1);
        }

        int notTaken = bruteForceLengthOfLIS(nums, prevNum, index + 1);
        return Math.max(taken, notTaken);
    }
}

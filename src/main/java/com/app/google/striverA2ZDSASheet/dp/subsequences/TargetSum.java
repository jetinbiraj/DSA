package com.app.google.striverA2ZDSASheet.dp.subsequences;

import com.app.google.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        TargetSum obj = new TargetSum();
        System.out.println(obj.bruteForceFindTargetSumWays(nums, target));
        System.out.println(obj.findTargetSumWaysUsingMemoization(nums, target));
        System.out.println(obj.betterFindTargetSumWaysUsingMemoization(nums, target));
        System.out.println(obj.findTargetSumWaysUsingTabulation(nums, target));
        System.out.println(obj.findTargetSumWaysUsingSpaceOptimisation(nums, target));
    }

    private int findTargetSumWaysUsingSpaceOptimisation(int[] nums, int d) {
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

    private int findTargetSumWaysUsingTabulation(int[] nums, int d) {
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

    private int betterFindTargetSumWaysUsingMemoization(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum - target < 0 || (totalSum - target) % 2 == 1) {
            return 0;
        }

        int s2 = (totalSum - target) / 2;
        int[][] dp = new int[nums.length][s2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return betterFindTargetSumWaysUsingMemoization(nums, s2, nums.length - 1, dp);
    }

    private int betterFindTargetSumWaysUsingMemoization(int[] nums, int target, int index, int[][] dp) {

        if (index == -1) {
            return target == 0 ? 1 : 0;
        }

        if (target < 0) {
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        return dp[index][target] = betterFindTargetSumWaysUsingMemoization(nums, target - nums[index], index - 1, dp) +
                betterFindTargetSumWaysUsingMemoization(nums, target, index - 1, dp);
    }

    private int findTargetSumWaysUsingMemoization(int[] nums, int target) {
        Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
        return findTargetSumWaysUsingMemoization(nums, target, nums.length - 1, memo);
    }

    private int findTargetSumWaysUsingMemoization(int[] nums, int target, int index, Map<Pair<Integer, Integer>, Integer> memo) {

        if (index == -1) {
            return target == 0 ? 1 : 0;
        }

        Integer val = memo.get(new Pair<>(index, target));

        if (val != null) {
            return val;
        }

        int plus = findTargetSumWaysUsingMemoization(nums, target + nums[index], index - 1, memo);
        int minus = findTargetSumWaysUsingMemoization(nums, target - nums[index], index - 1, memo);

        memo.put(new Pair<>(index, target), plus + minus);

        return plus + minus;
    }

    private int bruteForceFindTargetSumWays(int[] nums, int target) {
        return bruteForceFindTargetSumWays(nums, target, nums.length - 1);
    }

    private int bruteForceFindTargetSumWays(int[] nums, int target, int index) {

        if (index == -1) {
            return target == 0 ? 1 : 0;
        }

        int plus = bruteForceFindTargetSumWays(nums, target + nums[index], index - 1);
        int minus = bruteForceFindTargetSumWays(nums, target - nums[index], index - 1);

        return plus + minus;
    }
}

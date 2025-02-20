package com.app.google.striverA2ZDSASheet.dp.subsequences;

import java.util.Arrays;

public class SubsetSum {

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 9;

        SubsetSum obj = new SubsetSum();
        System.out.println(obj.isSubsetSum(arr, target));
        System.out.println(obj.isSubsetSumUsingMemoization(arr, target));
        System.out.println(obj.isSubsetSumUsingTabulation(arr, target));
        System.out.println(obj.isSubsetSumUsingSpaceOptimisation(arr, target));
    }

    private Boolean isSubsetSumUsingSpaceOptimisation(int[] arr, int target) {
        int n = arr.length;
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }

        for (int index = 1; index < n; index++) {

            boolean[] current = new boolean[target + 1];
            current[0] = true;

            for (int tar = 1; tar <= target; tar++) {
                boolean notTake = prev[tar];
                boolean take = arr[index] <= tar && prev[tar - arr[index]];

                current[tar] = notTake || take;
            }

            prev = current;
        }

        return prev[target];
    }

    private Boolean isSubsetSumUsingTabulation(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            for (int tar = 1; tar <= target; tar++) {
                boolean notTake = dp[index - 1][tar];
                boolean take = arr[index] <= tar && dp[index - 1][tar - arr[index]];

                dp[index][tar] = notTake || take;
            }
        }

        return dp[n - 1][target];
    }

    private Boolean isSubsetSumUsingMemoization(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return isSubsetSumUsingMemoization(arr, target, 0, dp);
    }

    private boolean isSubsetSumUsingMemoization(int[] arr, int target, int index, int[][] dp) {
        if (target == 0) {
            return true;
        }

        if (target < 0 || index >= arr.length) {
            return false;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        boolean check = isSubsetSumUsingMemoization(arr, target - arr[index], index + 1, dp) ||
                isSubsetSumUsingMemoization(arr, target, index + 1, dp);

        dp[index][target] = check ? 1 : 0;

        return check;
    }

    private Boolean isSubsetSum(int[] arr, int target) {
        return isSubsetSum(arr, target, 0);
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

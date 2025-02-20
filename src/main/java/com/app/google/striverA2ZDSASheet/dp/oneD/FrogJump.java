package com.app.google.striverA2ZDSASheet.dp.oneD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrogJump {

    public static void main(String[] args) {

        int[] heights = {0, 17, 4, 17, 7, 17, 17, 5};
        FrogJump obj = new FrogJump();
        System.out.println(obj.bruteForceMinCost(heights));
        System.out.println(obj.minCostUsingMemoization(heights));
        System.out.println(obj.minCostUsingMemoization2(heights));
        System.out.println(obj.minCostUsingTabulation(heights));
        System.out.println(obj.minCostUsingSpaceOptimization(heights));
    }

    private int minCostUsingSpaceOptimization(int[] height) {
        int n = height.length;

        if (n == 1) {
            return 0;
        }

        int prev = 0;
        int current = Math.abs(height[0] - height[1]);

        for (int i = 2; i < n; i++) {
            int temp = current;
            current = Math.min(current + Math.abs(height[i] - height[i - 1]), prev + Math.abs(height[i] - height[i - 2]));
            prev = temp;
        }

        return current;
    }

    private int minCostUsingTabulation(int[] height) {
        int n = height.length;

        if (n == 1) {
            return 0;
        }

        int[] dp = new int[n];
        dp[1] = Math.abs(height[0] - height[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(height[i] - height[i - 1]), dp[i - 2] + Math.abs(height[i] - height[i - 2]));
        }

        return dp[n - 1];
    }

    private int minCostUsingMemoization2(int[] height) {
        int n = height.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return minCostUsingMemoization2(n - 1, height, dp);
    }

    private int minCostUsingMemoization2(int index, int[] height, int[] dp) {

        if (index == 0) {
            return 0;
        }

        if (index == 1) {
            return Math.abs(height[1] - height[0]);
        }

        return dp[index] = dp[index] == -1 ? Math.min(minCostUsingMemoization2(index - 1, height, dp) + Math.abs(height[index] - height[index - 1]),
                minCostUsingMemoization2(index - 2, height, dp) + Math.abs(height[index] - height[index - 2])) : dp[index];
    }

    private int minCostUsingMemoization(int[] height) {
        return minCostUsingMemoization(height.length - 1, height, new HashMap<>());
    }

    private int minCostUsingMemoization(int index, int[] height, Map<Integer, Integer> memo) {

        if (index == 0) {
            return 0;
        }

        if (index == 1) {
            return Math.abs(height[1] - height[0]);
        }

        if (!memo.containsKey(index)) {
            memo.put(index, Math.min(minCostUsingMemoization(index - 1, height, memo) + Math.abs(height[index] - height[index - 1]), minCostUsingMemoization(index - 2, height, memo) + Math.abs(height[index] - height[index - 2])));
        }

        return memo.get(index);
    }

    private int bruteForceMinCost(int[] height) {

        return bruteForceMinCost(height.length - 1, height);
    }

    private int bruteForceMinCost(int index, int[] height) {

        if (index == 0) {
            return 0;
        }

        if (index == 1) {
            return Math.abs(height[1] - height[0]);
        }

        int pass1 = bruteForceMinCost(index - 1, height) + Math.abs(height[index] - height[index - 1]);
        int pass2 = bruteForceMinCost(index - 2, height) + Math.abs(height[index] - height[index - 2]);

        return Math.min(pass1, pass2);
    }
}

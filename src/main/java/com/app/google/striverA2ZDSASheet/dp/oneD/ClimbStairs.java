package com.app.google.striverA2ZDSASheet.dp.oneD;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    public static void main(String[] args) {

        int n = 45;

        ClimbStairs obj = new ClimbStairs();
//        System.out.println(obj.bruteForceClimbStairs(n));
        System.out.println(obj.betterClimbStairs(n));
        System.out.println(obj.betterClimbStairs2(n));
    }

    /**
     * Space optimized solution
     *
     * @param n steps
     * @return distinct ways/steps to reach the top.
     */
    private int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int current = 1, prev = 1;

        for (int i = 2; i <= n; i++) {
            int temp = current;
            current += prev;
            prev = temp;
        }

        return current;
    }


    /**
     * Solution using Memoization
     *
     * @param n steps
     * @return distinct ways/steps to reach the top.
     */
    public int betterClimbStairs2(int n) {
        return climb(n, new HashMap<>());
    }

    private int climb(int n, Map<Integer, Integer> memo) {

        if (n <= 1) {
            return 1;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, climb(n - 1, memo) + climb(n - 2, memo));
        }

        return memo.get(n);
    }


    /**
     * Solution using tabulation
     *
     * @param n steps
     * @return distinct ways/steps to reach the top.
     */
    private int betterClimbStairs(int n) {
        return betterClimbStairs(n, new int[n]);
    }

    private int betterClimbStairs(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }

        dp[n - 1] = dp[n - 1] != 0 ? dp[n - 1] : betterClimbStairs(n - 1, dp);
        dp[n - 2] = dp[n - 2] != 0 ? dp[n - 2] : betterClimbStairs(n - 2, dp);

        return dp[n - 1] + dp[n - 2];
    }

    /**
     * Simple recursive solution
     *
     * @param n steps
     * @return distinct ways/steps to reach the top.
     */
    private int bruteForceClimbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        return bruteForceClimbStairs(n - 1) + bruteForceClimbStairs(n - 2);
    }
}

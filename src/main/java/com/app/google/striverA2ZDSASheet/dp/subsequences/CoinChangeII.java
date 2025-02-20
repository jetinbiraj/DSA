package com.app.google.striverA2ZDSASheet.dp.subsequences;

import java.util.Arrays;

public class CoinChangeII {

    public static void main(String[] args) {

        int amount = 5;
        int[] coins = {1, 2, 5};

        CoinChangeII obj = new CoinChangeII();
        System.out.println(obj.bruteForceChange(amount, coins));
        System.out.println(obj.changeUsingMemoization(amount, coins));
        System.out.println(obj.changeUsingTabulation(amount, coins));
        System.out.println(obj.changeUsingSpaceOptimization(amount, coins));
    }

    private int changeUsingSpaceOptimization(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0) {
                dp[amt] = 1;
            }
        }

        for (int index = 1; index < n; index++) {
            int[] current = new int[amount + 1];
            for (int amt = 0; amt <= amount; amt++) {

                int pick = amt >= coins[index] ? current[amt - coins[index]] : 0;
                int notPick = dp[amt];

                current[amt] = pick + notPick;
            }

            dp = current;
        }

        return dp[amount];
    }

    private int changeUsingTabulation(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0) {
                dp[0][amt] = 1;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int amt = 0; amt <= amount; amt++) {

                int pick = amt >= coins[index] ? dp[index][amt - coins[index]] : 0;
                int notPick = dp[index - 1][amt];

                dp[index][amt] = pick + notPick;
            }
        }

        return dp[n - 1][amount];
    }

    private int changeUsingMemoization(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return changeUsingMemoization(amount, coins, coins.length - 1, dp);
    }

    private int changeUsingMemoization(int amount, int[] coins, int index, int[][] dp) {

        if (amount == 0) {
            return 1;
        }

        if (index < 0 || amount < 0) {
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int pick = changeUsingMemoization(amount - coins[index], coins, index, dp);
        int notPick = changeUsingMemoization(amount, coins, index - 1, dp);

        return dp[index][amount] = pick + notPick;
    }

    private int bruteForceChange(int amount, int[] coins) {
        return bruteForceChange(amount, coins, coins.length - 1);
    }

    private int bruteForceChange(int amount, int[] coins, int index) {

        if (amount == 0) {
            return 1;
        }

        if (index < 0 || amount < 0) {
            return 0;
        }

        int notPick = bruteForceChange(amount, coins, index - 1);
        int pick = bruteForceChange(amount - coins[index], coins, index);

        return pick + notPick;
    }
}

package com.app.google.striverA2ZDSASheet.dp.subsequences;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;

        CoinChange obj = new CoinChange();
        System.out.println(obj.bruteForceCoinChange(coins, amount));
        System.out.println(obj.coinChangeUsingMemoization(coins, amount));
        System.out.println(obj.coinChangeUsingTabulation(coins, amount));
        System.out.println(obj.coinChangeUsingSpaceOptimisation(coins, amount));
    }

    private int coinChangeUsingSpaceOptimisation(int[] coins, int amount) {

        int n = coins.length;

        int[] dp = new int[amount + 1];
        for (int amt = 0; amt <= amount; amt++) {
            dp[amt] = amt % coins[0] == 0 ? amt / coins[0] : (int) 1e9;
        }

        for (int i = 1; i < n; i++) {

            int[] current = new int[amount + 1];

            for (int amt = 0; amt <= amount; amt++) {

                int notPick = dp[amt];
                int pick = coins[i] <= amt ? (1 + current[amt - coins[i]]) : (int) 1e9;

                current[amt] = Math.min(notPick, pick);
            }

            dp = current;
        }

        return dp[amount] >= (int) 1e9 ? -1 : dp[amount];
    }

    private int coinChangeUsingTabulation(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (int amt = 0; amt <= amount; amt++) {
            dp[0][amt] = amt % coins[0] == 0 ? amt / coins[0] : (int) 1e9;
        }

        for (int i = 1; i < n; i++) {

            for (int amt = 0; amt <= amount; amt++) {

                int notPick = dp[i - 1][amt];
                int pick = coins[i] <= amt ? (1 + dp[i][amt - coins[i]]) : (int) 1e9;

                dp[i][amt] = Math.min(notPick, pick);
            }
        }

        return dp[n - 1][amount] >= (int) 1e9 ? -1 : dp[n - 1][amount];
    }

    private int coinChangeUsingMemoization(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int change = coinChangeUsingMemoization(coins, amount, n - 1, dp);

        return change >= (int) 1e9 ? -1 : change;
    }

    private int coinChangeUsingMemoization(int[] coins, int amount, int index, int[][] dp) {
        if (index == 0) {
            return amount % coins[0] == 0 ? amount / coins[0] : (int) 1e9;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int notPick = coinChangeUsingMemoization(coins, amount, index - 1, dp);
        int pick = coins[index] <= amount ? (1 + coinChangeUsingMemoization(coins, amount - coins[index], index, dp)) : (int) 1e9;

        return dp[index][amount] = Math.min(notPick, pick);
    }

    private int bruteForceCoinChange(int[] coins, int amount) {

        int change = bruteForceCoinChange(coins, amount, coins.length - 1);

        return change >= (int) 1e9 ? -1 : change;
    }

    private int bruteForceCoinChange(int[] coins, int amount, int index) {
        if (index == 0) {
            return amount % coins[0] == 0 ? amount / coins[0] : (int) 1e9;
        }

        int notPick = bruteForceCoinChange(coins, amount, index - 1);
        int pick = coins[index] <= amount ? (1 + bruteForceCoinChange(coins, amount - coins[index], index)) : (int) 1e9;

        return Math.min(notPick, pick);
    }
}

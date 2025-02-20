package com.app.google.striverA2ZDSASheet.dp.strings;

import java.util.Arrays;

public class MinInsertionsPalindrome {

    public static void main(String[] args) {
        String s = "leetcode";

        MinInsertionsPalindrome obj = new MinInsertionsPalindrome();

        System.out.println(obj.betterMinInsertions(s));
        System.out.println(obj.minInsertionsUsingMemoization(s));
        System.out.println(obj.minInsertionsUsingTabulation(s));
        System.out.println(obj.minInsertionsUsingSpaceOptimisation(s));
    }

    private int minInsertionsUsingSpaceOptimisation(String str) {
        return str.length() - minInsertionsUsingSpaceOptimisation(str, new StringBuilder(str).reverse().toString());
    }

    private int minInsertionsUsingSpaceOptimisation(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();

        int[] prev = new int[n2 + 1];

        for (int i = 1; i <= n1; i++) {
            int[] current = new int[n2 + 1];
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    current[j] = 1 + prev[j - 1];
                } else {
                    current[j] = Math.max(current[j - 1], prev[j]);
                }
            }

            prev = current;
        }

        return prev[n2];
    }

    public int minInsertionsUsingTabulation(String str) {
        return str.length() - minInsertionsUsingTabulation(str, new StringBuilder(str).reverse().toString());
    }

    private int minInsertionsUsingTabulation(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n1][n2];
    }

    public int minInsertionsUsingMemoization(String str) {
        return str.length() - minInsertionsUsingMemoization(str, new StringBuilder(str).reverse().toString());
    }

    private int minInsertionsUsingMemoization(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();

        int[][] dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minInsertionsUsingMemoization(text1, n1 - 1, text2, n2 - 1, dp);
    }

    private int minInsertionsUsingMemoization(String text1, int index1, String text2, int index2, int[][] dp) {

        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return dp[index1][index2] = 1 + minInsertionsUsingMemoization(text1, index1 - 1, text2, index2 - 1, dp);
        }

        return dp[index1][index2] = Math.max(minInsertionsUsingMemoization(text1, index1, text2, index2 - 1, dp),
                minInsertionsUsingMemoization(text1, index1 - 1, text2, index2, dp));
    }

    // This solution kinda brute force only
    private int betterMinInsertions(String str) {
        return str.length() - betterMinInsertions(str, new StringBuilder(str).reverse().toString());
    }

    private int betterMinInsertions(String text1, String text2) {
        return betterMinInsertions(text1, text1.length() - 1, text2, text2.length() - 1);
    }

    private int betterMinInsertions(String text1, int index1, String text2, int index2) {

        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + betterMinInsertions(text1, index1 - 1, text2, index2 - 1);
        }

        return Math.max(betterMinInsertions(text1, index1, text2, index2 - 1),
                betterMinInsertions(text1, index1 - 1, text2, index2));
    }
}

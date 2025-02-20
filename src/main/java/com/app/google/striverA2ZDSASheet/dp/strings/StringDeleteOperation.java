package com.app.google.striverA2ZDSASheet.dp.strings;

import java.util.Arrays;

public class StringDeleteOperation {

    public static void main(String[] args) {
        String word1 = "leetcode", word2 = "etco";

        StringDeleteOperation obj = new StringDeleteOperation();
        System.out.println(obj.bruteForceMinDistance(word1, word2));
        System.out.println(obj.minDistanceUsingMemoization(word1, word2));
        System.out.println(obj.minDistanceUsingTabulation(word1, word2));
        System.out.println(obj.minDistanceUsingSpaceOptimisation(word1, word2));
    }

    private int minDistanceUsingSpaceOptimisation(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();

        int[] prev = new int[n2 + 1];

        for (int i = 1; i <= n1; i++) {
            int[] current = new int[n2 + 1];
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    current[j] = 1 + prev[j - 1];
                } else {
                    current[j] = Math.max(current[j - 1], prev[j]);
                }
            }

            prev = current;
        }

        return n1 + n2 - (2 * prev[n2]);
    }

    private int minDistanceUsingTabulation(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return n1 + n2 - (2 * dp[n1][n2]);
    }

    private int minDistanceUsingMemoization(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();

        int[][] dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int lcs = longestCommonSubsequenceUsingMemoization(word1, word2, n1 - 1, n2 - 1, dp);

        return n1 + n2 - (2 * lcs);
    }

    private int longestCommonSubsequenceUsingMemoization(String word1, String word2, int index1, int index2, int[][] dp) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return dp[index1][index2] = 1 + longestCommonSubsequenceUsingMemoization(word1, word2, index1 - 1, index2 - 1, dp);
        }

        return dp[index1][index2] = Math.max(longestCommonSubsequenceUsingMemoization(word1, word2, index1, index2 - 1, dp),
                longestCommonSubsequenceUsingMemoization(word1, word2, index1 - 1, index2, dp));
    }

    private int bruteForceMinDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();

        int lcs = bruteForceLongestCommonSubsequence(word1, word2, n1 - 1, n2 - 1);

        return n1 + n2 - (2 * lcs);
    }

    private int bruteForceLongestCommonSubsequence(String word1, String word2, int index1, int index2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return 1 + bruteForceLongestCommonSubsequence(word1, word2, index1 - 1, index2 - 1);
        }

        return Math.max(bruteForceLongestCommonSubsequence(word1, word2, index1, index2 - 1),
                bruteForceLongestCommonSubsequence(word1, word2, index1 - 1, index2));
    }
}

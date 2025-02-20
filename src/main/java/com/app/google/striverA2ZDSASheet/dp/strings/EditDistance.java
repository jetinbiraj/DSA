package com.app.google.striverA2ZDSASheet.dp.strings;

import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {

        String word1 = "horse", word2 = "ros";

        EditDistance obj = new EditDistance();
        System.out.println(obj.bruteForceMinDistance(word1, word2));
        System.out.println(obj.minDistanceUsingMemoization(word1, word2));
        System.out.println(obj.minDistanceUsingTabulation(word1, word2));
        System.out.println(obj.minDistanceUsingSpaceOptimisation(word1, word2));
    }

    private int minDistanceUsingSpaceOptimisation(String word1, String word2) {

        int n1 = word1.length(), n2 = word2.length();
        int[] prev = new int[n2 + 1];

        for (int j = 0; j <= n2; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n1; i++) {

            int[] current = new int[n2 + 1];
            current[0] = i;

            for (int j = 1; j <= n2; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    current[j] = prev[j - 1];
                } else {
                    int insert = current[j - 1];
                    int delete = prev[j];
                    int replace = prev[j - 1];

                    current[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }

            prev = current;
        }

        return prev[n2];
    }

    private int minDistanceUsingTabulation(String word1, String word2) {

        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n1][n2];
    }

    private int minDistanceUsingMemoization(String word1, String word2) {

        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return minDistanceUsingMemoization(word1, n1 - 1, word2, n2 - 1, dp);
    }

    private int minDistanceUsingMemoization(String word1, int index1, String word2, int index2, int[][] dp) {

        if (index1 < 0) {
            return index2 + 1;
        }

        if (index2 < 0) {
            return index1 + 1;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return dp[index1][index2] = minDistanceUsingMemoization(word1, index1 - 1, word2, index2 - 1, dp);
        }

        int insert = minDistanceUsingMemoization(word1, index1, word2, index2 - 1, dp);
        int delete = minDistanceUsingMemoization(word1, index1 - 1, word2, index2, dp);
        int replace = minDistanceUsingMemoization(word1, index1 - 1, word2, index2 - 1, dp);

        return dp[index1][index2] = 1 + Math.min(insert, Math.min(delete, replace));
    }

    private int bruteForceMinDistance(String word1, String word2) {

        int n1 = word1.length(), n2 = word2.length();

        return bruteForceMinDistance(word1, n1 - 1, word2, n2 - 1);
    }

    private int bruteForceMinDistance(String word1, int index1, String word2, int index2) {

        if (index1 < 0) {
            return index2 + 1;
        }

        if (index2 < 0) {
            return index1 + 1;
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return bruteForceMinDistance(word1, index1 - 1, word2, index2 - 1);
        }

        int insert = bruteForceMinDistance(word1, index1, word2, index2 - 1);
        int delete = bruteForceMinDistance(word1, index1 - 1, word2, index2);
        int replace = bruteForceMinDistance(word1, index1 - 1, word2, index2 - 1);

        return 1 + Math.min(insert, Math.min(delete, replace));
    }
}

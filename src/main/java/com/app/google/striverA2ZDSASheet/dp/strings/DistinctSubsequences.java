package com.app.google.striverA2ZDSASheet.dp.strings;

import java.util.Arrays;

public class DistinctSubsequences {

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";

        DistinctSubsequences obj = new DistinctSubsequences();
        System.out.println(obj.bruteForceNumDistinct(s, t));
        System.out.println(obj.numDistinctUsingMemoization(s, t));
        System.out.println(obj.numDistinctUsingTabulation(s, t));
        System.out.println(obj.numDistinctUsingSpaceOptimisation(s, t));
        System.out.println(obj.numDistinctUsingSpaceOptimisationFurther(s, t));
    }

    private int numDistinctUsingSpaceOptimisationFurther(String s, String t) {

        int n1 = s.length(), n2 = t.length();

        int[] dp = new int[n2 + 1];
        dp[0] = 1;

        for (int i = 1; i <= n1; i++) {
            for (int j =n2; j >= 1; j--) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }

        return dp[n2];
    }

    private int numDistinctUsingSpaceOptimisation(String s, String t) {

        int n1 = s.length(), n2 = t.length();

        int[] prev = new int[n2 + 1], current = new int[n2 + 1];
        prev[0] = current[0] = 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    current[j] = prev[j - 1] + prev[j];
                } else {
                    current[j] = prev[j];
                }
            }

            prev = current.clone();
        }

        return prev[n2];
    }

    private int numDistinctUsingTabulation(String s, String t) {

        int n1 = s.length(), n2 = t.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n1][n2];
    }

    private int numDistinctUsingMemoization(String s, String t) {

        int n1 = s.length(), n2 = t.length();

        int[][] dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return numDistinctUsingMemoization(s, t, n1 - 1, n2 - 1, dp);
    }

    private int numDistinctUsingMemoization(String s, String t, int index1, int index2, int[][] dp) {

        if (index2 < 0) {
            return 1;
        }

        if (index1 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (s.charAt(index1) == t.charAt(index2)) {

            int consider = numDistinctUsingMemoization(s, t, index1 - 1, index2 - 1, dp);
            int notConsider = numDistinctUsingMemoization(s, t, index1 - 1, index2, dp);

            return dp[index1][index2] = consider + notConsider;
        }

        return dp[index1][index2] = numDistinctUsingMemoization(s, t, index1 - 1, index2, dp);
    }

    private int bruteForceNumDistinct(String s, String t) {

        int n1 = s.length(), n2 = t.length();
        return bruteForceNumDistinct(s, t, n1 - 1, n2 - 1);
    }

    private int bruteForceNumDistinct(String s, String t, int index1, int index2) {

        if (index2 < 0) {
            return 1;
        }

        if (index1 < 0) {
            return 0;
        }

        if (s.charAt(index1) == t.charAt(index2)) {

            int consider = bruteForceNumDistinct(s, t, index1 - 1, index2 - 1);
            int notConsider = bruteForceNumDistinct(s, t, index1 - 1, index2);

            return consider + notConsider;
        }

        return bruteForceNumDistinct(s, t, index1 - 1, index2);
    }
}

package com.app.google.striverA2ZDSASheet.dp.strings;

import java.util.Arrays;

public class WildcardMatching {

    public static void main(String[] args) {

        String s = "aa", p = "*";

        WildcardMatching obj = new WildcardMatching();
        System.out.println(obj.bruteForceIsMatch(s, p));
        System.out.println(obj.isMatchUsingMemoization(s, p));
        System.out.println(obj.isMatchUsingTabulation(s, p));
        System.out.println(obj.isMatchUsingSpaceOptimisation(s, p));
    }

    private boolean isMatchUsingSpaceOptimisation(String s, String p) {

        int n1 = s.length(), n2 = p.length();

        boolean[] prev = new boolean[n2 + 1];
        prev[0] = true;

        for (int i = 1; i <= n2; i++) {
            if (p.charAt(i - 1) == '*') {
                prev[i] = prev[i - 1];
            }
        }

        for (int index1 = 1; index1 <= n1; index1++) {
            boolean[] current = new boolean[n2 + 1];
            for (int index2 = 1; index2 <= n2; index2++) {

                if (s.charAt(index1 - 1) == p.charAt(index2 - 1) || p.charAt(index2 - 1) == '?') {
                    current[index2] = prev[index2 - 1];
                } else if (p.charAt(index2 - 1) == '*') {
                    current[index2] = current[index2 - 1] || prev[index2];
                }
            }

            prev = current;
        }

        return prev[n2];
    }

    private boolean isMatchUsingTabulation(String s, String p) {

        int n1 = s.length(), n2 = p.length();

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n2; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int index1 = 1; index1 <= n1; index1++) {
            for (int index2 = 1; index2 <= n2; index2++) {

                if (s.charAt(index1 - 1) == p.charAt(index2 - 1) || p.charAt(index2 - 1) == '?') {
                    dp[index1][index2] = dp[index1 - 1][index2 - 1];
                } else if (p.charAt(index2 - 1) == '*') {
                    dp[index1][index2] = dp[index1][index2 - 1] || dp[index1 - 1][index2];
                }
            }
        }

        return dp[n1][n2];
    }

    private boolean isMatchUsingMemoization(String s, String p) {

        int n1 = s.length(), n2 = p.length();

        int[][] dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return isMatchUsingMemoization(s, p, n1 - 1, n2 - 1, dp);
    }

    private boolean isMatchUsingMemoization(String s, String p, int index1, int index2, int[][] dp) {

        if (index1 < 0 && index2 < 0) {
            return true;
        }

        if (index2 < 0) {
            return false;
        }

        if (index1 < 0) {
            for (int i = index2; i >= 0; i--) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }

            return true;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2] == 1;
        }

        if (s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '?') {
            boolean match = isMatchUsingMemoization(s, p, index1 - 1, index2 - 1, dp);
            dp[index1][index2] = match ? 1 : 0;
            return match;
        }

        if (p.charAt(index2) == '*') {
            boolean match = isMatchUsingMemoization(s, p, index1, index2 - 1, dp) || isMatchUsingMemoization(s, p, index1 - 1, index2, dp);
            dp[index1][index2] = match ? 1 : 0;
            return match;
        }

        dp[index1][index2] = 0;
        return false;
    }

    private boolean bruteForceIsMatch(String s, String p) {

        return bruteForceIsMatch(s, p, s.length() - 1, p.length() - 1);
    }

    private boolean bruteForceIsMatch(String s, String p, int index1, int index2) {

        if (index1 < 0 && index2 < 0) {
            return true;
        }

        if (index1 < 0) {
            for (int i = index2; i >= 0; i--) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }

            return true;
        }

        if (index2 < 0) {
            return false;
        }

        if (s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '?') {
            return bruteForceIsMatch(s, p, index1 - 1, index2 - 1);
        }

        if (p.charAt(index2) == '*') {
            return bruteForceIsMatch(s, p, index1, index2 - 1) || bruteForceIsMatch(s, p, index1 - 1, index2);
        }

        return false;
    }
}

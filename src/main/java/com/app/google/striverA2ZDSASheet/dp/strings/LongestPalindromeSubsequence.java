package com.app.google.striverA2ZDSASheet.dp.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestPalindromeSubsequence {

    public static void main(String[] args) {
        String str = "bbbab";

        LongestPalindromeSubsequence obj = new LongestPalindromeSubsequence();
        System.out.println(obj.bruteForceLongestPalindromeSubseq(str));
        System.out.println(obj.betterLongestPalindromeSubseq(str));
        System.out.println(obj.longestPalindromeSubseqUsingMemoization(str));
        System.out.println(obj.longestPalindromeSubseqUsingTabulation(str));
        System.out.println(obj.longestPalindromeSubseqUsingSpaceOptimisation(str));
    }

    public int longestPalindromeSubseqUsingSpaceOptimisation(String s) {
        return longestPalindromeSubseqUsingSpaceOptimisation(s, new StringBuilder(s).reverse().toString());
    }

    private int longestPalindromeSubseqUsingSpaceOptimisation(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[] prev = new int[n2 + 1];

        for (int i = 1; i <= n1; i++) {
            int[] current = new int[n2 + 1];
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    current[j] = 1 + prev[j - 1];
                } else {
                    current[j] = Math.max(prev[j], current[j - 1]);
                }
            }

            prev = current;
        }

        return prev[n2];
    }

    private int longestPalindromeSubseqUsingTabulation(String s) {
        return longestPalindromeSubseqUsingTabulation(s, new StringBuilder(s).reverse().toString());
    }

    private int longestPalindromeSubseqUsingTabulation(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n1][n2];
    }

    private int longestPalindromeSubseqUsingMemoization(String str) {
        return longestPalindromeSubseqUsingMemoization(str, new StringBuilder(str).reverse().toString());
    }

    private int longestPalindromeSubseqUsingMemoization(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return longestPalindromeSubseqUsingMemoization(text1, n1 - 1, text2, n2 - 1, dp);
    }

    private int longestPalindromeSubseqUsingMemoization(String text1, int index1, String text2, int index2, int[][] dp) {

        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return dp[index1][index2] = 1 + longestPalindromeSubseqUsingMemoization(text1, index1 - 1, text2, index2 - 1, dp);
        }

        return dp[index1][index2] = Math.max(longestPalindromeSubseqUsingMemoization(text1, index1, text2, index2 - 1, dp),
                longestPalindromeSubseqUsingMemoization(text1, index1 - 1, text2, index2, dp));
    }

    private int betterLongestPalindromeSubseq(String str) {
        return betterLongestPalindromeSubseq(str, new StringBuilder(str).reverse().toString());
    }

    private int betterLongestPalindromeSubseq(String text1, String text2) {
        return betterLongestPalindromeSubseq(text1, text1.length() - 1, text2, text2.length() - 1);
    }

    private int betterLongestPalindromeSubseq(String text1, int index1, String text2, int index2) {

        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + betterLongestPalindromeSubseq(text1, index1 - 1, text2, index2 - 1);
        }

        return Math.max(betterLongestPalindromeSubseq(text1, index1, text2, index2 - 1),
                betterLongestPalindromeSubseq(text1, index1 - 1, text2, index2));
    }

    private int bruteForceLongestPalindromeSubseq(String s) {

        Set<String> set = new HashSet<>();

        subsequences(s, 0, set, new StringBuilder());

        int longestPalindromeSubseq = 0;

        System.out.println(set);

        for (String str : set) {
            if (isPalindrome(str)) {
                longestPalindromeSubseq = Math.max(longestPalindromeSubseq, str.length());
            }
        }

        return longestPalindromeSubseq;
    }

    private void subsequences(String s, int index, Set<String> set, StringBuilder sb) {
        if (!sb.isEmpty()) {
            set.add(sb.toString());
        }

        if (index >= s.length()) {
            return;
        }

        sb.append(s.charAt(index));
        subsequences(s, index + 1, set, sb);
        sb.deleteCharAt(sb.length() - 1);

        subsequences(s, index + 1, set, sb);
    }

    private boolean isPalindrome(String s) {

        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}

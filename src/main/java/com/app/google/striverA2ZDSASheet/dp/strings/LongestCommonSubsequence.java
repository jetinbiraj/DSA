package com.app.google.striverA2ZDSASheet.dp.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String text1 = "abcde", text2 = "ace";

        LongestCommonSubsequence obj = new LongestCommonSubsequence();

        System.out.println(obj.bruteForceLongestCommonSubsequence(text1, text2));
        System.out.println(obj.betterLongestCommonSubsequence(text1, text2));
        System.out.println(obj.longestCommonSubsequenceUsingMemoization(text1, text2));
        System.out.println(obj.longestCommonSubsequenceUsingTabulation(text1, text2));
        System.out.println(obj.longestCommonSubsequenceUsingSpaceOptimisation(text1, text2));
    }

    private int longestCommonSubsequenceUsingSpaceOptimisation(String text1, String text2) {

        int n1 = text1.length(), n2 = text2.length();

        int[] prev = new int[n2 + 1];
        //Indexes have been shifted

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

    private int longestCommonSubsequenceUsingTabulation(String text1, String text2) {

        int n1 = text1.length(), n2 = text2.length();

        int[][] dp = new int[n1 + 1][n2 + 1]; //Indexes have been shifted by 1

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

    private int longestCommonSubsequenceUsingMemoization(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();

        int[][] dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return longestCommonSubsequenceUsingMemoization(text1, text1.length() - 1, text2, text2.length() - 1, dp);
    }

    private int longestCommonSubsequenceUsingMemoization(String text1, int index1, String text2, int index2, int[][] dp) {

        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return dp[index1][index2] = 1 + longestCommonSubsequenceUsingMemoization(text1, index1 - 1, text2, index2 - 1, dp);
        }

        return dp[index1][index2] = Math.max(longestCommonSubsequenceUsingMemoization(text1, index1, text2, index2 - 1, dp),
                longestCommonSubsequenceUsingMemoization(text1, index1 - 1, text2, index2, dp));
    }

    private int betterLongestCommonSubsequence(String text1, String text2) {
        return betterLongestCommonSubsequence(text1, text1.length() - 1, text2, text2.length() - 1);
    }

    private int betterLongestCommonSubsequence(String text1, int index1, String text2, int index2) {

        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + betterLongestCommonSubsequence(text1, index1 - 1, text2, index2 - 1);
        }

        return Math.max(betterLongestCommonSubsequence(text1, index1, text2, index2 - 1),
                betterLongestCommonSubsequence(text1, index1 - 1, text2, index2));
    }

    private int bruteForceLongestCommonSubsequence(String text1, String text2) {

        Set<String> set1 = new HashSet<>(), set2 = new HashSet<>();

        addSequences(text1, 0, set1, new StringBuilder());
        addSequences(text2, 0, set2, new StringBuilder());

        int lcs = 0;

        if (set1.size() < set2.size()) {

            for (String subSequence : set1) {
                if (set2.contains(subSequence)) {
                    lcs = Math.max(lcs, subSequence.length());
                }
            }

        } else {

            for (String subSequence : set2) {
                if (set1.contains(subSequence)) {
                    lcs = Math.max(lcs, subSequence.length());
                }
            }
        }

        return lcs;
    }

    private void addSequences(String text, int index, Set<String> set, StringBuilder sb) {

        if (!sb.isEmpty()) {
            set.add(sb.toString());
        }

        if (index >= text.length()) {
            return;
        }

        addSequences(text, index + 1, set, sb);
        addSequences(text, index + 1, set, sb.append(text.charAt(index)));
        sb.deleteCharAt(sb.length() - 1);
    }
}

package com.app.google.striverA2ZDSASheet.dp.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "ABCDGH", s2 = "ACDGHR";

        LongestCommonSubstring obj = new LongestCommonSubstring();
        System.out.println(obj.bruteForceLongestCommonSubstr(s1, s2));
        System.out.println(obj.betterLongestCommonSubstr(s1, s2));
        System.out.println(obj.longestCommonSubstringUsingTabulation(s1, s2));
        System.out.println(obj.longestCommonSubstrUsingSpaceOptimisation(s1, s2));
    }

    private int longestCommonSubstrUsingSpaceOptimisation(String text1, String text2) {

        int n1 = text1.length(), n2 = text2.length(), lcs = 0;

        int[] prev = new int[n2 + 1]; //Indexes have been shifted by 1

        for (int i = 1; i <= n1; i++) {
            int[] current = new int[n2 + 1];
            for (int j = 1; j <= n2; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    current[j] = 1 + prev[j - 1];
                }

                lcs = Math.max(lcs, current[j]);
            }

            prev = current;
        }

        return lcs;
    }

    private int longestCommonSubstringUsingTabulation(String text1, String text2) {

        int n1 = text1.length(), n2 = text2.length(), lcs = 0;

        int[][] dp = new int[n1 + 1][n2 + 1]; //Indexes have been shifted by 1

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }

                lcs = Math.max(lcs, dp[i][j]);
            }
        }

        return lcs;
    }

    private int betterLongestCommonSubstr(String text1, String text2) {
        return betterLongestCommonSubstr(text1, text2, text1.length() - 1, text2.length() - 1, 0);
    }

    private int betterLongestCommonSubstr(String text1, String text2, int index1, int index2, int maxLength) {
        if (index1 < 0 || index2 < 0) {
            return maxLength;
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            maxLength = betterLongestCommonSubstr(text1, text2, index1 - 1, index2 - 1, maxLength + 1);
        }

        int skip1 = betterLongestCommonSubstr(text1, text2, index1, index2 - 1, 0);
        int skip2 = betterLongestCommonSubstr(text1, text2, index1 - 1, index2, 0);

        return Math.max(maxLength, Math.max(skip1, skip2));
    }

    private int bruteForceLongestCommonSubstr(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        Set<String> substrings1 = new HashSet<>();
        Set<String> substrings2 = new HashSet<>();

        for (int i = 0; i < n1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n1; j++) {
                sb.append(s1.charAt(j));

                substrings1.add(sb.toString());
            }
        }

        for (int i = 0; i < n2; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n2; j++) {
                sb.append(s2.charAt(j));

                substrings2.add(sb.toString());
            }
        }

        int lcs = 0;
        if (substrings1.size() < substrings2.size()) {
            for (String substring : substrings1) {
                if (substrings2.contains(substring)) {
                    lcs = Math.max(lcs, substring.length());
                }
            }
        } else {
            for (String substring : substrings2) {
                if (substrings1.contains(substring)) {
                    lcs = Math.max(lcs, substring.length());
                }
            }
        }

        return lcs;
    }
}

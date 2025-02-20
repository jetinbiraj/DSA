package com.app.google.striverA2ZDSASheet.dp.mcmpartition;

import java.util.Arrays;

public class PalindromePartitioningII {

    public static void main(String[] args) {

//        String s = "bababcbadcede";
        String s = "aab";

        PalindromePartitioningII obj = new PalindromePartitioningII();
        System.out.println(obj.bruteForceMinCut(s));
        System.out.println(obj.minCutUsingMemoization(s));
        System.out.println(obj.minCutUsingTabulation(s));
        System.out.println(obj.optimalMinCut(s));
    }

    private int optimalMinCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            int minCut = Integer.MAX_VALUE;
            for (int k = i; k < n; k++) {

                if (isPalindrome[i][k]) {
                    minCut = Math.min(minCut, 1 + dp[k + 1]);
                }
            }

            dp[i] = minCut;
        }

        return dp[0] - 1;
    }

    private int minCutUsingTabulation(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            int minCut = Integer.MAX_VALUE;
            for (int k = i; k < n; k++) {

                if (isPalindrome(s, i, k)) {
                    minCut = Math.min(minCut, 1 + dp[k + 1]);
                }
            }

            dp[i] = minCut;
        }

        return dp[0] - 1;
    }

    private int minCutUsingMemoization(String s) {

        if (s.length() == 1) {
            return 0;
        }

        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return minCutUsingMemoization(s, 0, dp) - 1;
    }

    private int minCutUsingMemoization(String s, int i, int[] dp) {

        if (i >= s.length()) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int minCut = Integer.MAX_VALUE;

        for (int k = i; k < s.length(); k++) {

            if (isPalindrome(s, i, k)) {
                minCut = Math.min(minCut, 1 + minCutUsingMemoization(s, k + 1, dp));
            }
        }

        return dp[i] = minCut;
    }

    private int bruteForceMinCut(String s) {

        if (s.length() == 1) {
            return 0;
        }

        return bruteForceMinCut(s, 0) - 1;
    }

    private int bruteForceMinCut(String s, int i) {

        if (i >= s.length()) {
            return 0;
        }

        int minCut = Integer.MAX_VALUE;

        for (int k = i; k < s.length(); k++) {

            if (isPalindrome(s, i, k)) {
                minCut = Math.min(minCut, 1 + bruteForceMinCut(s, k + 1));
            }
        }

        return minCut;
    }


    private boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}

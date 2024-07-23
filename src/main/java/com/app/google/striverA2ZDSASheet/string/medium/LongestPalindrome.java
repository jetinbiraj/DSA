package com.app.google.striverA2ZDSASheet.string.medium;

public class LongestPalindrome {

    public static void main(String[] args) {

        String str = "babad";

        System.out.println(bruteForceLongestPalindrome("cbbd"));
        System.out.println(betterLongestPalindrome("cbbd"));
    }

    //TODO: ADD optimal DP solution and Manacher's Algorithm => https://leetcode.com/problems/longest-palindromic-substring/solutions/4212564/beats-96-49-5-different-approaches-brute-force-eac-dp-ma-recursion/

    private static String betterLongestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }

        return maxStr;
    }

    private static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    private static String bruteForceLongestPalindrome(String s) {

        int size = s.length();
        String longestPalindrome = "";
        int longestPalindromeLength = 0;

        for (int i = 0; i < size; i++) {

            for (int j = i; j < size; j++) {

                if (isPalindrome(s, i, j) && (j - i > longestPalindromeLength)) {

                    longestPalindrome = s.substring(i, j + 1);
                    longestPalindromeLength = j - i;
                }
            }
        }

        return longestPalindrome;
    }

    private static boolean isPalindrome(String s, int startIndex, int endIndex) {

        if (startIndex == endIndex) {
            return true;
        }

        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }

        return true;
    }
}


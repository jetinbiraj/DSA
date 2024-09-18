package com.app.google.striverA2ZDSASheet.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {

        String s = "abcba";

        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s) {

        List<List<String>> substringLists = new ArrayList<>();
        List<String> substrings = new ArrayList<>();

        palindromePartitions(substringLists, substrings, 0, s);

        return substringLists;
    }

    private static void palindromePartitions(List<List<String>> substringLists, List<String> substrings, int start, String s) {

        if (start == s.length()) {
            substringLists.add(new ArrayList<>(substrings));
            return;
        }

        for (int i = start; i < s.length(); i++) {

            if (isPalindrome(s, start, i)) {
                substrings.add(s.substring(start, i + 1));
                palindromePartitions(substringLists, substrings, i + 1, s);
                substrings.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String str, int start, int end) {

        while (start < end) {

            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}

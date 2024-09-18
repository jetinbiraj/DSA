package com.app.google.striverA2ZDSASheet.recursion.hard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {

        List<String> wordDict = List.of("leet", "code");
        String s = "leetcode";

        System.out.println(bruteForceWordBreak(s, wordDict));
        System.out.println(optimalWordBreak(s, wordDict));
    }

    private static boolean optimalWordBreak(String s, List<String> wordDict) {

        return optimalWordBreak(s, new HashSet<>(wordDict));
    }

    private static boolean optimalWordBreak(String s, Set<String> wordDict) {

        int stringLength = s.length();

        if (stringLength == 0) {
            return true;
        }

        for (int i = 1; i <= stringLength; i++) {

            if (wordDict.contains(s.substring(0, i)) && optimalWordBreak(s.substring(i), wordDict)) {
                return true;
            }
        }

        return false;
    }

    private static boolean bruteForceWordBreak(String s, List<String> wordDict) {

        return bruteForceWordBreak(s, wordDict, "");
    }

    private static boolean bruteForceWordBreak(String s, List<String> wordDict, String currentString) {

        if (s.equals(currentString)) {
            return true;
        }

        if (!s.contains(currentString)) {
            return false;
        }

        if (s.length() <= currentString.length()) {
            return false;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            if (bruteForceWordBreak(s, wordDict, currentString + wordDict.get(i))) {
                return true;
            }
        }

        return false;
    }
}

package com.app.google.striverA2ZDSASheet.slidingwindow_twopointer.hard;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";
//        String s = "a";
//        String t = "aa";

        System.out.println(bruteForceMinWindow(s, t));
        System.out.println(optimalMinWindow(s, t));
    }

    private static String optimalMinWindow(String s, String t) { // ddaaabbca t=abc

        int minLen = Integer.MAX_VALUE, startIndex = -1;
        int sLen = s.length(), tLen = t.length();

        int[] hash = new int[150];

        for (char ch : t.toCharArray()) {
            hash[ch]++;
        }

        int right = 0;
        int left = 0;
        int count = 0;

        while (right < sLen) {

            if (hash[s.charAt(right++)]-- > 0) {
                count++;
            }

            while (count == tLen) {

                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }

                if (++hash[s.charAt(left++)] > 0) {
                    count--;
                }
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }

    private static String bruteForceMinWindow(String s, String t) {

        int minLen = Integer.MAX_VALUE, startIndex = -1;
        int sLen = s.length(), tLen = t.length();

        for (int i = 0; i < sLen; i++) {

            int[] tHash = new int[256];
            for (char ch : t.toCharArray()) {
                tHash[ch - 'A']++;
            }
            int count = 0;

            for (int j = i; j < sLen; j++) {

                if (tHash[s.charAt(j) - 'A'] > 0) {
                    count++;
                }

                tHash[s.charAt(j) - 'A']--;

                if (count == tLen) {

                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        startIndex = i;
                    }

                    break;
                }
            }

        }

        if (startIndex == -1) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLen);
    }
}

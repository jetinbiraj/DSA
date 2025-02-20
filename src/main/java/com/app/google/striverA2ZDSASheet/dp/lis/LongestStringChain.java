package com.app.google.striverA2ZDSASheet.dp.lis;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};

        LongestStringChain obj = new LongestStringChain();
        System.out.println(obj.longestStrChain(words));
    }

    private int longestStrChain(String[] words) {

        int n = words.length, lpwc = 1;
        int[] dp = new int[n];
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            String currentWord = words[i];

            for (int j = 0; j < i; j++) {

                String preWord = words[j];
                int index1 = 0, wordLength1 = currentWord.length();
                int index2 = 0, wordLength2 = preWord.length();

                if (wordLength2 + 1 == wordLength1 && 1 + dp[j] > dp[i]) {

                    while (index1 < wordLength1) {

                        if (index2 < wordLength2 && preWord.charAt(index2) == currentWord.charAt(index1)) {
                            index2++;
                        }

                        index1++;
                    }

                    if (index1 == index2 + 1) {
                        dp[i] = 1 + dp[j];
                    }
                }
            }

            lpwc = Math.max(lpwc, dp[i]);
        }

        return lpwc;
    }
}

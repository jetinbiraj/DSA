package com.app.google.striverA2ZDSASheet.string.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringCount {

    public static void main(String[] args) {

        System.out.println(bruteForceSubstrCount("aba", 2));
        System.out.println(bruteForceSubstrCount("abaaca", 1));
        System.out.println(betterSubstrCount("aba", 2));
        System.out.println(betterSubstrCount("abaaca", 1));
        System.out.println(optimalSubstrCount("aba", 2));
        System.out.println(optimalSubstrCount("abaaca", 1));

    }

    private static long optimalSubstrCount(String s, int k) {
        //TODO: Learn the solution

        int size = s.length();

        return subStringsWithAtLeastPDistinct(s, size, k) - subStringsWithAtLeastPDistinct(s, size, k + 1);
    }

    private static long subStringsWithAtLeastPDistinct(String s, int size, int p) {

        int distinctCount = 0;
        long count = 0;
        int[] frequency = new int[26];

        int j = 0;

        for (int i = 0; i < size; i++) {

            while (j < size && distinctCount < p) {
                int chj = s.charAt(j) - 'a';
                frequency[chj]++;
                if (frequency[chj] == 1) {
                    distinctCount++;
                }
                j++;
            }

            if (distinctCount >= p) {
                count += size - j + 1;
            }

            int chi = s.charAt(i) - 'a';
            frequency[chi]--;
            if (frequency[chi] == 0) {
                distinctCount--;
            }
        }
        return count;
    }

    private static long betterSubstrCount(String s, int k) {

        long substrCount = 0;
        int size = s.length();
        int[] frequency = new int[26];

        for (int i = 0; i < size; i++) {

            int distinctCount = 0;
            Arrays.fill(frequency, 0);

            for (int j = i; j < size; j++) {

                int ch = s.charAt(j) - 'a';

                if (frequency[ch] == 0) {
                    distinctCount++;
                }

                frequency[ch]++;

                if (distinctCount > k) {
                    break;
                } else if (distinctCount == k) {
                    substrCount++;
                }
            }
        }

        return substrCount;
    }

    private static long bruteForceSubstrCount(String s, int k) {

        long substrCount = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                String subStr = s.substring(i, j + 1);
                int[] frequency = new int[26];
                for (char ch : subStr.toCharArray()) {
                    frequency[ch - 'a']++;
                }
                int uniqueChars = 0;

                for (int oc : frequency) {
                    if (oc > 0) {
                        uniqueChars += 1;
                        if (uniqueChars > k) {
                            break;
                        }
                    }
                }

                if (uniqueChars == k) {
                    substrCount += 1;
                }
            }
        }

        return substrCount;
    }
}

package com.app.google.striverA2ZDSASheet.slidingwindow_twopointer.medium;

public class NumberOfSubstringsWithChars {

    public static void main(String[] args) {

        String s = "abcabc";

        System.out.println(bruteForceNumberOfSubstrings(s));
        System.out.println(betterNumberOfSubstrings(s));
        System.out.println(bestNumberOfSubstrings(s));
        System.out.println(optimalNumberOfSubstrings(s));
    }

    private static int optimalNumberOfSubstrings(String s) {

        int substringCount = 0;
        int n = s.length();

        int[] hash = {-1, -1, -1};

        for (int i = 0; i < n; i++) {

            hash[s.charAt(i) - 'a'] = i;
            substringCount += Math.min(hash[0], Math.min(hash[1], hash[2])) + 1;
        }

        return substringCount;
    }

    private static int bestNumberOfSubstrings(String s) {

        int substringCount = 0;
        int n = s.length();
        int left = 0;

        int[] count = new int[3];

        for (int right = 0; right < n; right++) {

            count[s.charAt(right) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(left++) - 'a']--;
            }

            substringCount += left;
        }

        return substringCount;
    }

    private static int betterNumberOfSubstrings(String s) {

        int substringCount = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            int[] hash = new int[3];

            for (int j = i; j < n; j++) {

                hash[s.charAt(j) - 'a'] = 1;

                if (hash[0] + hash[1] + hash[2] == 3) {
                    substringCount += n - j;
                    break;
                }
            }
        }

        return substringCount;
    }

    private static int bruteForceNumberOfSubstrings(String s) {

        int substringCount = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            int[] hash = new int[3];

            for (int j = i; j < n; j++) {

                hash[s.charAt(j) - 'a'] = 1;

                if (hash[0] + hash[1] + hash[2] == 3) {
                    substringCount++;
                }
            }
        }

        return substringCount;
    }
}

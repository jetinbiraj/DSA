package com.app.google.striverA2ZDSASheet.slidingwindow_twopointer.medium;

public class CharacterReplacement {

    public static void main(String[] args) {

        String str = "AABABBA";
        int k = 1;

        System.out.println(bruteForceCharacterReplacement(str, k));
        System.out.println(optimalCharacterReplacement(str, k));
    }

    private static int optimalCharacterReplacement(String s, int k) {

        int n = s.length();
        int[] arr = new int[26];

        int left = 0, right = 0;
        int maxOccurrence = 0;

        while (right < n) {

            int currentChar = s.charAt(right) - 'A';

            arr[currentChar]++;

            maxOccurrence = Math.max(maxOccurrence, arr[currentChar]);

            int minChanges = (right - left + 1) - maxOccurrence;

            if (minChanges > k) {
                arr[s.charAt(left++) - 'A']--;
            }

            right++;
        }

        return right - left;
    }

    //TODO: Write the better solution of O(n) + O(n)

    private static int bruteForceCharacterReplacement(String s, int k) {

        int longestRepeatingChars = 0;
        int n = s.length();
        int[] arr;

        for (int i = 0; i < n; i++) {

            int maxOcc = 0;
            arr = new int[26];

            for (int j = i; j < n; j++) {

                char currentChar = s.charAt(j);

                arr[currentChar - 'A']++;

                maxOcc = Math.max(maxOcc, arr[currentChar - 'A']);

                int minChanges = (j - i + 1) - maxOcc;

                if (minChanges <= k) {
                    longestRepeatingChars = Math.max(longestRepeatingChars, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return longestRepeatingChars;
    }
}

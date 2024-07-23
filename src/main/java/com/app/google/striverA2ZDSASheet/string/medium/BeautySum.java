package com.app.google.striverA2ZDSASheet.string.medium;

public class BeautySum {

    public static void main(String[] args) {

        String str = "aabcb";
        System.out.println(beautySum(str));
    }

    private static int beautySum(String s) {

        int beautySum = 0;
        int size = s.length();

        for (int i = 0; i < size; i++) {
            int[] freq = new int[26];

            for (int j = i; j < size; j++) {

                char ch = s.charAt(j);
                freq[ch - 'a']++;

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {

                    if (freq[k] > 0) {
                        max = Math.max(max, freq[k]);
                        min = Math.min(min, freq[k]);
                    }
                }

                beautySum += max - min;
            }
        }

        return beautySum;

    }
}

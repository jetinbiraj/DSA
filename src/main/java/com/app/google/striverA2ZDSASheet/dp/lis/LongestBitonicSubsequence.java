package com.app.google.striverA2ZDSASheet.dp.lis;

public class LongestBitonicSubsequence {

    public static void main(String[] args) {

//        int[] nums = {1, 4, 2, 7, 9, 10};
        int[] nums = {1, 2, 5, 3, 2};
        int n = 5;

        LongestBitonicSubsequence obj = new LongestBitonicSubsequence();
        System.out.println(obj.LongestBitonicSequence(n, nums));
    }

    private int LongestBitonicSequence(int n, int[] nums) {

        int[] dpI = new int[n], dpD = new int[n];

        for (int i = 0; i < n; i++) {
            dpI[i] = 1;
            dpD[i] = 1;

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j] && 1 + dpI[j] > dpI[i]) {
                    dpI[i] = 1 + dpI[j];
                }
            }
        }

        int lbs = 0;

        for (int i = n - 1; i >= 0; i--) {
            dpD[i] = 1;

            for (int j = n - 1; j > i; j--) {

                if (nums[i] > nums[j] && 1 + dpD[j] > dpD[i]) {
                    dpD[i] = 1 + dpD[j];
                }
            }

            if (dpI[i] > 1 && dpD[i] > 1) {
                lbs = Math.max(lbs, dpI[i] + dpD[i] - 1);
            }
        }

        return lbs;
    }
}

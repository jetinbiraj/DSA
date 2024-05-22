package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.Arrays;

public class LongConsSequence {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 1}; // 1, 1 , 2 , 2
        System.out.println(betterConsecutiveSequence(arr));

    }

    private static int betterConsecutiveSequence(int[] arr) {

        int superLong = 0;
        int lastSmaller = Integer.MIN_VALUE;

        int max = 1;

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - 1 == lastSmaller) {

                max += 1;
                lastSmaller = arr[i];

            } else if(lastSmaller != arr[i]) {
                max = 1;
                lastSmaller = arr[i];
            }

            superLong = Math.max(max, superLong);
        }

        return superLong;

    }
}

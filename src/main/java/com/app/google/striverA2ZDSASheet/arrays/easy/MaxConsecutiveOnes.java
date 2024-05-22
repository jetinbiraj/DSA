package com.app.google.striverA2ZDSASheet.arrays.easy;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 1, 1, 1};

        System.out.println(maxConsecutive(arr));

    }

    private static int maxConsecutive(int[] arr) {

        int maxCount = 0;
        int count = 0;

        for (int num : arr) {

            count = num == 1 ? count+1: 0;

            maxCount = Math.max(count, maxCount);

        }

        return maxCount;

    }
}

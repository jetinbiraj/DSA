package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.HashMap;

public class LongestSubArraySumKPosNeg {

    public static void main(String[] args) {

//        int[] arr = {2, 3, 5, 1, 9};
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 3, 3};
        int k = 6;
//        int k = 10;

        System.out.println(bruteForceLongestSubArray(arr, k));
        System.out.println(betterLongestSubArray(arr, k));
        System.out.println(betterSubArraySumUsingMap(arr, k));
    }

    private static int betterSubArraySumUsingMap(int[] arr, int k) {

        int maxSubArrayCount = 0;

        HashMap<Long, Integer> prefixSumIndex = new HashMap<>();

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum == k) {
                maxSubArrayCount = Math.max(maxSubArrayCount, i + 1);
            }

            long complement = sum - k;

            if (prefixSumIndex.containsKey(complement)) {
                maxSubArrayCount = Math.max(maxSubArrayCount, i - prefixSumIndex.get(complement));
            }

            prefixSumIndex.putIfAbsent(sum, i);
        }

        return maxSubArrayCount;
    }


    private static int betterLongestSubArray(int[] arr, int target) {

        int maxSubArrayCount = 0;

        for (int i = 0; i < arr.length; i++) {

            long sum = 0;

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];

                if (sum == target) {
                    maxSubArrayCount = Math.max(maxSubArrayCount, j - i + 1);
                } else if (sum > target) {
                    break;
                }
            }
        }

        return maxSubArrayCount;
    }


    private static int bruteForceLongestSubArray(int[] arr, int target) {

        int maxSubArrayCount = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                long sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                if (sum == target) {
                    maxSubArrayCount = Math.max(maxSubArrayCount, j - i + 1);
                } else if (sum > target) {
                    break;
                }
            }
        }

        return maxSubArrayCount;
    }
}

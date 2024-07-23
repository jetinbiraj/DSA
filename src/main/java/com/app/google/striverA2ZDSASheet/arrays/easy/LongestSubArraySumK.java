package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.HashMap;

public class LongestSubArraySumK {

    public static void main(String[] args) {

//        int[] arr = {2, 3, 5, 1, 9};
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 3, 3};
//        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 3};
        int k = 6;
//        int k = 10;

        System.out.println(bruteForceLongestSubArraySum(arr, k));
        System.out.println(betterLongestSubArraySum(arr, k));
        System.out.println(betterLongestSubArraySumUsingMap(arr, k));
        System.out.println(optimalLongestSubArray(arr, k));
        System.out.println(optimalLongestSubArraySum(arr, k));

    }

    private static int optimalLongestSubArraySum(int[] arr, int k) { //This is Jetin's own solution

        int maxSubArrayCount = 0;

        long sum = 0;

        int slowPointer = 0;
        int fastPointer = 0;

        while (fastPointer < arr.length) {

            sum += arr[fastPointer];

            if (sum == k) {
                maxSubArrayCount = Math.max(maxSubArrayCount, fastPointer - slowPointer + 1);
                fastPointer++;
            } else if (sum > k) {
                sum -= arr[slowPointer++];
                sum -= arr[fastPointer];
            } else {
                fastPointer++;
            }

        }

        return maxSubArrayCount;
    }


    private static int optimalLongestSubArray(int[] arr, int target) { // works only if array has positive elements

        int slowPointer = 0;
        int fastPointer = 0;

        int sum = arr[0];
        int maxSubArrayCount = 0;

        while (fastPointer < arr.length) {

            while (slowPointer <= fastPointer && sum > target) {
                sum -= arr[slowPointer++];
            }

            if (sum == target) {
                maxSubArrayCount = Math.max(maxSubArrayCount, fastPointer - slowPointer + 1);
            }

            fastPointer++;
            if (fastPointer < arr.length) {
                sum += arr[fastPointer];
            }
        }

        return maxSubArrayCount;

    }

    private static int betterLongestSubArraySumUsingMap(int[] arr, int k) {

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


    private static int betterLongestSubArraySum(int[] arr, int target) {

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


    private static int bruteForceLongestSubArraySum(int[] arr, int target) {

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

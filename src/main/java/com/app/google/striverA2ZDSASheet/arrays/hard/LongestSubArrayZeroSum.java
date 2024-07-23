package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayZeroSum {

    public static void main(String[] args) {

        int[] arr = {0, 9, -3, 3, -1, 6, -5};

        System.out.println(bruteForceLongestSubArray(arr, 7));
        System.out.println(optimalLongestSubArrayWithZeroSum(arr, 7));
    }

    private static int optimalLongestSubArrayWithZeroSum(int[] arr, int n) {

        int maxSubArrayLength = 0;
        int sum = 0;

        Map<Integer, Integer> prefixSumMap = new HashMap<>(); //prefixSum, index

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum == 0) {
                maxSubArrayLength = i + 1;
            } else {

                if (prefixSumMap.get(sum) != null) {

                    maxSubArrayLength = Math.max(maxSubArrayLength, i - prefixSumMap.get(sum));

                } else {
                    prefixSumMap.put(sum, i);
                }
            }
        }

        return maxSubArrayLength;
    }

    private static int bruteForceLongestSubArray(int[] arr, int n) {

        int maxSubArrayLength = 0;

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == 0) {
                    maxSubArrayLength = Math.max(maxSubArrayLength, j - i + 1);
                }
            }
        }

        return maxSubArrayLength;
    }

}

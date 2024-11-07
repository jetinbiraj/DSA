package com.app.google.striverA2ZDSASheet.slidingwindow_twopointer.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNiceSubarrays {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        System.out.println(bruteForceNumberOfSubarrays(nums, k));
        System.out.println(betterNumberOfSubarrays(nums, k));
        System.out.println(optimalNumSubarraysWithSum(nums, k));
    }

    private static int optimalNumSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private static int atMost(int[] nums, int goal) {

        if (goal < 0) {
            return 0;
        }

        int n = nums.length;
        int left = 0;
        int count = 0;

        for (int j = 0; j < n; j++) {

            goal -= nums[j] & 1;

            while (goal < 0) {
                goal += nums[left++] & 1;
            }
            count += j - left + 1;
        }

        return count;
    }

    private static int betterNumberOfSubarrays(int[] nums, int k) {

        int count = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int prefixSum = 0;

        for (int num : nums) {

            if ((num & 1) == 1) {
                prefixSum += 1;
            }

            Integer val = prefixSumMap.get(prefixSum - k);

            if (val != null) {
                count += val;
            }

            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    private static int bruteForceNumberOfSubarrays(int[] nums, int k) {

        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int oddCount = 0;

            for (int j = i; j < n; j++) {

                if ((nums[j] & 1) == 1) {
                    oddCount++;
                }

                if (oddCount == k) {
                    count++;
                } else if (oddCount > k) {
                    break;
                }

            }
        }

        return count;
    }
}

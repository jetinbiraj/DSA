package com.app.google.striverA2ZDSASheet.slidingwindow_twopointer.medium;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysSum {

    public static void main(String[] args) {

        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;

        System.out.println(bruteForceNumSubarraysWithSum(nums, goal));
        System.out.println(betterNumSubarraysWithSum(nums, goal));
        System.out.println(optimalNumSubarraysWithSum(nums, goal));
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

            goal -= nums[j];

            while (goal < 0) {
                goal += nums[left++];
            }
            count += j - left + 1;
        }

        return count;
    }

    private static int betterNumSubarraysWithSum(int[] nums, int goal) {

        int count = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);

        int prefixSum = 0;

        for (int num : nums) {

            prefixSum += num;

            Integer val = prefixSumMap.get(prefixSum - goal);
            if (val != null) {
                count += val;
            }

            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    private static int bruteForceNumSubarraysWithSum(int[] nums, int goal) {

        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int currentGoal = 0;

            for (int j = i; j < n; j++) {

                currentGoal += nums[j];

                if (currentGoal == goal) {
                    count++;
                } else if (currentGoal > goal) {
                    break;
                }
            }

        }

        return count;
    }
}

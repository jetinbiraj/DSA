package com.app.google.striverA2ZDSASheet.slidingwindow_twopointer.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubArraysWithKDistinct {

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;

        System.out.println(bruteForceSubarraysWithKDistinct(nums, k));
        System.out.println(optimalSubarraysWithKDistinct(nums, k));
    }

    private static int optimalSubarraysWithKDistinct(int[] nums, int k) {

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {

        int left = 0;
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                if (map.put(nums[left], map.get(nums[left]) - 1) == 1) {
                    map.remove(nums[left]);
                }

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    private static int bruteForceSubarraysWithKDistinct(int[] nums, int k) {

        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int goodSubarrayCount = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                set.add(nums[j]);

                if (set.size() == k) {
                    goodSubarrayCount++;
                } else if (set.size() > k) {
                    break;
                }
            }

            set.clear();
        }

        return goodSubarrayCount;
    }
}

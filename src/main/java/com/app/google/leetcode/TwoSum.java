package com.app.google.leetcode;

import java.util.*;

// 1
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        var result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));

    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i=0;i<nums.length;i++) {

            int diff = target - nums[i];

            if (numMap.containsKey(diff)) {
                return new int[]{numMap.get(diff), nums[i]};
            }

            numMap.put(nums[i], i);
        }

        return new int[]{};

    }
}

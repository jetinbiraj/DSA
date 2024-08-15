package com.app.google.striverA2ZDSASheet.bs.arrays;

import java.util.HashMap;
import java.util.Map;

public class SingleOccurrence {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
//        int[] nums = {1, 1, 2};

        System.out.println(bruteForceSingleElement(nums));
        System.out.println(betterSingleElement2(nums));
        System.out.println(betterSingleElement1(nums));
        System.out.println(optimalSingleElement(nums));
    }

    private static int optimalSingleElement(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        int left = 1;
        int right = n - 2;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private static int betterSingleElement1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        for (int i = 1; i < n - 1; i++) {

            if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        return -1;
    }

    private static int betterSingleElement2(int[] nums) {

        int singleOccurringNum = 0;

        for (int num : nums) {
            singleOccurringNum = singleOccurringNum ^ num;
        }

        return singleOccurringNum;
    }

    private static int bruteForceSingleElement(int[] nums) {

        Map<Integer, Integer> occurrenceMap = new HashMap<>();

        for (int num : nums) {
            occurrenceMap.put(num, occurrenceMap.getOrDefault(num, 0) + 1);
        }

        for (var entry : occurrenceMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}

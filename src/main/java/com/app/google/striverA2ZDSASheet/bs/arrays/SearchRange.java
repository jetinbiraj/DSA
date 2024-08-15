package com.app.google.striverA2ZDSASheet.bs.arrays;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int[] nums = {1};

        System.out.println(Arrays.toString(bruteForceSearchRange(nums, 2)));
        System.out.println(Arrays.toString(optimalSearchRange(nums, 2)));
        System.out.println(Arrays.toString(binarySearchRange(nums, 2)));
    }

    private static int[] binarySearchRange(int[] nums, int target) {

        int firstOccurrence = -1;
        int lastOccurrence = -1;

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid] == target) {
                firstOccurrence = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (firstOccurrence == -1) {
            return new int[]{-1, -1};
        }

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == target) {
                lastOccurrence = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{firstOccurrence, lastOccurrence};
    }

    private static int[] optimalSearchRange(int[] nums, int target) {

        int firstOccurrence = firstOccurrence(nums, target);

        if (firstOccurrence == nums.length || nums[firstOccurrence] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{firstOccurrence, lastOccurrence(nums, target)};
    }

    private static int firstOccurrence(int[] nums, int target) {

        int lowerBound = nums.length;
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid] >= target) {
                lowerBound = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return lowerBound;
    }

    private static int lastOccurrence(int[] nums, int target) {

        int upperBound = nums.length;
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid] > target) {
                upperBound = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return upperBound - 1;
    }

    private static int[] bruteForceSearchRange(int[] nums, int target) {

        int firstOccurance = -1;
        int lastOccurance = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                if (firstOccurance == -1) {
                    firstOccurance = i;
                }
                lastOccurance = i;
            }
            if (nums[i] > target) {
                break;
            }
        }

        return new int[]{firstOccurance, lastOccurance};
    }
}

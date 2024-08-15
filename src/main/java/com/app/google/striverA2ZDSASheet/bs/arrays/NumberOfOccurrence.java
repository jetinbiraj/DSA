package com.app.google.striverA2ZDSASheet.bs.arrays;

public class NumberOfOccurrence {

    public static void main(String[] args) {

//        int[] nums = {2, 2, 3, 3, 3, 3, 4};
        int[] nums = {2, 4, 6, 8, 8, 8, 11, 13};
        System.out.println(bruteForceNumberOfOccurrence(nums, 8));
        System.out.println(optimalNumberOfOccurrence(nums, 8));
    }

    private static int optimalNumberOfOccurrence(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        int firstOccurrence = -1;
        int lastOccurrence = -1;

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
            return 0;
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

        return (lastOccurrence - firstOccurrence + 1);
    }

    private static int bruteForceNumberOfOccurrence(int[] nums, int target) {

        int numberOfOccurrence = 0;

        for (int num : nums) {
            if (num == target) {
                numberOfOccurrence++;
            }

            if (num > target) {
                break;
            }
        }

        return numberOfOccurrence;
    }
}

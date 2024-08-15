package com.app.google.striverA2ZDSASheet.bs.arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        System.out.println(search(nums, target));
        System.out.println(recursiveBinarySearch(nums, target));
    }

    private static int recursiveBinarySearch(int[] nums, int target) {
        return recursiveBinarySearch(nums, target, 0, nums.length - 1);
    }

    private static int recursiveBinarySearch(int[] nums, int target, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (target > nums[mid]) {
            return recursiveBinarySearch(nums, target, mid + 1, high);
        } else {
            return recursiveBinarySearch(nums, target, low, mid - 1);
        }
    }

    private static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = (right + left) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

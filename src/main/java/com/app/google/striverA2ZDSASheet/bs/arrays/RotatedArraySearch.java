package com.app.google.striverA2ZDSASheet.bs.arrays;

public class RotatedArraySearch {

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        //TODO: Brute force solution would be simple linear search
        System.out.println(optimalSearch(nums, 0));

    }

    private static int optimalSearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {

                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {

                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

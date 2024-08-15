package com.app.google.striverA2ZDSASheet.bs.arrays;

public class RotatedArraySearch2 {

    public static void main(String[] args) {

//        int[] nums = {2, 5, 6, 0, 0, 1, 2};
//        int[] nums = {1, 0, 1, 1, 1};
        int[] nums = {3, 1};
        //TODO: Brute force solution would be simple linear search
        System.out.println(optimalSearch(nums, 1));

    }

    private static boolean optimalSearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left = left + 1;
                right = right - 1;
                continue;
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

        return false;
    }
}

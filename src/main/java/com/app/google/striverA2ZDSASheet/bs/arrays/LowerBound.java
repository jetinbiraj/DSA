package com.app.google.striverA2ZDSASheet.bs.arrays;

public class LowerBound {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 8, 10, 11, 12, 19};
        int[] nums = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        System.out.println(bruteForceLowerBound(nums, 2));
        System.out.println(optimalLowerBound(nums, 2));
    }

    private static int optimalLowerBound(int[] nums, int target) {

        int lowerBound = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (target <= nums[mid]) {
                lowerBound = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return lowerBound;
    }


    private static int bruteForceLowerBound(int[] nums, int target) {

        int lowerBound = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= target) {
                return i;
            }
        }

        return lowerBound;
    }
}



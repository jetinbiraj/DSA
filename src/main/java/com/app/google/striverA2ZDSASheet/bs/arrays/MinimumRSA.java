package com.app.google.striverA2ZDSASheet.bs.arrays;

public class MinimumRSA {

    public static void main(String[] args) {

//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {3, 4, 5, 1, 2};
//        int[] nums = {11, 13, 15, 17};
//        int[] nums = {5, 1, 2, 3, 4};
        int[] nums = {4, 5, 1, 2, 3};

        System.out.println(bruteForceFindMin(nums));
        System.out.println(optimalFindMin(nums));
    }

    private static int optimalFindMin(int[] nums) {

        int minElement = Integer.MAX_VALUE;

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[left] <= nums[right]) {
                minElement = Math.min(minElement, nums[left]);
                break;
            }

            if (nums[left] <= nums[mid]) {
                minElement = Math.min(minElement, nums[left]);
                left = mid + 1;
            } else {
                minElement = Math.min(minElement, nums[mid]);
                right = mid - 1;
            }
        }

        return minElement;
    }


    private static int bruteForceFindMin(int[] nums) {

        int minElement = Integer.MAX_VALUE;

        for (int num : nums) {
            minElement = Math.min(minElement, num);
        }

        return minElement;
    }
}

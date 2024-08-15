package com.app.google.striverA2ZDSASheet.bs.arrays;

public class UpperBound {

    public static void main(String[] args) {

        int[] nums = {3, 5, 8, 9, 15, 19};

        System.out.println(bruteForceUpperBound(nums, 9));
        System.out.println(optimalUpperBound(nums, 9));
    }

    private static int optimalUpperBound(int[] nums, int k) {

        int upperBound = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid] > k) {
                upperBound = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return upperBound;
    }


    private static int bruteForceUpperBound(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > k) {
                return i;
            }
        }

        return -1;
    }
}

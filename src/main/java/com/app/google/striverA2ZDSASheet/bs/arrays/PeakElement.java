package com.app.google.striverA2ZDSASheet.bs.arrays;

public class PeakElement {

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 5, 6, 4};
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {1};
//        int[] nums = {1, 2};

        System.out.println(bruteForcePeakElement(nums));
        System.out.println(optimalPeakElement(nums));
    }

    private static int optimalPeakElement(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        if (nums[0] > nums[n - 2]) {
            return 0;
        }

        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int left = 1;
        int right = n - 2;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


    private static int bruteForcePeakElement(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        for (int i = 0; i < n; i++) {

            if ((i == 0 || nums[i - 1] < nums[i]) && (i == n - 1 || nums[i] > nums[i + 1])) {
                return i;
            }

//            if (i == 0) {
//
//                if (nums[i] > nums[i + 1]) {
//                    return i;
//                }
//                continue;
//            }
//
//            if (i == n - 1) {
//                if (nums[i] > nums[n - 2]) {
//                    return i;
//                }
//                break;
//            }
//
//            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
//                return i;
//            }
        }

        return -1;
    }

}

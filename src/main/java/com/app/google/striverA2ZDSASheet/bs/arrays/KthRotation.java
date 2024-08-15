package com.app.google.striverA2ZDSASheet.bs.arrays;

public class KthRotation {


    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
//        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(bruteForceFindKthRotation(nums));
        System.out.println(optimalFindKthRotation(nums));
    }

    private static int optimalFindKthRotation(int[] nums) {

        int minElementIndex = 0;
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[left] < nums[right] && nums[left] < nums[minElementIndex]) {
                minElementIndex = left;
                break;
            }

            if (nums[left] <= nums[mid]) {

                if (nums[left] < nums[minElementIndex]) {
                    minElementIndex = left;
                }
                left = mid + 1;

            } else {

                if (nums[mid] < nums[minElementIndex]) {
                    minElementIndex = mid;
                }
                right = mid - 1;
            }
        }

        return minElementIndex;
    }


    private static int bruteForceFindKthRotation(int[] nums) {

        int minElementIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[minElementIndex]) {
                minElementIndex = i;
            }
        }

        return minElementIndex;
    }
}

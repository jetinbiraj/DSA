package com.app.google.striverA2ZDSASheet.bs.arrays;

import java.util.Arrays;

public class FloorCeil {

    public static void main(String[] args) {

//        int[] nums = {3, 4, 4, 7, 8, 10};
        int[] nums = {3, 4, 4, 7, 8, 10};
        System.out.println(Arrays.toString(bruteForceGetFloorAndCeil(nums, 5)));
        System.out.println(Arrays.toString(optimalGetFloorAndCeil(nums, 5)));
    }

    private static int[] optimalGetFloorAndCeil(int[] nums, int target) {

        int floor = -1;
        int ceil = -1;

        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {

            mid = (low + high) / 2;

            if (nums[mid] == target) {
                return new int[]{target, target};
            }
            if (nums[mid] < target) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                ceil = nums[mid];
                high = mid - 1;
            }
        }

        return new int[]{floor, ceil};
    }

    private static int[] bruteForceGetFloorAndCeil(int[] nums, int target) {

        int floor = -1;
        int ceil = -1;
        boolean foundFloorCeil = false;

        for (int num : nums) {

            if (num == target) {
                return new int[]{target, target};
            }

            if (num < target) {
                floor = Math.max(floor, num);
            } else {
                foundFloorCeil = true;
            }

            if (num > target) {
                ceil = num;
            }

            if (foundFloorCeil) {
                break;
            }
        }

        return new int[]{floor, ceil};
    }
}

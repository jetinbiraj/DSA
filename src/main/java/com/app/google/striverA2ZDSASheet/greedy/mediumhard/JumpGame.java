package com.app.google.striverA2ZDSASheet.greedy.mediumhard;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(bruteForceCanJump(nums));
        System.out.println(betterCanJump(nums));
        System.out.println(optimalCanJump(nums));
    }

    private static boolean optimalCanJump(int[] nums) {

        int n = nums.length;

        int maxPossible = 0;

        for (int i = 0; i < n; i++) {

            if (i > maxPossible) {
                return false;
            }

            maxPossible = Math.max(maxPossible, nums[i] + i);
        }

        return true;
    }

    private static boolean betterCanJump(int[] nums) {

        int n = nums.length;

        int maxPossible = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] != 0) {
                maxPossible = Math.max(maxPossible, nums[i] + i);
            } else if (i != n - 1) {
                if (i >= maxPossible) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bruteForceCanJump(int[] nums) {

        return canJump(nums, 0);
    }

    private static boolean canJump(int[] nums, int index) {

        if (index >= nums.length - 1) {
            return true;
        }

        for (int i = nums[index]; i >= 1; i--) {

            if (canJump(nums, index + i)) {
                return true;
            }
        }

        return false;
    }
}

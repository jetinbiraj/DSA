package com.app.google.striverA2ZDSASheet.greedy.mediumhard;

public class JumpGameII {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(bruteForceJump(nums));
    }

    private static int bruteForceJump(int[] nums) {

        return jumps(nums, 0, 0);
    }

    private static int jumps(int[] nums, int index, int jumps) {

        if (index >= nums.length - 1) {
            return jumps;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[index]; i++) {
            min = Math.min(min, jumps(nums, index + i, jumps + 1));
        }

        return min;
    }
}

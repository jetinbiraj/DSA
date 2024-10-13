package com.app.google.striverA2ZDSASheet.bitmanupilation.interviewproblems;

import java.util.Arrays;

public class TwoOddNum {

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 5, 2, 3, 3, 1};

        System.out.println(Arrays.toString(optimalTwoOddNum(nums)));
    }

    private static int[] optimalTwoOddNum(int[] nums) {

        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        int lsb = (xor & (xor - 1)) ^ xor;

        int xor1 = 0;
        int xor2 = 0;

        for (int num : nums) {

            if ((num & lsb) != 0) {
                xor1 ^= num;
            } else {
                xor2 ^= num;
            }
        }

        if (xor1 > xor2) {
            return new int[]{xor1, xor2};
        }

        return new int[]{xor2, xor1};
    }
}

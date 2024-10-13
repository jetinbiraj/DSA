package com.app.google.striverA2ZDSASheet.bitmanupilation.interviewproblems;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        int singleNum = 0;

        for (int num : nums) {
            singleNum ^= num;
        }

        return singleNum;
    }
}

package com.app.google.striverA2ZDSASheet.bitmanupilation.interviewproblems;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {

        int len = nums.length;
        int subsetLen = 1 << len;
        List<List<Integer>> subsets = new ArrayList<>();

        for (int i = 0; i < subsetLen; i++) {

            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < len; j++) {

                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }

            subsets.add(subset);
        }

        return subsets;
    }
}

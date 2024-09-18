package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        System.out.println(iterativeSubsets(nums));
        System.out.println(recursiveSubsets(nums));
    }

    private static List<List<Integer>> recursiveSubsets(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();

        backtrack(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }

    private static void backtrack(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {
        subsets.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(subsets, subset, nums, i + 1);
            subset.removeLast();
        }
    }

    private static List<List<Integer>> iterativeSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        for (int num : nums) {

            int length = subsets.size();

            for (int i = 0; i < length; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(num);
                subsets.add(subset);
            }
        }

        return subsets;
    }
}

package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

import java.util.*;

public class SubsetSumII {

    public static void main(String[] args) {

        int[] nums = {1, 2, 2};

        System.out.println(bruteForceSubsetsWithDup(nums));
        System.out.println(subsetsWithDup(nums));
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);

        subsets(subsets, new ArrayList<>(), nums, 0);

        return subsets;
    }

    private static void subsets(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {

        subsets.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            subset.add(nums[i]);
            subsets(subsets, subset, nums, i + 1);
            subset.removeLast();
        }
    }


    private static List<List<Integer>> bruteForceSubsetsWithDup(int[] nums) {

        Set<List<Integer>> subsets = new HashSet<>();

        bruteSubsets(subsets, new ArrayList<>(), nums, 0);

        return new ArrayList<>(subsets);
    }

    private static void bruteSubsets(Set<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {

        List<Integer> newSubset = new ArrayList<>(subset);
        Collections.sort(newSubset);
        subsets.add(newSubset);

        for (int i = start; i < nums.length; i++) {

            subset.add(nums[i]);
            bruteSubsets(subsets, subset, nums, i + 1);
            subset.removeLast();
        }
    }
}

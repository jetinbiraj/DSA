package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

import java.util.*;

public class CombinationSumII {

    public static void main(String[] args) {

//        int[] candidates = {10, 1, 2, 7, 6, 1, 5}; // 1, 1, 2, 5, 6, 7, 10
//        int target = 8;
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;

        System.out.println(bruteForceCombinationSum2(candidates, target));
    }

    private static List<List<Integer>> optimalCombinationSum2(int[] candidates, int target) {

        List<List<Integer>> subsets = new ArrayList<>();

        Arrays.sort(candidates);

        optimalSubsets(subsets, new ArrayList<>(), target, 0, candidates);

        return subsets;
    }

    private static void optimalSubsets(List<List<Integer>> subsets, List<Integer> subset, int target, int start, int[] candidates) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            ArrayList<Integer> newSubset = new ArrayList<>(subset);
            subsets.add(newSubset);
        } else {

            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (candidates[i] > target) {
                    break;
                }
                subset.add(candidates[i]);
                optimalSubsets(subsets, subset, target - candidates[i], i + 1, candidates);
                subset.removeLast();
            }
        }
    }

    private static List<List<Integer>> bruteForceCombinationSum2(int[] candidates, int target) {

        Set<List<Integer>> subsets = new HashSet<>();

        subsets(subsets, new ArrayList<>(), target, 0, candidates);

        return new ArrayList<>(subsets);
    }

    private static void subsets(Set<List<Integer>> subsets, List<Integer> subset, int target, int start, int[] candidates) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            ArrayList<Integer> newSubset = new ArrayList<>(subset);
            Collections.sort(newSubset);
            subsets.add(newSubset);
        } else {

            for (int i = start; i < candidates.length; i++) {
                subset.add(candidates[i]);
                subsets(subsets, subset, target - candidates[i], i + 1, candidates);
                subset.removeLast();
            }
        }
    }
}

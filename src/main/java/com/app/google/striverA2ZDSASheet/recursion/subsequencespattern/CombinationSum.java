package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> combinations = new ArrayList<>();

        combinations(combinations, new ArrayList<>(), candidates, 0, target);

        return combinations;
    }

    private static void combinations(List<List<Integer>> combinations, List<Integer> combination, int[] candidates, int start, int target) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
        } else {

            for (int i = start; i < candidates.length; i++) {

                combination.add(candidates[i]);
                combinations(combinations, combination, candidates, i, target - candidates[i]);
                combination.removeLast();
            }
        }
    }
}

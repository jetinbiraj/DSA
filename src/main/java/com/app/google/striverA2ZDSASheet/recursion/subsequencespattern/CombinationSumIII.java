package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
        int k = 4;
        int n = 1;

        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> subsets = new ArrayList<>();

        subsets(subsets, new ArrayList<>(), k, n, 1);

        return subsets;
    }


    private static void subsets(List<List<Integer>> subsets, List<Integer> subset, int k, int n, int start) {

        if (k == 0 && n == 0) {
            subsets.add(new ArrayList<>(subset));
        } else {

            for (int i = start; i <= 9; i++) {

                if (i > n || k < 0) {
                    break;
                }
                subset.add(i);
                subsets(subsets, subset, k - 1, n - i, i + 1);
                subset.removeLast();
            }
        }
    }
}


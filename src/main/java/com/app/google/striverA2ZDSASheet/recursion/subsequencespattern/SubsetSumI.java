package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

import java.util.*;

public class SubsetSumI {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);

        int n = 2;

        System.out.println(subsetSums(arr, n));
    }

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {

        ArrayList<Integer> sumList = new ArrayList<>();
        subsetSums(sumList, arr, n, 0, 0);

        return sumList;
    }

    private static void subsetSums(ArrayList<Integer> sumList, ArrayList<Integer> arr, int n, int sum, int start) {

        sumList.add(sum);

        for (int i = start; i < n; i++) {
            subsetSums(sumList, arr, n, sum + arr.get(i), i + 1);
        }
    }
}

package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetSumExists {

    public static void main(String[] args) {

        int[] arr = {4, 2, 5, 6, 7};
        System.out.println(recursiveSubsetSum(arr, arr.length, 145));
    }

    private static boolean recursiveSubsetSum(int arr[], int n, int sum) {

        return subsequences(arr, n, sum, 0);
    }

    private static boolean subsequences(int[] arr, int n, int sum, int start) {

        if (sum < 0) {
            return false;
        }

        if (sum == 0) {
            return true;
        }

        for (int i = start; i < n; i++) {

            if (subsequences(arr, n, sum - arr[i], i + 1)) {
                return true;
            }
        }

        return false;
    }
}

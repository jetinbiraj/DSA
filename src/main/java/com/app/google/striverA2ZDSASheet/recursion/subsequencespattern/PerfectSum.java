package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

public class PerfectSum {

    public static void main(String[] args) {

        int[] arr = {5, 2, 3, 10, 6, 8};
        int n = arr.length;
        int sum = 10;

        System.out.println(recursivePerfectSum(arr, n, sum));
    }

    private static int recursivePerfectSum(int[] arr, int n, int sum) {

        return subsequences(arr, n, sum, 0);
    }

    private static int subsequences(int[] arr, int n, int sum, int start) {

        int count = 0;

        if (sum < 0) {
            return count;
        }

        if (sum == 0) {
            count++;
        } else {
            for (int i = start; i < n; i++) {
                count += subsequences(arr, n, sum - arr[i], i + 1);
            }
        }

        return count;
    }
}

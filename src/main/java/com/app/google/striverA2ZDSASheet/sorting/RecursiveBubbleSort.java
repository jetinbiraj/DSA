package com.app.google.striverA2ZDSASheet.sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {

    public static void main(String[] args) {

        int[] arr = {13, -1, 46, 24, 52, 20, 9};
//        int[] arr = {1, 46, 241, 5211, 20111};

        recursiveBubbleSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    private static void recursiveBubbleSort(int[] arr, int limiter) {

        if (limiter > 1) {

            boolean swapped = false;

            for (int i = 0; i < limiter - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tempSwapVariable = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tempSwapVariable;
                    swapped = true;
                }
            }

            if (swapped) {
                recursiveBubbleSort(arr, limiter - 1);
            }

        }
    }
}

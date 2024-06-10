package com.app.google.striverA2ZDSASheet.sorting;

import java.util.Arrays;

public class RecursiveInsertionSort {

    public static void main(String[] args) {

        int[] arr = {13, -1, 46, 24, 52, 20, 9};
//        int[] arr = {1, 46, 241, 5211, 20111};

        recursiveInsertionSort(arr, 0);

        System.out.println(Arrays.toString(arr));
    }

    private static void recursiveInsertionSort(int[] arr, int keyElementIndex) {

        if (keyElementIndex < arr.length) {

            int j = keyElementIndex;

            while (j > 0 && arr[j] < arr[j - 1]) {
                int tempSwapVariable = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tempSwapVariable;
                j--;
            }

            recursiveInsertionSort(arr, keyElementIndex + 1);
        }

    }
}

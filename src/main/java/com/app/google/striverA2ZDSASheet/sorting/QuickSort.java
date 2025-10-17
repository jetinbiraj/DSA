package com.app.google.striverA2ZDSASheet.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3, 1, 4};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {

            int pivotPartitionIndex = partitionPivot(arr, lowerIndex, higherIndex);

            quickSort(arr, lowerIndex, pivotPartitionIndex - 1);
            quickSort(arr, pivotPartitionIndex + 1, higherIndex);
        }
    }

    private static int partitionPivot(int[] arr, int lowerIndex, int higherIndex) {

        int i = lowerIndex, j = higherIndex;

        int pivotElement = arr[lowerIndex];

        while (i < j) {

            while (arr[i] <= pivotElement && i < higherIndex) {
                i++;
            }

            while (arr[j] > pivotElement && j > lowerIndex) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, lowerIndex, j);
        return j;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int tempSwapVariable = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tempSwapVariable;
    }
}

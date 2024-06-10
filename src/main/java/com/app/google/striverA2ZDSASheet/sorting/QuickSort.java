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

        int leftPointer = lowerIndex;
        int rightPointer = higherIndex;

        int pivotElement = arr[lowerIndex];

        while (leftPointer < rightPointer) {

            while (arr[leftPointer] <= pivotElement && leftPointer <= higherIndex - 1) {
                leftPointer++;
            }

            while (arr[rightPointer] > pivotElement && rightPointer >= lowerIndex + 1) {
                rightPointer--;
            }

            if (leftPointer < rightPointer) {
                swap(arr, leftPointer, rightPointer);
            }

        }

        swap(arr, lowerIndex, rightPointer);

        return rightPointer;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int tempSwapVariable = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tempSwapVariable;
    }
}

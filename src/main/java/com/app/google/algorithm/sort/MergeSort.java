package com.app.google.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    private void merge(int[] arr, int lowIndex, int midIndex, int highIndex) {

        // Find sizes of two subarrays to be merged
        int n1 = midIndex - lowIndex + 1;
        int n2 = highIndex - midIndex;

        int[] tempLeftSubArray = new int[n1];
        int[] tempRightSubArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            tempLeftSubArray[i] = arr[lowIndex + i];
        }

        for (int i = 0; i < n2; i++) {
            tempRightSubArray[i] = arr[midIndex + 1 + i];
        }

        int i = 0, j = 0;

        int k = lowIndex;
        while (i < n1 && j < n2) {
            if (tempLeftSubArray[i] <= tempRightSubArray[j]) {
                arr[k] = tempLeftSubArray[i];
                i++;
            } else {
                arr[k] = tempRightSubArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = tempLeftSubArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = tempRightSubArray[j];
            j++;
            k++;
        }

    }


//     Merge two subarrays L and M into arr
//    void merge(int[] arr, int low, int middle, int high) {
//
//        // Create L ← A[low..middle] and M ← A[middle+1..high]
//        int n1 = middle - low + 1;
//        int n2 = high - middle;
//
//        int[] L = new int[n1];
//        int[] M = new int[n2];
//
//        for (int i = 0; i < n1; i++)
//            L[i] = arr[low + i];
//        for (int j = 0; j < n2; j++)
//            M[j] = arr[middle + 1 + j];
//
//        // Maintain current index of sub-arrays and main array
//        int i, j, k;
//        i = 0;
//        j = 0;
//        k = low;
//
//        // Until we reach either end of either L or M, pick larger among
//        // elements L and M and place them in the correct position at A[low..high]
//        while (i < n1 && j < n2) {
//            if (L[i] <= M[j]) {
//                arr[k] = L[i];
//                i++;
//            } else {
//                arr[k] = M[j];
//                j++;
//            }
//            k++;
//        }
//
//        // When we run out of elements in either L or M,
//        // pick up the remaining elements and put in A[low..high]
//        while (i < n1) {
//            arr[k] = L[i];
//            i++;
//            k++;
//        }
//
//        while (j < n2) {
//            arr[k] = M[j];
//            j++;
//            k++;
//        }
//    }

    private void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }


    public static void main(String[] args) {

        int[] arr = {6, 5, 12, 10, 9, 1};

        MergeSort ms = new MergeSort();
        ms.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));

    }
}

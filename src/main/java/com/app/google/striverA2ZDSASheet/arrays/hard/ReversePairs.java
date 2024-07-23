package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 3, 1};
//        int[] arr = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};

        System.out.println(bruteForceReversePairs(arr));
        System.out.println(optimalReversePairs(arr));
    }

    private static int optimalReversePairs(int[] arr) {

        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int low, int high) {

        int reversePairs = 0;

        if (low < high) {

            int mid = (low + high) / 2;

            reversePairs += mergeSort(arr, low, mid);
            reversePairs += mergeSort(arr, mid + 1, high);

            reversePairs += countPairs(arr, low, mid, high);
            merge(arr, low, mid, high);

        }

        return reversePairs;
    }

    private static int countPairs(int[] arr, int low, int mid, int high) {

        int reversePairs = 0;

        int right = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (right <= high && arr[i] > ((long) 2 * arr[right])) {
                right++;
            }

            reversePairs += right - mid - 1;
        }

        return reversePairs;
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;

        List<Integer> tempList = new ArrayList<>();

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                tempList.add(arr[left++]);
            } else {
                tempList.add(arr[right++]);
            }
        }

        while (left <= mid) {
            tempList.add(arr[left++]);
        }

        while (right <= high) {
            tempList.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = tempList.get(i - low);
        }
    }

    private static int bruteForceReversePairs(int[] arr) {

        int reversePairs = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > ((long) 2 * arr[j])) {
                    reversePairs++;
                }
            }
        }

        return reversePairs;
    }
}

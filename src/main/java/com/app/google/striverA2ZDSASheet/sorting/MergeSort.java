package com.app.google.striverA2ZDSASheet.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 4, 1, 5, 2, 6, 4};
//        int[] arr = {3, 1, 2, 4, 1};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {

        if (low < high) {

            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
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
}

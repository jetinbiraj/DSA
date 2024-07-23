package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    public static void main(String[] args) {

//        int[] arr = {5, 4, 3, 2, 1};
        int[] arr = {57, 38, 91, 10, 38, 28, 79, 41};

        System.out.println(bruteForceCountInversion(arr));
        System.out.println(optimalCountInversion(arr));
    }

    private static int optimalCountInversion(int[] arr) {

        return mergeSort(arr, 0, arr.length - 1);

    }

    private static int mergeSort(int[] arr, int low, int high) {

        int inversionCount = 0;

        if (low < high) {

            int mid = (low + high) / 2;

            inversionCount += mergeSort(arr, low, mid);
            inversionCount += mergeSort(arr, mid + 1, high);

            inversionCount += merge(arr, low, mid, high);
        }

        return inversionCount;
    }

    private static int merge(int[] arr, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;
        int inversionCount = 0;

        List<Integer> tempList = new ArrayList<>();

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                tempList.add(arr[left++]);
            } else {
                tempList.add(arr[right++]);
                inversionCount += (mid - left + 1);
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

        return inversionCount;
    }


    private static int bruteForceCountInversion(int[] arr) {

        int inversionCount = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[i]) {
                    inversionCount++;
                }
            }
        }

        return inversionCount;
    }
}

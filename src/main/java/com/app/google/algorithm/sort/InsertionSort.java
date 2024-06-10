package com.app.google.algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    private void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

    }

    public static void main(String[] args) {

        InsertionSort is = new InsertionSort();

        int[] arr = {-5, 6, -8, 44, 22, 455, 47, -78};

        is.sort(arr);

        System.out.println("Sorted Array in Ascending Order:");

        System.out.println(Arrays.toString(arr));
    }
}

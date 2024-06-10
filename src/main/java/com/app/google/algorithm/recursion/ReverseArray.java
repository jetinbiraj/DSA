package com.app.google.algorithm.recursion;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        reverse(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;

        reverse(arr, ++start, --end);
    }
}

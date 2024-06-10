package com.app.google.striverA2ZDSASheet.basics.recursion;

import java.util.Arrays;

public class ReverseArr {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        reverse(arr, 0, arr.length - 1);
        reverse2(arr, 0);

        System.out.println(Arrays.toString(arr));
    }

    private static void reverse2(int[] arr, int index) {

        if (index >= arr.length / 2) {
            return;
        }

        int temp = arr[index];
        arr[index] = arr[arr.length - index - 1];
        arr[arr.length - index - 1] = temp;

        reverse2(arr, index + 1);

    }

    private static void reverse(int[] arr, int start, int last) {

        if (start >= last) {
            return;

        }

        int temp = arr[start];
        arr[start] = arr[last];
        arr[last] = temp;

        reverse(arr, start + 1, last - 1);

    }
}

package com.app.google.striverA2ZDSASheet.basics.recursion;

import java.util.Arrays;

public class ReverseArr {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        reverse(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int start, int last) {

        if (start > last) {
            return;

        }

        int temp = arr[start];
        arr[start] = arr[last];
        arr[last] = temp;

        reverse(arr, start+1, last-1);

    }
}

package com.app.google.ds.array;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {

        int[] mixArr = {2, 11, 5, 10, 7, 8};

        System.out.println(Arrays.toString(reverseArray(mixArr, 0, 5)));
    }

    private static int[] reverseArray(int[] arr, int start, int end) {

        while (start < end) {

            int temp = arr[start];

            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return arr;
    }
}

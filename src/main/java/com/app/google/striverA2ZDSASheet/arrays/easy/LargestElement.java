package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.Arrays;

public class LargestElement {

    public static void main(String[] args) {

        int[] arr = {13, 3, 46, 24, 52, 20, 9};

        System.out.println(bruteForceLargestElement(arr));
        System.out.println(optimalLargestElement(arr));
    }

    private static int optimalLargestElement(int[] arr) {

        int largestElement = arr[0];

        for (int element : arr) {
            largestElement = Math.max(element, largestElement);
        }

        return largestElement;
    }

    private static int bruteForceLargestElement(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}

package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.Arrays;

public class RotateByK {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        int k = 3;

        System.out.println("After left rotation by: " + k);
//        bruteForceRotateLeft(arr, k);
        optimalRotateLeft(arr, k);
        System.out.println(Arrays.toString(arr)); // [4, 5, 6, 7, 1, 2, 3]

        System.out.println("After right rotation by: " + k);
//        bruteForceRotateRight(arr, k);
        optimalRotateRight(arr, k);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6, 7]
    }

    private static void optimalRotateRight(int[] arr, int k) {

        k = k % arr.length;

        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    private static void optimalRotateLeft(int[] arr, int k) {

        k = k % arr.length;

        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

    }

    private static void reverse(int[] arr, int startIndex, int endIndex) {

        while (startIndex < endIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;

            startIndex++;
            endIndex--;

        }
    }

    private static void bruteForceRotateRight(int[] arr, int k) {

        k = k % arr.length;

        int[] tempArray = new int[k];

        System.arraycopy(arr, arr.length - k, tempArray, 0, tempArray.length);

        for (int i = arr.length - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }

        System.arraycopy(tempArray, 0, arr, 0, tempArray.length);
    }

    private static void bruteForceRotateLeft(int[] arr, int k) {

        k = k % arr.length;

        int[] temp = new int[k];

        System.arraycopy(arr, 0, temp, 0, k);

        for (int i = 0; i < arr.length - k; i++) {
            arr[i] = arr[k + i];
        }

        System.arraycopy(temp, 0, arr, arr.length - k, k);
    }
}

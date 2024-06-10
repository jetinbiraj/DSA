package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 3, 0, 4, 0, 1};

//        bruteForce(arr);
//
//        System.out.println(Arrays.toString(arr));

        moveZeros(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void moveZeros(int[] arr) {

        int slowPointer = 0;

        for (int num : arr) {

            if (num != 0) {
                arr[slowPointer] = num;
                slowPointer++;
            }

        }

        for (int i = slowPointer; i < arr.length; i++) {
            arr[i] = 0;
        }

    }

    private static void bruteForce(int[] arr) {

        int[] temp = new int[arr.length];

        int counter = 0;

        for (int num : arr) {
            if (num != 0) {
                temp[counter++] = num;
            }
        }

        System.arraycopy(temp, 0, arr, 0, temp.length);
    }
}

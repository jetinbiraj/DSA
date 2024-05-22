package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.Arrays;

public class RotateByOne {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        rotate(arr);

        System.out.println(Arrays.toString(arr));
    }


    private static void rotate(int[] arr) {

        int val = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {

            arr[i] = arr[i+1];

        }

        arr[arr.length-1] = val;

    }
}

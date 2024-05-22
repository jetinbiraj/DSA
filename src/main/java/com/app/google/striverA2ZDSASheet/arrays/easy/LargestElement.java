package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.Arrays;

public class LargestElement {

    public static void main(String[] args) {

        int[] arr = {13, 3, 46, 24, 52, 20, 9};

        Arrays.stream(arr).max();
        System.out.println(maxNum1(arr));


    }

    private static int maxNum1(int[] arr) {

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }

        }

        return max;
    }
}

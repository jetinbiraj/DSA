package com.app.google.leetcode;

import java.util.Arrays;

public class ReplaceGreatestRight {

    public static void main(String[] args) {

        int[] arr = {17, 18, 5, 4, 6, 1};

        replaceElement(arr);
        System.out.println(Arrays.toString(arr));

    }

    // O(n)
    private static void replaceElement(int[] arr) {

        int rightMax = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int newMax = Math.max(rightMax, arr[i]);
            arr[i] = rightMax;
            rightMax = newMax;
        }

    }

    // O(n^2)
//    private static void replaceElement(int[] arr) {
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            int max = arr[i + 1];
//
//            for (int j = i + 1; j < arr.length; j++) {
//
//                if (max < arr[j]) {
//                    max = arr[j];
//                }
//            }
//            arr[i] = max;
//
//        }
//
//        arr[arr.length -1] = -1;
//    }
}

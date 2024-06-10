package com.app.google.striverA2ZDSASheet.arrays.easy;

public class CheckArraySorted {

    public static void main(String[] args) {

        int[] arr = {13 , 3, 46, 24, 52, 20, 9};
        int[] arr2 = {1 , 3, 4, 24, 52};

        System.out.println(isSorted(arr));
        System.out.println(isSorted(arr2));

    }

    private static boolean isSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] > arr[i + 1]) {
                return false;
            }

        }

        return true;
    }
}

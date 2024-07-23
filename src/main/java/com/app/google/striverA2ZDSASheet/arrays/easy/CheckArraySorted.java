package com.app.google.striverA2ZDSASheet.arrays.easy;

public class CheckArraySorted {

    public static void main(String[] args) {

        int[] arr = {13, 3, 46, 24, 52, 20, 9};
        int[] arr2 = {1, 3, 4, 24, 52};

        System.out.println(bruteForceIsSorted(arr));
        System.out.println(bruteForceIsSorted(arr2));

        System.out.println("------------------------------------");

        System.out.println(optimalIsSorted(arr));
        System.out.println(optimalIsSorted(arr2));

    }

    private static boolean optimalIsSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean bruteForceIsSorted(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    return false;
                }
            }
        }

        return true;
    }
}

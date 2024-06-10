package com.app.google.striverA2ZDSASheet.arrays.easy;

public class MissingNum {

    public static void main(String[] args) {

        int[] arr = {1,2,4,5};

        System.out.println(findMissing(arr));
    }

    private static int findMissing(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return -1;

    }
}

package com.app.google.striverA2ZDSASheet.arrays.easy;

public class LinearSearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(findElement(arr, 93));
    }

    private static int findElement(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;

    }
}

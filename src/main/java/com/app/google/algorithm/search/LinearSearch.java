package com.app.google.algorithm.search;

public class LinearSearch {

    private int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        LinearSearch ls = new LinearSearch();

        int[] array = {2, 4, 0, 1, 9};
        int x = 1;

        int result = ls.linearSearch(array, x);

        if (result == -1)
            System.out.print("Element not found");
        else
            System.out.print("Element found at index: " + result);
    }
}


package com.app.google.ds.array;

public class MissingNumber {

    public static void main(String[] args) {

        int[] arr = {2, 4, 1, 8, 6, 3, 7};

        int n = arr.length + 1;

        long totalSum = n * (n + 1) / 2;

        for (int j : arr) {

            totalSum -= j;
        }


        System.out.println("Missing number is: " + totalSum);
    }
}

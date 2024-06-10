package com.app.google.ds.array;

public class SecondMaximum {

    public static void main(String[] args) {

        int[] mixArr = {13, 34, 2, 34, 33, 1,65, 1, 35, 31, 451, 3454, 35, 345, 43};

        System.out.println(getSecondMax(mixArr));
        System.out.println("print");
    }


    private static int getSecondMax(int[] arr) {

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int j : arr) {

            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j > secondMax && j != max) {
                secondMax = j;
            }

        }

        return secondMax;
    }
}
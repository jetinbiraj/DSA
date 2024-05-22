package com.app.google.ds.array;

import java.util.Arrays;

public class RemoveEvenInts {

    public static void main(String[] args) {

        int[] mixArr = {3, 2, 4, 7, 10, 6, 5};

        System.out.println(Arrays.toString(removeEvenInts(mixArr)));
    }


    private static int[] removeEvenInts(int[] arr) {
        int oddCount = 0;

        for (int num : arr) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        int[] oddInts = new int[oddCount];
        int i = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                oddInts[i++] = num;
            }
        }

        return oddInts;

    }
}

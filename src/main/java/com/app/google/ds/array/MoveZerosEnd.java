package com.app.google.ds.array;

import java.util.Arrays;

public class MoveZerosEnd {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 4, 12}; // {8,1,0,2,1,0,3}

        moveZerosToEnd(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void moveZerosToEnd(int[] arr) {

        int j = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0 && arr[j] == 0) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }

            if (arr[j] != 0) {
                j++;
            }
        }
    }
}

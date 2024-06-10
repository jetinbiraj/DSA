package com.app.google.striverA2ZDSASheet.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

//        int[] arr = {13, 46, 24, 52, 20, 9, 9, 9 , 9 };
        int[] arr = {1, 46, 241, 5211, 20111};

        for (int i = 0; i < arr.length; i++) {

            boolean swapped = false;

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j + 1] < arr[j]) {

                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    swapped = true;

                }

            }

            if (!swapped) {
                break;
            }

        }

        System.out.println(Arrays.toString(arr));

    }
}

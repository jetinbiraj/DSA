package com.app.google.algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BubbleSort {

    private void optimisedSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            boolean swapped = false;

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    private void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        BubbleSort bs = new BubbleSort();

        int[] arr = {-5, 6, -8, 44, 22, 455, 47, -78};

//        bs.sort(arr);
        bs.optimisedSort(arr);

        System.out.println("Sorted Array in Ascending Order:");

        System.out.println(Arrays.toString(arr));
    }
}

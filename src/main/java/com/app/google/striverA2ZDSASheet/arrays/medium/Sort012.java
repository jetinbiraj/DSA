package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort012 {

    public static void main(String[] args) {
//        int[] arr = {2, 0, 2, 1, 1, 0, 1};
//        int[] arr = {2, 2, 2, 2, 0, 0, 1, 0};
        int[] arr = {1, 1, 1, 0, 0, 1, 0, 2, 2, 0, 0, 2, 2};
//        int[] arr = {0,2};

//        optimalSortArray(arr);
//        optimalSortArray(arr);
////
//        System.out.println(Arrays.toString(arr));


//        ArrayList<Integer> list = new ArrayList<>(List.of(2, 2, 2, 2, 0, 0, 1, 0));
//        optimalSortArrayList(list, list.size());
//
//        System.out.println(list);

        System.out.println(Arrays.toString(optimalSortWithExtraArray(arr)));
    }

    private static void optimalSortArray(int[] arr) {

        int zeroPointer = 0;
        int onePointer = 0;
        int twoPointer = arr.length - 1;


        while (onePointer <= twoPointer) {

            int temp = arr[onePointer];

            if (arr[onePointer] == 0) {

                arr[onePointer] = arr[zeroPointer];
                arr[zeroPointer] = temp;
                zeroPointer++;
                onePointer++;

            } else if (arr[onePointer] == 2) {

                arr[onePointer] = arr[twoPointer];
                arr[twoPointer] = temp;
                twoPointer--;

            } else {
                onePointer++;
            }
        }
    }

    public static void optimalSortArrayList(ArrayList<Integer> arr, int n) {

        int left = 0;
        int mid = 0;
        int right = arr.size() - 1;

        while (mid <= right) {

            if (arr.get(mid) == 1) {
                mid++;
            } else if (arr.get(mid) == 0) {

                int temp = arr.get(mid);
                arr.set(mid, arr.get(left));
                arr.set(left, temp);
                left++;
                mid++;
            } else {
                int temp = arr.get(mid);
                arr.set(mid, arr.get(right));
                arr.set(right, temp);
                right--;
            }
        }
    }

    private static int[] optimalSortWithExtraArray(int[] arr) {

        int zeroPointer = 0;
        int onePointer = 0;
        int twoPointer = arr.length - 1;

        int[] resultArray = new int[arr.length];

        while (onePointer <= twoPointer) {

            for (int num : arr) {

                if (num == 2) {
                    resultArray[twoPointer--] = num;
                } else if (num == 1) {
                    resultArray[onePointer++] = num;

                } else {
                    if (zeroPointer == onePointer) {
                        resultArray[zeroPointer++] = num;
                        onePointer++;
                    } else {
                        resultArray[onePointer++] = 1;
                        resultArray[zeroPointer++] = num;
                    }
                }
            }
        }

        return resultArray;
    }


    private static void betterSort(int[] arr) {

        int zeroCounter = 0;
        int oneCounter = 0;
        int twoCounter = 0;

        for (int num : arr) {

            if (num == 0) {
                zeroCounter++;
            } else if (num == 1) {
                oneCounter++;
            } else {
                twoCounter++;
            }
        }

        int index = 0;

        for (int i = 0; i < zeroCounter; i++) {
            arr[index++] = 0;
        }

        for (int i = 0; i < oneCounter; i++) {
            arr[index++] = 1;
        }

        for (int i = 0; i < twoCounter; i++) {
            arr[index++] = 2;
        }
    }

    private static void bruteForceSort(int[] arr) {
        Arrays.sort(arr);
    }
}

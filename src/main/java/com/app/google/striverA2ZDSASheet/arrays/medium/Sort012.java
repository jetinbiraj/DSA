package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class Sort012 {

    public static void main(String[] args) {
//        int[] arr = {2, 0, 2, 1, 1, 0, 1};
//        int[] arr = {2, 2, 2, 2, 0, 0, 1, 0};
//        int[] arr = {1, 0, 2, 2, 0, 0, 2, 2};
//        int[] arr = {0,2};

//        sort(arr);
//        optimalSort(arr);
////
//        System.out.println(Arrays.toString(arr));


        ArrayList<Integer> list = new ArrayList<>(List.of(2, 2, 2, 2, 0, 0, 1, 0));
        sortArray(list, list.size());

        System.out.println(list);
    }

    private static void optimalSort(int[] arr) {

        int left = 0;
        int mid = 0;
        int right = arr.length - 1;


        while (mid <= right) {

            int temp = arr[mid];
            if (arr[mid] == 0) {
                arr[mid] = arr[left];
                arr[left] = temp;
                left++;
                mid++;
            } else if (arr[mid] == 2) {
                arr[mid] = arr[right];
                arr[right] = temp;
                right--;
            } else {
                mid++;
            }

        }
    }

    public static void sortArray(ArrayList<Integer> arr, int n) {

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

    private static void sort(int[] arr) {

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : arr) {

            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int index = 0;

        for (int i = 0; i < count0; i++) {
            arr[index++] = 0;
        }

        for (int i = 0; i < count1; i++) {
            arr[index++] = 1;
        }

        for (int i = 0; i < count2; i++) {
            arr[index++] = 2;
        }


    }
}

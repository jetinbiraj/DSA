package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class RotateByK {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

//        rotateRight(arr, 2);
//
//        System.out.println(Arrays.toString(arr));
//
//        rotateLeft(arr, 2);
//        System.out.println(Arrays.toString(arr));

        int k = 1;

//        System.out.println("After left rotation by: " + k);
//        rotateLeft(arr, k);
//        System.out.println(Arrays.toString(arr));

//        System.out.println("After right rotation by: " + k);
//        rotateRight(arr, 2);
//        System.out.println(Arrays.toString(arr));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        k = k % list.size();

        reverse(list, 0, k - 1);
        reverse(list, k, list.size() - 1);
        reverse(list, 0, list.size() - 1);

        System.out.println(list);
    }

    private static void reverse(List<Integer> arr, int start, int end) {


        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);

            start++;
            end--;
        }

    }

    private static void rotateRight(int[] arr, int k) {

        k = k % arr.length;

        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    private static void rotateLeft(int[] arr, int k) {

        k = k % arr.length;

        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

    }

    private static void reverse(int[] arr, int start, int end) {

        if (start > end) {
            return;
        }

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;

        }

    }


//    private static void rotateRight(int[] arr, int k) {
//
//        if (arr.length == 0) {
//            return;
//        }
//
//        k = k % arr.length;
//
//        if (k > arr.length) {
//            return;
//        }
//
//        int[] newArr = new int[k];
//
//        for (int i = 0; i < k; i++) {
//
//            newArr[i] = arr[arr.length - k + i];
//        }
//
//        for (int i = 0; i < arr.length - k; i++) {
//            arr[k + i] = arr[i];
//        }
//
//        for (int i = 0; i < newArr.length; i++) {
//            arr[i] = newArr[i];
//        }
//
//        System.arraycopy(newArr, 0, arr, 0, newArr.length);
//
//    }

//    private static void rotateLeft(int[] arr, int k) {
//
//        if (arr.length == 0) {
//            return;
//        }
//
//        k = k % arr.length;
//
//        if (k > arr.length) {
//            return;
//        }
//
//        int[] temp = new int[k];
//
////        int[] arr = {1, 2, 3, 4, 5, 6, 7}; k=2;
//
//        for (int i = 0; i < k; i++) {
//            temp[i] = arr[i];
//        }
//
//        for (int i = 0; i < arr.length - k; i++) {
//            arr[i] = arr[k + i];
//        }
//
//        for (int i = 0; i < k; i++) {
//            arr[arr.length - k + i] = temp[i];
//        }
//
////        System.arraycopy(temp, 0, arr, arr.length - k, k);
//
//    }
}

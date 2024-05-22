package com.app.google.striverA2ZDSASheet.arrays.easy;

public class SecondLargest {

    public static void main(String[] args) {

        int[] arr = {13, 3, 46, 24, 52, 20, 9, 9, 9, 50, 50};

        int maxNum = Integer.MIN_VALUE;
        int secondMaxNum = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {

//            if (arr[i] > secondMaxNum) {
//
//                secondMaxNum = arr[i];
//
//                if (secondMaxNum > maxNum) {
//                    int temp = secondMaxNum;
//
//                    secondMaxNum = maxNum;
//                    maxNum = temp;
//                }
//
//            }

            if (arr[i] > maxNum) {
                secondMaxNum = maxNum;
                maxNum = arr[i];
            } else if (arr[i] > secondMaxNum && arr[i] != maxNum) {
                secondMaxNum = arr[i];
            }

        }

        System.out.println(secondMaxNum);

    }
}

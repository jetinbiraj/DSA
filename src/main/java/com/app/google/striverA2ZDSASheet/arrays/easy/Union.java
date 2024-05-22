package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.*;

public class Union {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};

//        System.out.println(Arrays.toString(union(arr1, arr2)));

        System.out.println(twoPointerUnion(arr1, arr2));

    }

    private static List<Integer> twoPointerUnion(int[] a, int[] b) {

        List<Integer> list = new ArrayList<>();

        int pointer1=0;
        int pointer2=0;

        while(pointer1 < a.length && pointer2 <b.length){

            if(a[pointer1] <= b[pointer2]) {


                if(list.isEmpty() || list.getLast() != a[pointer1]){
                    list.add(a[pointer1]);
                }

                pointer1++;
            } else {

                if(list.isEmpty() || list.getLast() != b[pointer2]){
                    list.add(b[pointer2]);
                }

                pointer2++;
            }

        }

        while(pointer1 < a.length){

            if(list.isEmpty() || list.getLast() != a[pointer1]){
                list.add(a[pointer1]);
            }

            pointer1++;
        }

        while(pointer2 < b.length){

            if(list.isEmpty() || list.getLast() != b[pointer2]){
                list.add(b[pointer2]);
            }

            pointer2++;
        }

        return list;


//        List<Integer> list = new ArrayList<>();
//
//        int pointer1 = 0;
//        int pointer2 = 0;
//
//        while (pointer1 < arr1.length && pointer2 < arr2.length) {
//
//            if (arr1[pointer1] <= arr2[pointer2]) {
//
//                if (list.isEmpty() || list.getLast() != arr1[pointer1]) {
//                    list.add(arr1[pointer1]);
//                }
//
//                pointer1++;
//
//            } else {
//
//                if (list.isEmpty() || list.getLast() != arr2[pointer2]) {
//                    list.add(arr2[pointer2]);
//                }
//
//                pointer2++;
//
//            }
//
//        }
//
//        while (pointer1 < arr1.length) {
//
//            if (list.isEmpty() || list.getLast() != arr1[pointer1]) {
//                list.add(arr1[pointer1]);
//            }
//
//            pointer1++;
//        }
//
//        while (pointer2 < arr2.length) {
//
//            if (list.isEmpty() || list.getLast() != arr1[pointer2]) {
//                list.add(arr2[pointer2]);
//            }
//
//            pointer2++;
//        }
//
//        return list;

    }


    private static int[] union(int[] arr1, int[] arr2) {

        Set<Integer> set = new HashSet<>();

        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            set.add(num);
        }

        int[] result = new int[set.size()];
        int pointer = 0;
        for (int num : set) {
            result[pointer++] = num;
        }

        return result;

    }
}

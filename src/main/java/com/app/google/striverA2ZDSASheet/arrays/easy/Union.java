package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.*;

public class Union {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] arr2 = {2, 3, 4, 4, 4, 5, 11, 12};

        System.out.println(Arrays.toString(unionUsingSet(arr1, arr2)));

        System.out.println(twoPointerUnion(arr1, arr2));

    }

    private static List<Integer> twoPointerUnion(int[] arr1, int[] arr2) {

        List<Integer> list = new ArrayList<>();

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < arr1.length && pointer2 < arr2.length) {

            if (arr1[pointer1] <= arr2[pointer2]) {


                if (list.isEmpty() || list.getLast() != arr1[pointer1]) {
                    list.add(arr1[pointer1]);
                }

                pointer1++;
            } else {

                if (list.isEmpty() || list.getLast() != arr2[pointer2]) {
                    list.add(arr2[pointer2]);
                }

                pointer2++;
            }
        }

        while (pointer1 < arr1.length) {

            if (list.isEmpty() || list.getLast() != arr1[pointer1]) {
                list.add(arr1[pointer1]);
            }

            pointer1++;
        }

        while (pointer2 < arr2.length) {

            if (list.isEmpty() || list.getLast() != arr2[pointer2]) {
                list.add(arr2[pointer2]);
            }

            pointer2++;
        }

        return list;
    }


    private static int[] unionUsingSet(int[] arr1, int[] arr2) {

        Set<Integer> union = new TreeSet<>();

        for (int num : arr1) {
            union.add(num);
        }

        for (int num : arr2) {
            union.add(num);
        }

        int[] result = new int[union.size()];
        int pointer = 0;
        for (int num : union) {
            result[pointer++] = num;
        }

        return result;
    }
}

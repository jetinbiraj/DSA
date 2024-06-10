package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3,3, 4, 4, 5, 11, 12};

        System.out.println(intersection(arr1, arr2));

    }

    private static List<Integer> intersection(int[] arr1, int[] arr2) {

        List<Integer> list = new ArrayList<>();

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < arr1.length && pointer2 < arr2.length) {

            if (arr1[pointer1] == arr2[pointer2]) {
                list.add(arr1[pointer1]);
                pointer1++;
                pointer2++;
            } else if (arr1[pointer1] < arr2[pointer2]) {
                pointer1++;
            } else {
                pointer2++;
            }

        }

        return list;

    }
}

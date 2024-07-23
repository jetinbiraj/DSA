package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.*;

public class RemoveDuplicatesFromSorted {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 3, 3, 3, 4, 4, 5, 6};

        System.out.println(removeDuplicates(arr));

        System.out.println(Arrays.toString(arr));

        System.out.println(removeDuplicatesViaSet(arr));

        System.out.println(Arrays.toString(arr));
    }

    private static int removeDuplicates(int[] arr) {

        int pointer = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[pointer] != arr[i]) {
                arr[++pointer] = arr[i];
            }
        }

        return pointer + 1;
    }

    private static int removeDuplicatesViaSet(int[] arr) {

        SortedSet<Integer> sortedSet = new TreeSet<>();

        for (int num : arr) {
            sortedSet.add(num);
        }

        int index = 0;
        for (int num : sortedSet) {
            arr[index++] = num;
        }

        return index;
    }
}

package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 4, 3, 0, 0};

        //ans {2,3,0,0,1,4,5}
        optimalNextGreaterPermutation(arr);

        System.out.println(Arrays.toString(arr));

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,1,5,4,3,0,0));

        System.out.println(nextPermutation(list));

    }

    private static void optimalNextGreaterPermutation(int[] arr) {

        int index = -1;

        for (int i = arr.length - 1; i > 0; i--) {

            if (arr[i - 1] < arr[i]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {

            int start = 0;
            int end = arr.length - 1;

            while (start < end) {
                int temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            }
            return;

        }

        int nextSmallIndex = -1;

        for (int i = arr.length - 1; i > index; i--) {

            if (arr[i] > arr[index]) {
                nextSmallIndex = i;
                break;
            }

        }

        int temp = arr[nextSmallIndex];
        arr[nextSmallIndex] = arr[index];
        arr[index] = temp;

        int start = index + 1;
        int end = arr.length - 1;

        while (start < end) {
            temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }

    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {

        int index = -1;

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = permutation.size() - 1; i > 0; i--) {

            if (permutation.get(i - 1) < permutation.get(i)) {
                index = i - 1;
                break;
            }

        }

        if (index == -1) {
            int start = 0;
            int end = permutation.size() - 1;

            while (start <= end) {
                res.add(permutation.get(end--));
            }

            return res;
        } else {

            int nextSmallIndex = -1;

            for (int i = permutation.size() - 1; i > index; i--) {
                if (permutation.get(i) > permutation.get(index)) {
                    nextSmallIndex = i;
                    break;
                }
            }

            int temp = permutation.get(nextSmallIndex);
            permutation.set(nextSmallIndex, permutation.get(index));
            permutation.set(index, temp);

            for (int i = 0; i <= index; i++) {
                res.add(permutation.get(i));
            }

            for (int i = permutation.size() - 1; i > index; i--) {
                res.add(permutation.get(i));
            }

            return res;
        }
    }
}

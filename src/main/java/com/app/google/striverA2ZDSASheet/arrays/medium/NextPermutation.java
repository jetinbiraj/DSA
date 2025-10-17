package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 2};

        optimalNextGreaterPermutation(arr);

        System.out.println(Arrays.toString(arr));

//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 5, 4, 3, 0, 0));
//
//        System.out.println(nextPermutation(list));
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

            rotateArray(arr, 0, arr.length - 1);
        } else {

            int nextSmallElementIndex = -1;

            for (int i = arr.length - 1; i > index; i--) {

                if (arr[i] > arr[index]) {
                    nextSmallElementIndex = i;
                    break;
                }
            }

            int tempSwappingVariable = arr[nextSmallElementIndex];
            arr[nextSmallElementIndex] = arr[index];
            arr[index] = tempSwappingVariable;

            rotateArray(arr, index + 1, arr.length - 1);
        }
    }

    private static void rotateArray(int[] arr, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int tempSwappingVariable = arr[startIndex];
            arr[startIndex++] = arr[endIndex];
            arr[endIndex--] = tempSwappingVariable;
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

            int nextSmallElementIndex = -1;

            for (int i = permutation.size() - 1; i > index; i--) {
                if (permutation.get(i) > permutation.get(index)) {
                    nextSmallElementIndex = i;
                    break;
                }
            }

            int temp = permutation.get(nextSmallElementIndex);
            permutation.set(nextSmallElementIndex, permutation.get(index));
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

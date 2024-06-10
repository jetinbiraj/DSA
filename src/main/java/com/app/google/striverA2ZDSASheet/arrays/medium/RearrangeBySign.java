package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.Arrays;

public class RearrangeBySign {

    public static void main(String[] args) {

        int[] arr = {1, 2, -3, -1, -2, 3,-4};

        bruteArrange(arr);

//        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(optimalArrange(arr)));
    }

    private static int[] optimalArrange(int[] arr) {

        int[] res = new int[arr.length];

        int posIndex = 0;
        int negIndex = 1;

        for (int j : arr) {

            if (j > 0) {
                res[posIndex] = j;
                posIndex += 2;
            } else {
                res[negIndex] = j;
                negIndex += 2;
            }

        }

        return res;
    }


    private static void bruteArrange(int[] arr) {

        int[] posArr = new int[arr.length / 2];
        int[] negArr = new int[arr.length / 2];
        int posIndex = 0;
        int nexIndex = 0;

        for (int num : arr) {

            if (num > 0) {
                posArr[posIndex++] = num;
            } else {
                negArr[nexIndex++] = num;
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {

            arr[2 * i] = posArr[i];
            arr[2 * i + 1] = negArr[i];
        }

    }
}

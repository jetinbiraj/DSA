package com.app.google.striverA2ZDSASheet.stackandQueues.monotonic;

import java.util.ArrayList;
import java.util.Arrays;

public class RightNGENumber {

    public static void main(String[] args) {

        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] indices = {0, 5};

        System.out.println(Arrays.toString(countNGE(arr.length, arr, indices.length, indices)));
    }

    private static int[] countNGE(int N, int[] arr, int queries, int[] indices) {


        int[] ans = new int[queries];

        int itPointer = 0;

        for (int index : indices) {

            int NGE = 0;

            for (int i = index + 1; i < N; i++) {

                if (arr[index] < arr[i]) {
                    NGE++;
                }
            }

            ans[itPointer++] = NGE;
        }

        return ans;
    }
}

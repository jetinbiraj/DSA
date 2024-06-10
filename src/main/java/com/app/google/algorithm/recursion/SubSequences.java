package com.app.google.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequences {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        int[] arr = {3, 1, 2};

        subSequences(0, arr, list, 3);
    }

    private static void subSequences(int index, int[] arr, List<Integer> list, int n) {

        if (index == n) {
            System.out.println(list);
            return;
        }

        list.add(arr[index]);
        subSequences(index + 1, arr, list, n);
        list.removeLast();

        subSequences(index + 1, arr, list, n);
    }
}

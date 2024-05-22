package com.app.google.ds.array;

import java.util.Arrays;

public class ArrayDeclaration {

    public static void main(String[] args) {

        int[] arr = new int[5];

        int[] arr2 = {1, 2, 3, 4, 5};

        arr[1] = 12;
        arr[2] = 15;
        arr[3] = 18;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}

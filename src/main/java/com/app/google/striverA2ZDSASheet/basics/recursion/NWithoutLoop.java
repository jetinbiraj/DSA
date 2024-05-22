package com.app.google.striverA2ZDSASheet.basics.recursion;

import java.util.Arrays;

public class NWithoutLoop {

    public static void main(String[] args) {

        int target = 101;

        System.out.println(Arrays.toString(printNos(target)));

    }



    public static int[] printNos(int x) {

        int[] arr = new int[x];

        addNumbers(arr, x, 1);

            return arr;
    }

    private static void addNumbers(int[] arr, int target, int current){

        arr[current-1] = current;

        if(current >= target){

            return;

        }

        addNumbers(arr, target, current+1);

    }
}

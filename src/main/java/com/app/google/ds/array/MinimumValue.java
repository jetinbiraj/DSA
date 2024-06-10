package com.app.google.ds.array;

import java.util.Arrays;
import java.util.OptionalInt;

public class MinimumValue {

    public static void main(String[] args) {

//        int[] mixArr = {21, 2, 11, 5, 10, 7, 8, 1};
        int[] mixArr = {};

//        System.out.println(findMinValue(mixArr));

        OptionalInt optionalInt = findMinValue(mixArr);

        if (optionalInt.isPresent()) {
            System.out.println(optionalInt.getAsInt());
        } else {
            System.out.println("Result could not be found");
        }
    }


    private static OptionalInt findMinValue(int[] arr) {

//        int minValue = arr[0];
//
//        for (int num : arr) {
//            if (num<minValue){
//                minValue = num;
//            }
//        }
        //        return minValue;


        return Arrays.stream(arr).min();
    }
}

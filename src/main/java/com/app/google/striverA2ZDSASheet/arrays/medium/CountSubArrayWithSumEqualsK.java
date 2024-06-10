package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.HashMap;

public class CountSubArrayWithSumEqualsK {

    public static void main(String[] args) {


        int[] arr = {1, 1, 1};

        int sum = 2;


//        System.out.println(bruteFindAllSubArraysWithGivenSum(arr, sum));
        System.out.println(optimalFindAllSubArraysWithGivenSum(arr, sum));
    }

    private static int optimalFindAllSubArraysWithGivenSum(int[] arr, int sum) {

        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>(); //preSum, count
        map.put(0, 1);

        int preSum = 0;

        for (int num : arr) {

            preSum += num;

            int removal = preSum - sum;

           count += map.getOrDefault(removal, 0);

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        }

        return count;
    }


    private static int bruteFindAllSubArraysWithGivenSum(int[] arr, int sum) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            int trackSum = 0;

            for (int j = i; j < arr.length; j++) {

                trackSum += arr[j];

                if (trackSum == sum) {
                    count += 1;
                }
            }

        }

        return count;

    }
}

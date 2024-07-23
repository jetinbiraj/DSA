package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.HashMap;

public class CountSubArrayWithSumEqualsK {

    public static void main(String[] args) {

//        int[] arr = {1, 1, 1};
//        int[] arr = {3, 1, 2, 4, 1, 1, 1, 1, 1, 1};
//        int[] arr = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int[] arr = {3, -3, 1, 1, 1};

        int sum = 3;

        System.out.println(bruteFindAllSubArraysWithGivenSum(arr, sum));
        System.out.println(betterFindAllSubArrayWithGivenSum(arr, sum));
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

    private static int betterFindAllSubArrayWithGivenSum(int[] arr, int target) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            long sum = 0;

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];

                if (sum == target) {
                    count++;
                }
            }
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

package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sum2 {

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;

//        int[] arr = {2, 6, 5, 8, 11};
//        int target = 14;

        System.out.println(Arrays.toString(bruteSum(arr, target)));
        System.out.println(Arrays.toString(betterSum(arr, target)));
        System.out.println(Arrays.toString(optimalSum(arr, target)));
    }

    /**
     * This solution only works for sorted array
     *
     * @param arr    input array
     * @param target target sum up from two elements from the array
     * @return indices of the array the elements at which sums up to target
     */
    private static int[] optimalSum(int[] arr, int target) {

        int leftPointer = 0;
        int rightPointer = arr.length - 1;

        while (leftPointer < rightPointer) {

            if (arr[leftPointer] + arr[rightPointer] == target) {
                return new int[]{leftPointer, rightPointer};
            } else if (arr[leftPointer] + arr[rightPointer] < target) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return new int[]{-1, -1};
    }

    private static int[] betterSum(int[] arr, int target) {

        Map<Integer, Integer> elementIndexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int compliment = target - arr[i];

            if (elementIndexMap.containsKey(compliment)) {
                return new int[]{elementIndexMap.get(compliment), i};
            }

            elementIndexMap.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }

    private static int[] bruteSum(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (i == j) {
                    continue;
                }

                if (arr[i] + arr[j] == target) {

                    return new int[]{i, j};

                }
            }
        }

        return new int[]{-1, -1};
    }
}

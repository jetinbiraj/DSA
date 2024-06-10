package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sum2 {

    public static void main(String[] args) {

//        int[] arr = {2, 7, 11, 15};
//        int target = 9;

        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

//        System.out.println(Arrays.toString(bruteSum(arr, target)));
        System.out.println(Arrays.toString(betterSum(arr, target)));
//        System.out.println(Arrays.toString(twoPointerSum(arr, target)));

    }

//    private static int[] twoPointerSum(int[] arr, int target) {
//
//        Arrays.sort(arr);
//
//        int left = 0;
//        int right = arr.length - 1;
//
//        while (left < right) {
//
//            if (arr[left] + arr[right] == target) {
//                return new int[]{left, right};
//            } else if (arr[left] + arr[right] < target) {
//
//                left++;
//
//            } else {
//                right--;
//            }
//        }
//
//        return new int[]{-1, -1};
//    }

    private static int[] betterSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int sub = target - arr[i];

            if (map.containsKey(sub)) {
                return new int[]{i, map.get(sub)};
            }

            map.put(arr[i], i);

        }

        return new int[]{-1, -1};
    }

    private static int[] bruteSum(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j != i && j < arr.length; j++) {

                if (arr[i] + arr[j] == target) {

                    return new int[]{i, j};

                }

            }

        }

        return new int[]{-1, -1};
    }
}

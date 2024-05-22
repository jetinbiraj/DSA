package com.app.google.striverA2ZDSASheet.arrays.easy;

public class LongestSubArraySumK {

    public static void main(String[] args) {

//        int[] arr = {2, 3, 5, 1, 9};
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 3, 3};
        int k = 6;
//        int k = 10;

        System.out.println(longestSubArray(arr, k));
        System.out.println(betterLongestSubArray(arr, k));
//        System.out.println(optimalLongestSubArray(arr, k));
    }

//    private static int optimalLongestSubArray(int[] arr, int target) { //TODO: Needs to look into it
//
////        int[] arr = {2, 3, 5, 1, 9};
////        int k = 10;
//
//        int slowPointer = 0;
//        int fastPointer = 0;
//
//        int sum = 0;
//        int counter = 0;
//
//        while (slowPointer < arr.length) {
//
//            sum += arr[fastPointer];
//
//            if (sum < target) {
//                fastPointer++;
//            } else if (sum == target) {
//                counter = Math.max(counter, fastPointer - slowPointer + 1);
//            } else {
//                sum -= arr[slowPointer++];
//            }
//        }
//
//
//        return counter;
//
//    }

    private static int betterLongestSubArray(int[] arr, int target) {

        //        int[] arr = {2, 3, 5, 1, 9};
        //        int k = 10;

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            long sum = 0;

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];

                if (sum == target) {
                    count = Math.max(count, j - i + 1);
                } else if (sum > target) {
                    break;
                }
            }

        }

        return count;
    }


    private static int longestSubArray(int[] arr, int target) {

//        int[] arr = {2, 3, 5, 1, 9};
//        int k = 10;

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                long sum = 0;

                for (int x = i; x <= j; x++) {
                    sum += arr[x];
                }

                if (sum == target) {
                    count = Math.max(count, j - i + 1);
                } else if (sum > target) {
                    break;
                }
            }

        }

        return count;
    }
}

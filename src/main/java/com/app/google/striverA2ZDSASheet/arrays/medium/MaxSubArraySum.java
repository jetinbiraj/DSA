package com.app.google.striverA2ZDSASheet.arrays.medium;


public class MaxSubArraySum {

    public static void main(String[] args) {


        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

//        System.out.println(bruteMaxSum(arr));
//        System.out.println(optimalMaxSum(arr));

        followUpOptimalMaxSum(arr);
    }

    private static void followUpOptimalMaxSum(int[] arr) {

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;

        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] + sum > sum) {

                sum = arr[i] + sum;

            } else {
                sum = arr[i];
                startIndex = i;
            }

            if (sum > maxSum) {
                maxSum = sum;
                endIndex = i;
            }

        }

        System.out.println(startIndex + " .... " + endIndex);

        for (int i = startIndex; i <= endIndex; i++) {

            System.out.print(arr[i] + " ");
        }
    }

    private static int optimalMaxSum(int[] arr) {

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;

        for (int num : arr) {

            sum = Math.max(num, sum + num);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    private static long bruteMaxSum(int[] arr) {

        long maxSum = Long.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];
                maxSum = Math.max(maxSum, sum);

            }

        }

        return maxSum;
    }

}


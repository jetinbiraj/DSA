package com.app.google.striverA2ZDSASheet.arrays.medium;

public class PrintMaxSubArraySum {

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        bruteMaxSum(arr);
        System.out.println("---------------------------");
        optimalMaxSum(arr);
    }

    private static void optimalMaxSum(int[] arr) {

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;

        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < arr.length; i++) {

            sum = Math.max(arr[i], sum + arr[i]);

            if (sum == arr[i]) {
                startIndex = i;
            }

            if (sum > maxSum) {
                endIndex = i;
                maxSum = sum;
            }
        }

        System.out.println(startIndex + " .... " + endIndex);

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void bruteMaxSum(int[] arr) {

        int maxSum = Integer.MIN_VALUE;

        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];

                if (sum > maxSum) {
                    maxSum = sum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }

        System.out.println(startIndex + " .... " + endIndex);

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

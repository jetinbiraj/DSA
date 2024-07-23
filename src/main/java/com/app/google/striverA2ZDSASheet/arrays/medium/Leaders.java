package com.app.google.striverA2ZDSASheet.arrays.medium;

public class Leaders {

    public static void main(String[] args) {

        int[] arr = {10, 22, 12, 3, 0, 6};

        bruteForceLeaders(arr);
        System.out.println("\n---------------------------------");
        optimalLeaders(arr);
    }

    private static void optimalLeaders(int[] arr) {

        int maxElement = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] > maxElement) {
                maxElement = arr[i];
                System.out.print(maxElement + " ");
            }
        }
    }

    private static void bruteForceLeaders(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {

            boolean isLeader = true;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] > arr[i]) {
                    isLeader = false;
                    break;
                }
            }

            if (isLeader) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}

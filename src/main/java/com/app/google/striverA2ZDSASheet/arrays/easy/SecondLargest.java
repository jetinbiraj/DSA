package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.Arrays;

public class SecondLargest {

    public static void main(String[] args) {

        int[] arr = {13, 3, 46, 24, 52, 20, 9, 9, 9, 50, 51};

        System.out.println(bruteForceSecondLargest(arr));
        System.out.println(betterSecondLargest(arr));
        System.out.println(optimalSecondLargest(arr));

    }

    private static int optimalSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int element : arr) {
            if (element > largest) {
                secondLargest = largest;
                largest = element;
            } else if (element > secondLargest && element != largest) {
                secondLargest = element;
            }
        }

        return secondLargest;
    }


    private static int betterSecondLargest(int[] arr) {
        int largestElement = Integer.MIN_VALUE;
        int secondLargestElement = Integer.MIN_VALUE;

        for (int element : arr) {
            largestElement = Math.max(element, largestElement);
        }

        for (int element : arr) {
            if (element > secondLargestElement && element != largestElement) {
                secondLargestElement = element;
            }

        }

        return secondLargestElement;
    }


    private static int bruteForceSecondLargest(int[] arr) {
        Arrays.sort(arr);

        int largestElement = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != largestElement) {
                return arr[i];
            }
        }
        return -1;
    }
}

package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongConsSequence {

    public static void main(String[] args) {

//        int[] arr = {1, 2, 2, 1}; // 1, 1 , 2 , 2
//        int[] arr = {1, 2, 0, 1}; // 0, 1 , 1 , 2
        int[] arr = {3, 0, 2, 1, 21, 25, 24, 22, 23, 25, 53, 56, 51, 54, 52, 55, 57};

        System.out.println(bruteForceLargestConsecutiveSequence(arr));
        System.out.println(betterLongestConsecutiveSequence(arr));
        System.out.println(optimalLongestConsecutive(arr));
    }

    private static int optimalLongestConsecutive(int[] arr) {

        int largestConsecutiveSequenece = 1;

        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int consecutiveSequenceCount = 0;

                while (set.contains(num)) {
                    consecutiveSequenceCount++;
                    num += 1;
                }

                largestConsecutiveSequenece = Math.max(largestConsecutiveSequenece, consecutiveSequenceCount);
            }
        }

        return largestConsecutiveSequenece;
    }

    private static int betterLongestConsecutiveSequence(int[] arr) {

        int largestConsecutiveSequenece = 1;

        int consecutiveSequenceCount = 0;

        int lastSmallerElement = Integer.MIN_VALUE;

        Arrays.sort(arr);

        for (int num : arr) {

            if (num - 1 == lastSmallerElement) {

                consecutiveSequenceCount += 1;
                lastSmallerElement = num;

            } else if (lastSmallerElement != num) {
                consecutiveSequenceCount = 1;
                lastSmallerElement = num;
            }

            largestConsecutiveSequenece = Math.max(consecutiveSequenceCount, largestConsecutiveSequenece);
        }

        return largestConsecutiveSequenece;
    }

    private static int bruteForceLargestConsecutiveSequence(int[] arr) {

        int largestConsecutiveSequenece = 0;

        Set<Integer> visitedElements = new HashSet<>();

        for (int num : arr) {

            if (!visitedElements.contains(num)) {
                largestConsecutiveSequenece = Math.max(largestConsecutiveSequenece, getConsecutiveSequence(arr, visitedElements, num, 1));
            }
        }

        return largestConsecutiveSequenece;
    }

    private static int getConsecutiveSequence(int[] arr, Set<Integer> visitedElements, int num, int consecutiveSequenceCount) {

        visitedElements.add(num);

        for (int arrNum : arr) {
            if (arrNum + 1 == num) {
                consecutiveSequenceCount += 1;
                return getConsecutiveSequence(arr, visitedElements, arrNum, consecutiveSequenceCount);
            }
        }

        return consecutiveSequenceCount;
    }
}

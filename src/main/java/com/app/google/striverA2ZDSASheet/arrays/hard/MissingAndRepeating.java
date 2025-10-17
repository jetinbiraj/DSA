package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingAndRepeating {

    public static void main(String[] args) {

//        int[] arr = {3, 1, 2, 5, 3}; //1, 2, 3, 3, 5, 6, 7
//        int[] arr = {2, 2};
        int[] arr = {13, 33, 43, 16, 25, 19, 23, 31, 29, 35, 10, 2, 32, 11, 47, 15, 34, 46, 30, 26, 41, 18, 5, 17, 37, 39, 6, 4, 20, 27, 9, 3, 8, 40, 24, 44, 14, 36, 7, 38, 12, 1, 42, 12, 28, 22, 45};

        System.out.println(Arrays.toString(bruteForceFindMissingAndRepeatingElements(arr, arr.length)));
        System.out.println(Arrays.toString(betterFindMissingAndRepeatingElementsUsingHashArray(arr, arr.length)));
        System.out.println(Arrays.toString(betterFindMissingAndRepeatingElementsUsingHashSet(arr, arr.length)));
        System.out.println(Arrays.toString(optimalFindMissingAndRepeatingElementsUsingSum(arr, arr.length)));
        System.out.println(Arrays.toString(optimalFindMissingAndRepeatingElements(arr, arr.length)));
    }

    private static int[] optimalFindMissingAndRepeatingElementsUsingXor(int[] arr, int n) {

        //TODO: Not big fan of it

        return new int[]{0, 0};
    }

    private static int[] optimalFindMissingAndRepeatingElements(int[] arr, int n) {

        long sumNatural = ((long) n * (n + 1)) / 2;
        long sumNaturalSquare = (n * (n + 1) * (2L * n + 1)) / 6;

        long sum = 0;
        long sumSquare = 0;

        for (int num : arr) {
            sum += num;
            sumSquare += (long) num * num;
        }

        long diffVal = sum - sumNatural;
        long squareDiffVal = sumSquare - sumNaturalSquare;

        squareDiffVal = squareDiffVal / diffVal;

        long repeating = (diffVal + squareDiffVal) / 2;
        long missing = repeating - diffVal;

        return new int[]{(int) repeating, (int) missing};
    }

    private static int[] optimalFindMissingAndRepeatingElementsUsingSum(int[] arr, int n) {

        Set<Integer> tempSet = new HashSet<>();

        long sumNNumbers = (long) n * (n + 1) / 2;
        long sumArrayElements = 0;
        int repeatingNum = -1;
        boolean foundRepeatingNum = false;

        for (int num : arr) {

            if (!foundRepeatingNum && tempSet.contains(num)) {
                repeatingNum = num;
                foundRepeatingNum = true;
            } else {
                tempSet.add(num);
            }

            sumArrayElements += num;
        }

        int missingNum = (int) (sumNNumbers - (sumArrayElements - repeatingNum));

        return new int[]{repeatingNum, missingNum};
    }


    private static int[] betterFindMissingAndRepeatingElementsUsingHashSet(int[] arr, int n) {

        int[] missingAndRepeatingElementArray = new int[2];

        Set<Integer> tempSet = new HashSet<>();

        for (int num : arr) {

            if (tempSet.contains(num)) {
                missingAndRepeatingElementArray[0] = num;
            }
            tempSet.add(num);
        }

        for (int i = 1; i <= n; i++) {
            if (!tempSet.contains(i)) {
                missingAndRepeatingElementArray[1] = i;
                break;
            }
        }

        return missingAndRepeatingElementArray;
    }

    private static int[] betterFindMissingAndRepeatingElementsUsingHashArray(int[] arr, int n) {

        int[] missingAndRepeatingElementArray = new int[2];

        int[] tempHashArray = new int[n + 1];

        boolean foundRepeatingNumber = false;
        boolean foundMissingNumber = false;

        for (int num : arr) {
            tempHashArray[num]++;
        }

        for (int i = 1; i <= n; i++) {

            if (tempHashArray[i] == 2) {
                missingAndRepeatingElementArray[0] = i;
                foundRepeatingNumber = true;

            } else if (tempHashArray[i] == 0) {
                missingAndRepeatingElementArray[1] = i;
                foundMissingNumber = true;
            }

            if (foundMissingNumber && foundRepeatingNumber) {
                break;
            }
        }

        return missingAndRepeatingElementArray;
    }


    private static int[] bruteForceFindMissingAndRepeatingElements(int[] arr, int n) {

        int[] missingAndRepeatingElementArray = new int[2];

        boolean foundRepeatingNumber = false;
        boolean foundMissingNumber = false;

        for (int i = 1; i <= n; i++) {

            int count = 0;

            for (int num : arr) {

                if (i == num) {
                    count++;
                }
            }

            if (count == 2) {
                missingAndRepeatingElementArray[0] = i;
                foundRepeatingNumber = true;
            } else if (count == 0) {
                missingAndRepeatingElementArray[1] = i;
                foundMissingNumber = true;
            }

            if (foundMissingNumber && foundRepeatingNumber) {
                break;
            }

        }

        return missingAndRepeatingElementArray;
    }
}

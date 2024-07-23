package com.app.google.striverA2ZDSASheet.arrays.easy;

public class MissingNum {

    public static void main(String[] args) {

        int[] arr = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println(bruteForceFindMissingElement(arr));
        System.out.println(betterFindMissingElement(arr));
        System.out.println(optimalFindMissing(arr));
        System.out.println(optimalFindMissing2(arr));
    }

    private static int optimalFindMissing(int[] arr) {

        int naturalNumberSum = arr.length * (arr.length + 1) / 2;

        for (int num : arr) {
            naturalNumberSum -= num;
        }

        return naturalNumberSum;
    }

    private static int optimalFindMissing2(int[] arr) {

        int xor1 = 0;
        int xor2 = 0;

        for (int i = 0; i < arr.length; i++) {
            xor1 ^= arr[i];
            xor2 ^= i;
        }

        xor1 ^= arr.length;
        return xor1 ^ xor2;
    }

    private static int betterFindMissingElement(int[] arr) {

        int[] hashArray = new int[arr.length + 1];

        for (int num : arr) {
            hashArray[num]++;
        }

        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] == 0) {
                return i;
            }
        }

        return -1;
    }


    private static int bruteForceFindMissingElement(int[] arr) {

        for (int i = 1; i <= arr.length; i++) {

            boolean exists = false;

            for (int num : arr) {
                if (num == i) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                return i;
            }
        }

        return -1;
    }
}

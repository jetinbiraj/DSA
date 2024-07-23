package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithXORK {

    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;

        System.out.println(bruteForceSubArraysWithXOR(arr, k));
        System.out.println(betterSubArraysWithXORK(arr, k));
        System.out.println(optimalSubArraysWithXORK(arr, k));
    }

    private static int optimalSubArraysWithXORK(int[] arr, int k) {

        int xorSubArraysCount = 0;

        Map<Integer, Integer> frontXorMap = new HashMap<>();
        frontXorMap.put(0, 1);

        int xor = 0;

        for (int num : arr) {

            xor = xor ^ num;

            int xorK = xor ^ k;

            if (frontXorMap.containsKey(xorK)) {
                xorSubArraysCount += frontXorMap.get(xorK);
            }

            frontXorMap.put(xor, frontXorMap.getOrDefault(xor, 0) + 1);
        }

        return xorSubArraysCount;
    }

    private static int betterSubArraysWithXORK(int[] arr, int k) {

        int xorSubArraysCount = 0;

        for (int i = 0; i < arr.length; i++) {

            int xor = 0;

            for (int j = i; j < arr.length; j++) {

                xor = xor ^ arr[j];

                if (xor == k) {

                    xorSubArraysCount++;
                }
            }
        }

        return xorSubArraysCount;
    }

    private static int bruteForceSubArraysWithXOR(int[] arr, int target) {

        int xorSubArraysCount = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                int xor = 0;

                for (int k = i; k <= j; k++) {
                    xor = xor ^ arr[k];
                }

                if (xor == target) {
                    xorSubArraysCount++;
                }
            }
        }

        return xorSubArraysCount;
    }
}

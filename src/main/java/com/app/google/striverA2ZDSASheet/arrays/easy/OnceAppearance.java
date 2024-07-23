package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class OnceAppearance {

    public static void main(String[] args) {

        int[] arr = {4, 1, 2, 1, 2};

        System.out.println(betterFind(arr));
        System.out.println(bruteFind(arr));
        System.out.println(optimalFind(arr));

    }

    private static int optimalFind(int[] arr) {

        int xor = 0;

        for (int num : arr) {

            xor = xor ^ num;
        }

        return xor;
    }

    private static int betterFind(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() == 1) {
                return entry.getKey();
            }

        }

        return -1;
    }

    private static int bruteFind(int[] arr) {

        for (int num : arr) {

            int count = 0;

            for (int anotherNum : arr) {
                if (num == anotherNum) {
                    count++;
                }
            }

            if (count == 1) {
                return num;
            }
        }

        return -1;
    }
}

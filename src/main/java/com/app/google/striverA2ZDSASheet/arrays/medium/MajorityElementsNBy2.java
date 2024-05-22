package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementsNBy2 {

    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 1, 1, 2, 2};
//        int[] arr = {3,2,3};

//        System.out.println(BruteMajorityElement(arr));
        System.out.println(betterMajorityElement(arr));
        System.out.println(optimalMajorityElement(arr));

    }

    private static int optimalMajorityElement(int[] arr) {
        int element = 0;
        int count = 0;

        for (int num : arr) {

            if (count == 0) {
                element = num;
            }

            if (num == element) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }

    private static int betterMajorityElement(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>(); //num, count

        for (int num : arr) {

            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > arr.length / 2) {
                return num;
            }

        }

        return -1;
    }

    private static int BruteMajorityElement(int[] arr) {

        for (int num : arr) {

            int count = 0;

            for (int key : arr) {

                if (num == key) {
                    count++;

                    if (count > arr.length / 2) {
                        return num;
                    }
                }

            }
        }
        return -1;
    }
}

package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementsNBy2 {

    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(bruteMajorityElement(arr));
        System.out.println(betterMajorityElement(arr));
        System.out.println(betterMajorityElement2(arr));
        System.out.println(optimalMajorityElement(arr));
    }

    private static int optimalMajorityElement(int[] arr) {

        int element = 0;
        int count = 0;

        for (int num : arr) {

            if (count == 0) {
                element = num;
                count++;
            } else if (num == element) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }

    private static int betterMajorityElement(int[] arr) {

        Map<Integer, Integer> elementOccuranceMap = new HashMap<>();

        for (int num : arr) {

            elementOccuranceMap.put(num, elementOccuranceMap.getOrDefault(num, 0) + 1);

            if (elementOccuranceMap.get(num) > arr.length / 2) {
                return num;
            }

        }

        return -1;
    }

    private static int betterMajorityElement2(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2 + 1];
    }

    private static int bruteMajorityElement(int[] arr) {

        for (int num : arr) {

            int count = 0;

            for (int key : arr) {

                if (num == key) {

                    if (++count > arr.length / 2) {
                        return num;
                    }
                }

            }
        }
        return -1;
    }
}

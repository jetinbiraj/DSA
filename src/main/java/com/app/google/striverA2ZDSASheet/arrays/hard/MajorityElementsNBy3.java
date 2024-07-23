package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.*;

public class MajorityElementsNBy3 {

    public static void main(String[] args) {

//        int[] arr = {11, 33, 33, 11, 33, 11, 1, 2};
//        int[] arr = {1, 1, 2, 2, 7, 7, 8, 8, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3};
        int[] arr = {1, 1};

        System.out.println(bruteForceMajorityElement(arr));
        System.out.println(betterMajorityElementByNBy3(arr));
        System.out.println(optimalMajorityElementByNBy3(arr));
    }

    private static List<Integer> optimalMajorityElementByNBy3(int[] arr) {

        int majorityCheck = arr.length / 3;

        List<Integer> majorityElements = new ArrayList<>();

        int element1 = -1;
        int element2 = -2;

        int count1 = 0;
        int count2 = 0;

        for (int num : arr) {

            if (num == element1) {
                count1++;
            } else if (num == element2) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                element1 = num;
            } else if (count2 == 0) {
                count2++;
                element2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : arr) {

            if (element1 == num) {
                count1++;
            }

            if (num == element2) {
                count2++;
            }
        }

        if (count1 > majorityCheck) {
            majorityElements.add(element1);
        }

        if (count2 > majorityCheck) {
            majorityElements.add(element2);
        }

        return majorityElements;
    }


    private static List<Integer> betterMajorityElementByNBy3(int[] arr) {

        int majorityCheck = arr.length / 3;

        List<Integer> majorityElements = new ArrayList<>();
        HashMap<Integer, Integer> elementCounts = new HashMap<>();

        for (int currentNum : arr) {

            elementCounts.put(currentNum, elementCounts.getOrDefault(currentNum, 0) + 1);
        }

        for (var entry : elementCounts.entrySet()) {
            if (entry.getValue() > majorityCheck) {
                majorityElements.add(entry.getKey());
            }
        }

        return majorityElements;
    }


    private static List<Integer> bruteForceMajorityElement(int[] arr) {

        int majorityCheck = arr.length / 3;

        List<Integer> majorityElements = new ArrayList<>();

        for (int currentNum : arr) {

            if (!majorityElements.isEmpty() && majorityElements.getLast() == currentNum) {
                continue;
            }

            int count = 0;

            for (int num : arr) {
                if (currentNum == num) {
                    count++;

                    if (count > majorityCheck) {
                        majorityElements.add(currentNum);
                        break;
                    }
                }
            }

            if (majorityElements.size() == 2) {
                break;
            }
        }

        return majorityElements;
    }

}

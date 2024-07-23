package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.*;

public class Sum4 {

    public static void main(String[] args) {

//        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};

        System.out.println(bruteForceFourSum(nums, 0));
        System.out.println(betterFourSum(nums, 0));
        System.out.println(optimalFourSum(nums, 0));

    }

    private static List<List<Integer>> optimalFourSum(int[] nums, int target) {

        List<List<Integer>> quadruplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int leftPointer = j + 1;
                int rightPointer = nums.length - 1;
                long twoSum = nums[i] + nums[j];

                while (leftPointer < rightPointer) {

                    if (twoSum + nums[leftPointer] + nums[rightPointer] == target) {

                        List<Integer> quadruplet = new ArrayList<>(
                                Arrays.asList(nums[i], nums[j], nums[leftPointer], nums[rightPointer]));

                        Collections.sort(quadruplet);

                        quadruplets.add(quadruplet);

                        while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                            leftPointer++;
                        }

                        while (rightPointer > leftPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                            rightPointer--;
                        }

                        leftPointer++;
                        rightPointer--;

                    } else if (twoSum + nums[leftPointer] + nums[rightPointer] < target) {

                        leftPointer++;

                    } else {
                        rightPointer--;
                    }
                }
            }
        }

        return quadruplets;
    }

    private static List<List<Integer>> betterFourSum(int[] nums, int target) {

        Set<List<Integer>> quadruplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                Set<Long> lookupSet = new HashSet<>();

                for (int k = j + 1; k < nums.length; k++) {

                    long threeSum = nums[i] + nums[j] + nums[k];

                    long fourthElement = target - threeSum;

                    if (lookupSet.contains(fourthElement)) {

                        List<Integer> quadruplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], (int) fourthElement));

                        Collections.sort(quadruplet);

                        quadruplets.add(quadruplet);
                    }

                    lookupSet.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(quadruplets);
    }

    private static List<List<Integer>> bruteForceFourSum(int[] nums, int target) {

        Set<List<Integer>> quadruplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    for (int l = k + 1; l < nums.length; l++) {

                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {

                            List<Integer> quadruplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                            Collections.sort(quadruplet);

                            quadruplets.add(quadruplet);

                        }
                    }
                }
            }
        }

        return new ArrayList<>(quadruplets);
    }
}

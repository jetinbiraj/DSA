package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.*;

public class Sum3 {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(bruteForceThreeSum(nums));
        System.out.println(betterThreeSum(nums));
        System.out.println(optimalThreeSum(nums));
    }

    private static List<List<Integer>> optimalThreeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;

            while (leftPointer < rightPointer) {

                int sum = nums[i] + nums[leftPointer] + nums[rightPointer];

                if (sum == 0) {

                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer]));

                    triplets.add(triplet);

                    while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                        leftPointer++;
                    }

                    while (rightPointer > leftPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                        rightPointer--;
                    }

                    leftPointer++;
                    rightPointer--;

                } else if (sum < 0) {
                    leftPointer++;
                } else {
                    rightPointer--;
                }
            }
        }

        return triplets;
    }

    private static List<List<Integer>> betterThreeSum(int[] nums) {

        Set<List<Integer>> triplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            Set<Integer> lookupSet = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {

                int thirdElement = -(nums[i] + nums[j]);

                if (lookupSet.contains(thirdElement)) {

                    List<Integer> triplet = new ArrayList<>(List.of(nums[i], nums[j], thirdElement));

                    Collections.sort(triplet);

                    triplets.add(triplet);
                }

                lookupSet.add(nums[j]);
            }
        }

        return new ArrayList<>(triplets);
    }

    private static List<List<Integer>> bruteForceThreeSum(int[] nums) {

        Set<List<Integer>> triplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {

                        List<Integer> triplet = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));

                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(triplets);
    }
}

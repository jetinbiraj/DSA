package com.app.google.striverA2ZDSASheet.stackandQueues.monotonic;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(bruteForceTrap(height));
        System.out.println(betterTrap(height));
        System.out.println(optimalTrap(height));
    }

    private static int optimalTrap(int[] height) {
        int n = height.length;

        int trappingWater = 0;

        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {

            if (height[left] <= height[right]) {

                if (height[left] < leftMax) {
                    trappingWater += leftMax - height[left++];
                } else {
                    leftMax = height[left++];
                }

            } else {

                if (height[right] < rightMax) {
                    trappingWater += rightMax - height[right--];
                } else {
                    rightMax = height[right--];
                }
            }
        }

        return trappingWater;
    }

    private static int betterTrap(int[] height) {
        int n = height.length;

        if (n <= 2) {
            return 0;
        }

//        int[] prefixMaxArr = getPrefixMaxArr(height);
        int[] suffixMaxArr = getSuffixMaxArr(height);
        int leftBigTower = height[0];

        int trappingWater = 0;

        for (int i = 1; i < n - 1; i++) {

//            int leftBigTower = prefixMaxArr[i];
            leftBigTower = Math.max(leftBigTower, height[i]);
            int rightBigTower = suffixMaxArr[i];

            if (leftBigTower > height[i] && rightBigTower > height[i]) {
                trappingWater += Math.min(leftBigTower, rightBigTower) - height[i];
            }
        }

        return trappingWater;
    }

    private static int[] getPrefixMaxArr(int[] height) {
        int n = height.length;
        int[] prefixMaxArr = new int[n];
        prefixMaxArr[0] = height[0];

        for (int i = 1; i < n; i++) {
            prefixMaxArr[i] = Math.max(height[i], prefixMaxArr[i - 1]);
        }

        return prefixMaxArr;
    }

    private static int[] getSuffixMaxArr(int[] height) {
        int n = height.length;
        int[] suffixMaxArr = new int[n];

        suffixMaxArr[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            suffixMaxArr[i] = Math.max(height[i], suffixMaxArr[i + 1]);
        }

        return suffixMaxArr;
    }

    private static int bruteForceTrap(int[] height) {

        int n = height.length;

        if (n <= 2) {
            return 0;
        }
        int trappingWater = 0;

        for (int i = 1; i < n - 1; i++) {

            int leftBigTower = height[i - 1];
            int rightBigTower = height[i + 1];

            int traverser = i - 1;

            while (traverser >= 0) {
                leftBigTower = Math.max(height[traverser--], leftBigTower);
            }
            if (leftBigTower < height[i]) {
                continue;
            }

            traverser = i + 1;
            while (traverser < n) {
                rightBigTower = Math.max(height[traverser++], rightBigTower);
            }
            if (rightBigTower < height[i]) {
                continue;
            }

            int heightDiff = Math.min(leftBigTower, rightBigTower);

            trappingWater += heightDiff - height[i];
        }

        return trappingWater;
    }
}

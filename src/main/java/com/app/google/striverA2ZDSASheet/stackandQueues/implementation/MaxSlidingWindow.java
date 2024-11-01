package com.app.google.striverA2ZDSASheet.stackandQueues.implementation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(bruteForceMaxSlidingWindow(nums, k)));
        System.out.println(Arrays.toString(optimalMaxSlidingWindow(nums, k)));
    }

    private static int[] optimalMaxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        if (n < k) {
            return new int[]{};
        }

        int[] maxSlidingWindow = new int[n - k + 1];
        int index = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            if (!deque.isEmpty() && deque.getLast() <= i - k) {
                deque.pollLast();
            }

            while (!deque.isEmpty() && nums[deque.peek()] <= nums[i]) {
                deque.pop();
            }

            deque.push(i);

            if (i >= k - 1) {
                maxSlidingWindow[index++] = nums[deque.getLast()];
            }
        }

        return maxSlidingWindow;
    }

    private static int[] bruteForceMaxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        if (n < k) {
            return new int[]{};
        }

        int[] maxSlidingWindow = new int[n - k + 1];

        for (int i = 0; i < n; i++) {

            int maxNum = nums[i];

            if (i + k > n) {
                break;
            }

            for (int j = i + 1; j < i + k; j++) {
                maxNum = Math.max(maxNum, nums[j]);
            }

            maxSlidingWindow[i] = maxNum;
        }

        return maxSlidingWindow;
    }
}

package com.app.google.striverA2ZDSASheet.stackandQueues.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SumSubArrayRanges {

    public static void main(String[] args) {
        int[] nums = {4, -2, -3, 4, 1};  // 1, 2, 3

        System.out.println(bruteForceSubArrayRanges(nums));
        System.out.println(optimalSubArrayRanges(nums));
    }

    private static long optimalSubArrayRanges(int[] nums) {
        int n = nums.length, j, k;
        long res = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > (i == n ? Integer.MIN_VALUE : nums[i])) {
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                res -= (long) nums[j] * (i - j) * (j - k);

            }
            stack.push(i);
        }

        stack.clear();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < (i == n ? Integer.MAX_VALUE : nums[i])) {
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                res += (long) nums[j] * (i - j) * (j - k);

            }
            stack.push(i);
        }

        return res;
    }

    private static long bruteForceSubArrayRanges(int[] nums) {

        long diffSum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int smallest = nums[i];
            int largest = nums[i];

            for (int j = i + 1; j < n; j++) {

                largest = Math.max(nums[j], largest);
                smallest = Math.min(nums[j], smallest);

                diffSum += largest - smallest;
            }
        }

        return diffSum;
    }
}

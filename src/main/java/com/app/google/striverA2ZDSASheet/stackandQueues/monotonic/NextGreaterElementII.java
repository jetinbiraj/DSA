package com.app.google.striverA2ZDSASheet.stackandQueues.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 3};

        System.out.println(Arrays.toString(bruteForceNextGreaterElements(nums)));
        System.out.println(Arrays.toString(betterNextGreaterElements(nums)));
        System.out.println(Arrays.toString(optimalNextGreaterElement(nums)));
    }

    private static int[] optimalNextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }

            if (i < n) {
                stack.push(i % n);
            }
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        return ans;
    }

    private static int[] betterNextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
            }

            stack.push(nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            int nextGreatestElement = -1;

            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                nextGreatestElement = stack.peek();
            }

            ans[i] = nextGreatestElement;
            stack.push(nums[i]);
        }

        return ans;
    }

    private static int[] bruteForceNextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int nextGreaterElement = -1;

            for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
                if (nums[i] < nums[j]) {
                    nextGreaterElement = nums[j];
                    break;
                }
            }

            ans[i] = nextGreaterElement;
        }

        return ans;
    }
}

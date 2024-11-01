package com.app.google.striverA2ZDSASheet.stackandQueues.monotonic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        System.out.println(Arrays.toString(bruteForceNextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(betterNextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(nextGreaterElementUsingStack(nums1, nums2)));
    }

    private static int[] nextGreaterElementUsingStack(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int nextGreatestElement = -1;
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                nextGreatestElement = stack.peek();
            }
            map.put(nums2[i], nextGreatestElement);
            stack.push(nums2[i]);
        }

        int index = 0;
        int[] ans = new int[nums1.length];
        for (int num : nums1) {
            ans[index++] = map.get(num);
        }
        return ans;
    }

    private static int[] betterNextGreaterElement(int[] nums1, int[] nums2) {

        int n2 = nums2.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums2[n2 - 1], -1);

        for (int i = n2 - 2; i >= 0; i--) {
            int nextGreatestElement = -1;

            if (nums2[i + 1] > nums2[i]) {
                nextGreatestElement = nums2[i + 1];
            } else if (map.get(nums2[i + 1]) > nums2[i]) {
                nextGreatestElement = map.get(nums2[i + 1]);
            } else {

                for (int j = i + 2; j < n2; j++) {
                    if (nums2[j] > nums2[i]) {
                        nextGreatestElement = nums2[j];
                        break;
                    }
                }
            }

            map.put(nums2[i], nextGreatestElement);
        }

        int index = 0;
        int[] ans = new int[nums1.length];
        for (int num : nums1) {
            ans[index++] = map.get(num);
        }
        return ans;
    }


    private static int[] bruteForceNextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int index = 0;

        for (int num1 : nums1) {

            boolean found = false;
            ans[index] = -1;

            for (int num2 : nums2) {

                if (found && num2 > num1) {
                    ans[index] = num2;
                    break;
                }

                if (num1 == num2) {
                    found = true;
                }
            }
            index++;
        }

        return ans;
    }
}

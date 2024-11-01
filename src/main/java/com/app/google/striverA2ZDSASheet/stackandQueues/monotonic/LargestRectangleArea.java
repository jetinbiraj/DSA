package com.app.google.striverA2ZDSASheet.stackandQueues.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleArea {

    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(bruteForceLargestRectangleArea(heights));
        System.out.println(betterLargestRectangleArea(heights));
        System.out.println(optimalLargestRectangleArea(heights));
    }

    private static int optimalLargestRectangleArea(int[] heights) {

        int largestRectangleArea = 0;
        int n = heights.length;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {

                int element = heights[stack.pop()];

                int psi = stack.isEmpty() ? -1 : stack.peek();

                largestRectangleArea = Math.max(largestRectangleArea, element * (i - psi - 1));
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int element = heights[stack.pop()];
            int psi = stack.isEmpty() ? -1 : stack.peek();

            largestRectangleArea = Math.max(largestRectangleArea, element * (n - psi - 1));
        }

        return largestRectangleArea;
    }

    private static int betterLargestRectangleArea(int[] heights) {

        int largestRectangleArea = 0;
        int n = heights.length;

        int[] psi = new int[n];
        int[] nsi = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            psi[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            nsi[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {

            largestRectangleArea = Math.max(largestRectangleArea, heights[i] * (nsi[i] - psi[i] - 1));
        }

        return largestRectangleArea;
    }

    private static int bruteForceLargestRectangleArea(int[] heights) {

        int largestRectangleArea = 0;
        int n = heights.length;


        for (int i = 0; i < n; i++) {

            largestRectangleArea = Math.max(largestRectangleArea, heights[i]);
            int minTowerHeight = heights[i];

            for (int j = i + 1; j < n; j++) {

                minTowerHeight = Math.min(minTowerHeight, heights[j]);

                largestRectangleArea = Math.max(largestRectangleArea, (minTowerHeight * (j - i + 1)));
            }
        }

        return largestRectangleArea;
    }
}

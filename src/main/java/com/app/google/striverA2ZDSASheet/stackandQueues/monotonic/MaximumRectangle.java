package com.app.google.striverA2ZDSASheet.stackandQueues.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MaximumRectangle {

    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(optimalMaximalRectangle(matrix));

    }

    private static int optimalMaximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] hist = new int[n][m];
        int maxRectangle = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (i == 0) {
                    hist[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    hist[i][j] = matrix[i][j] == '0' ? 0 : hist[i - 1][j] + 1;
                }
            }

            maxRectangle = Math.max(maxRectangle, optimalLargestRectangleArea(hist[i]));
        }

        return maxRectangle;
    }

    private static int optimalLargestRectangleArea(int[] heights) {

        int largestRectangleArea = 0;
        int n = heights.length;

        Deque<Integer> stack = new ArrayDeque<>();

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
}

package com.app.google.striverA2ZDSASheet.dp.squares;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumRectangle {

    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        MaximumRectangle obj = new MaximumRectangle();
        System.out.println(obj.maximalRectangle(matrix));
    }

    private int maximalRectangle(char[][] matrix) {

        int m = matrix[0].length, maxRectangle = 0;

        int[] heights = new int[m];

        for (char[] chars : matrix) {
            for (int j = 0; j < m; j++) {
                heights[j] = chars[j] == '0' ? 0 : heights[j] + 1;
            }

            maxRectangle = Math.max(maxRectangle, optimalLargestRectangleArea(heights));
        }

        return maxRectangle;
    }

    private int optimalLargestRectangleArea(int[] heights) {

        int n = heights.length, largestRectangleArea = 0;

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

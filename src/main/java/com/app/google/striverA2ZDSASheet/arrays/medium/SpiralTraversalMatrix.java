package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraversalMatrix {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}

                // 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
        };

//        System.out.println(Arrays.toString(spiralTraversal(arr)));
        System.out.println(getSpiralTraversalElements(arr));

    }

    private static List<Integer> getSpiralTraversalElements(int[][] matrix) {

        List<Integer> spiral = new ArrayList<>();

        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;

            if (bottom >= top) {

                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
        }

        return spiral;
    }

    private static int[] spiralTraversal(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] result = new int[n * m];
        int index = 0;

        int top = 0;
        int right = m - 1;
        int bottom = n - 1;
        int left = 0;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;

            if (bottom >= top) {

                for (int i = right; i >= left; i--) {
                    result[index++] = matrix[bottom][i];
                }
                bottom--;
            }

            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    result[index++] = matrix[i][left];
                }
                left++;
            }
        }

        return result;
    }
}

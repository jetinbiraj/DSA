package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.Arrays;

public class SpiralTraversalMatrix {

    public static void main(String[] args) {

        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        System.out.println(Arrays.toString(spiralTraversal(arr)));

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

            if (bottom >= top){

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

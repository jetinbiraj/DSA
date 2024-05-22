package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.Arrays;

public class RotateMatrix90 {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        bruteRotateClockwise(arr);
        optimalRotateClockwise(arr);

        System.out.println(Arrays.deepToString(arr));

    }

    private static void optimalRotateClockwise(int[][] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;

            }
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n/2; j++) {

                int temp = arr[i][j];
                arr[i][j] = arr[i][n - j - 1];
                arr[i][n - j - 1] = temp;
            }
        }
    }

        private static void bruteRotateClockwise ( int[][] arr){

            int m = arr.length;
            int n = arr[0].length;

            int[][] result = new int[m][n];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < n; j++) {

                    result[j][n - i - 1] = arr[i][j];

                }
            }

            for (int i = 0; i < m; i++) {
                System.arraycopy(result[i], 0, arr[i], 0, n);
            }

        }
    }

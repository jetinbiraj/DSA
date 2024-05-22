package com.app.google.striverA2ZDSASheet.arrays.medium;

import java.util.Arrays;

public class SetMatrixZero {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

//        bruteSetMatrixZero(arr);
//        betterSetMatrixZero(arr);
        optimalSetMatrixZero(arr);

//        Collection
//        System

        System.out.println(Arrays.deepToString(arr));
    }

    private static void optimalSetMatrixZero(int[][] arr) {

        int col0 = 1;

//        int[] row = new int[arr.length]; // arr[...][0]
//        int[] column = new int[arr[0].length]; // arr[0][...]

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j] == 0) {

                    arr[i][0] = 0;

                    if (j != 0) {
                        arr[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }

            }
        }

        for (int i = 1; i < arr.length; i++) {

            for (int j = 1; j < arr[0].length; j++) {

                if (arr[i][j] != 0) {

                    if (arr[i][0] == 0 || arr[0][j] == 0) {
                        arr[i][j] = 0;
                    }
                }

            }
        }

        if (arr[0][0] == 0) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = 0;
            }
        }

    }

    private static void betterSetMatrixZero(int[][] arr) {

        int[] row = new int[arr.length];
        int[] column = new int[arr[0].length];

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {

            for (int j = 0; j < column.length; j++) {

                if (row[i] == 1 || column[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }


    }


    private static void bruteSetMatrixZero(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == 0) {
                    markRow(arr, i);
                    markColumn(arr, j);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void markRow(int[][] arr, int row) {

        for (int i = 0; i < arr[row].length; i++) {
            if (arr[row][i] != 0) {
                arr[row][i] = -1;
            }
        }

    }

    private static void markColumn(int[][] arr, int column) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][column] != 0) {
                arr[i][column] = -1;
            }
        }
    }
}

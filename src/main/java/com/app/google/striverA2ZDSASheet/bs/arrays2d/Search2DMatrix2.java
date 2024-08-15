package com.app.google.striverA2ZDSASheet.bs.arrays2d;

public class Search2DMatrix2 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

//        int target = 5;
        int target = -1;

        System.out.println(bruteForceSearchMatrix(matrix, target));
        System.out.println(betterForceSearchMatrix(matrix, target));
        System.out.println(optimalForceSearchMatrix(matrix, target));
    }

    private static boolean optimalForceSearchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {

            int currentElement = matrix[row][col];

            if (currentElement == target) {
                return true;
            } else if (currentElement < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

    private static boolean betterForceSearchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {

            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {

                int low = 0;
                int high = n - 1;
                int mid;

                while (low <= high) {
                    mid = (low + high) / 2;

                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

            }
        }

        return false;
    }


    private static boolean bruteForceSearchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {

            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {

                for (int j = 0; j < n; j++) {

                    if (matrix[i][j] == target) {

                        return true;
                    }
                }
            }
        }

        return false;
    }
}

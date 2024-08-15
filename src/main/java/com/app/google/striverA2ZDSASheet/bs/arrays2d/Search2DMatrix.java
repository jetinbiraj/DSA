package com.app.google.striverA2ZDSASheet.bs.arrays2d;

public class Search2DMatrix {

    public static void main(String[] args) {

//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        };

        int[][] matrix = { // 1, 1
                {1, 1}
        };
        int target = 3;

        System.out.println(bruteForceSearchMatrix(matrix, target));
        System.out.println(betterSearchMatrix(matrix, target));
        System.out.println(optimalSearchMatrix(matrix, target));
        System.out.println(extremelyOptimalSearchMatrix(matrix, target));
    }

    private static boolean extremelyOptimalSearchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (m * matrix[0].length) - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            int midElement = matrix[mid / n][mid % n];
            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private static boolean optimalSearchMatrix(int[][] matrix, int target) {

        int n = matrix[0].length;

        for (int[] row : matrix) {

            if (target >= row[0] && target <= row[n - 1]) {

                int low = 0;
                int high = n - 1;
                int mid;

                while (low <= high) {
                    mid = (low + high) / 2;

                    if (row[mid] == target) {
                        return true;
                    } else if (row[mid] < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return false;
    }


    private static boolean betterSearchMatrix(int[][] matrix, int target) {

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

    private static boolean bruteForceSearchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}

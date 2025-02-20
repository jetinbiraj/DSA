package com.app.google.striverA2ZDSASheet.dp.squares;

public class CountSquareSubmatrices {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        CountSquareSubmatrices obj = new CountSquareSubmatrices();

        System.out.println(obj.countSquares(matrix));
        System.out.println(obj.countSquaresClean(matrix));
    }

    private int countSquaresClean(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length, squares = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    matrix[i][j] = 1 + Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
                }

                squares += matrix[i][j];
            }
        }

        return squares;
    }

    private int countSquares(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length, squares = 0;

        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
            squares += dp[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = matrix[i][0];
            squares += dp[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                if (matrix[i][j] == 1) {

                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));

                    squares += dp[i][j];
                }
            }
        }

        return squares;
    }
}

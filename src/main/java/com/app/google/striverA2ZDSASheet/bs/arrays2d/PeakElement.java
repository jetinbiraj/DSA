package com.app.google.striverA2ZDSASheet.bs.arrays2d;

import java.util.Arrays;

public class PeakElement {

    public static void main(String[] args) {

        int[][] mat = {
                {7, 6},
                {2, 5},
                {3, 4},
                {1, 2},
                {2, 1},
        };

        System.out.println(Arrays.toString(bruteForceFindPeakGrid(mat)));
        System.out.println(Arrays.toString(betterFindPeakGrid(mat)));
        System.out.println(Arrays.toString(optimalFindPeakGrid(mat)));

    }

    private static int[] optimalFindPeakGrid(int[][] mat) {

        int startCol = 0, endCol = mat[0].length - 1;
        while (startCol <= endCol) {
            int maxRow = 0;
            int midCol = startCol + (endCol - startCol) / 2;

            for (int row = 0; row < mat.length; row++) {
                maxRow = mat[row][midCol] >= mat[maxRow][midCol] ? row : maxRow;
            }

            boolean leftIsBig = midCol - 1 >= startCol && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            boolean rightIsBig = midCol + 1 <= endCol && mat[maxRow][midCol + 1] > mat[maxRow][midCol];

            if (!leftIsBig && !rightIsBig)
                return new int[]{maxRow, midCol};
            else if (rightIsBig)
                startCol = midCol + 1;
            else
                endCol = midCol - 1;
        }

        return null;
    }

    private static int[] betterFindPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int maxElement = Integer.MIN_VALUE;
        int[] peakElement = new int[2];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int element = mat[i][j];

                if (element > maxElement) {
                    maxElement = element;
                    peakElement[0] = i;
                    peakElement[1] = j;
                }
            }
        }

        return peakElement;
    }


    private static int[] bruteForceFindPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int element = mat[i][j];
                boolean greaterThanRight = false;
                boolean greaterThanLeft = false;
                boolean greaterThanTop = false;
                boolean greaterThanBottom = false;

                if (i - 1 >= 0) {
                    if (mat[i - 1][j] < element) {
                        greaterThanTop = true;
                    }
                } else {
                    greaterThanTop = true;
                }

                if (i + 1 < m) {
                    if (mat[i + 1][j] < element) {
                        greaterThanBottom = true;
                    }
                } else {
                    greaterThanBottom = true;
                }

                if (j - 1 >= 0) {
                    if (mat[i][j - 1] < element) {
                        greaterThanLeft = true;
                    }
                } else {
                    greaterThanLeft = true;
                }

                if (j + 1 < n) {
                    if (mat[i][j + 1] < element) {
                        greaterThanRight = true;
                    }
                } else {
                    greaterThanRight = true;
                }


                if (greaterThanLeft && greaterThanRight && greaterThanTop && greaterThanBottom) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}

package com.app.google.striverA2ZDSASheet.bs.arrays2d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class median {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };

        System.out.println(bruteForceMedian(matrix));
        System.out.println(optimalMedian(matrix));
    }

    private static int optimalMedian(int[][] matrix) {

        int low = 1, high = 2000;
        int r = matrix.length;
        int c = matrix[0].length;

        while (low <= high) {

            int mid = (high + low) >> 1;
            int ans = 0;

            for (int[] row : matrix) {

                int l = 0, h = c - 1;

                while (l <= h) {
                    int m = (h + l) >> 1;
                    if (row[m] <= mid) l = m + 1;
                    else h = m - 1;
                }

                ans += l;
            }

            if (ans <= (r * c) / 2) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }

    private static int bruteForceMedian(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                list.add(mat[i][j]);
            }
        }

        Collections.sort(list);

        return list.get(m * n / 2);
    }
}

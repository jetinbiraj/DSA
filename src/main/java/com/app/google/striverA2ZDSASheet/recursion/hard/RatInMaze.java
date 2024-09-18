package com.app.google.striverA2ZDSASheet.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        System.out.println(optimalFindPath(mat));
    }

    private static List<String> optimalFindPath(int[][] mat) {

        ArrayList<String> paths = new ArrayList<>();

        if (mat[0][0] == 0) {
            return paths;
        }

        findPaths(paths, mat, 0, 0, mat.length, "");

        return paths;
    }

    private static void findPaths(List<String> paths, int[][] mat, int row, int col, int n, String path) {

        if (row == n - 1 && col == n - 1 && mat[row][col] == 1) {
            paths.add(path);
            return;
        }

        if (row < 0 || col < 0 || row >= n || col >= n || mat[row][col] != 1) {
            return;
        }

        mat[row][col] = -1;


        findPaths(paths, mat, row + 1, col, n, path + "D");

        findPaths(paths, mat, row, col - 1, n, path + "L");

        findPaths(paths, mat, row, col + 1, n, path + "R");

        findPaths(paths, mat, row - 1, col, n, path + "U");

        mat[row][col] = 1;
    }
}

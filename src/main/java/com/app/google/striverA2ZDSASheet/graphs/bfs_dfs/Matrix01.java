package com.app.google.striverA2ZDSASheet.graphs.bfs_dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Matrix01 {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
        };

        Matrix01 obj = new Matrix01();

        System.out.println(Arrays.deepToString(obj.bruteForceUpdateMatrix(mat)));
//        System.out.println(Arrays.deepToString(obj.betterUpdateMatrix(mat)));
        System.out.println(Arrays.deepToString(obj.optimalUpdateMatrix(mat)));
    }

    private int[][] optimalUpdateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length, distance = 0;

        Deque<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 0) {
                    queue.add(new int[]{row, col});
                } else {
                    mat[row][col] = -1;
                }
            }
        }

        int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while (!queue.isEmpty()) {

            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {

                int[] entry = queue.pollFirst();

                for (int[] dir : delta) {

                    int x = entry[0] + dir[0];
                    int y = entry[1] + dir[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols || mat[x][y] >= 0) {
                        continue;
                    }

                    mat[x][y] = distance;
                    queue.add(new int[]{x, y});
                }
            }
        }

        return mat;
    }

    private int[][] betterUpdateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] upMat = new int[rows][cols];
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 0) {
                    queue.add(new int[]{row, col});
                    mat[row][col] = -1;
                }
            }
        }

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {

                int[] entry = queue.pollFirst();

                for (int[] dir : delta) {

                    int x = entry[0] + dir[0];
                    int y = entry[1] + dir[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols || mat[x][y] == -1) {
                        continue;
                    }

                    if (upMat[x][y] == 0) {
                        upMat[x][y] = distance;
                    }

                    queue.add(new int[]{x, y});
                    mat[x][y] = -1;
                }
            }
        }

        return upMat;
    }

    private int[][] bruteForceUpdateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] upMat = new int[rows][cols];
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (mat[row][col] == 0) {
                    continue;
                }

                queue.add(new int[]{row, col});
                int dist = 0;
                while (!queue.isEmpty()) {

                    dist++;
                    int size = queue.size();

                    for (int i = 0; i < size && !queue.isEmpty(); i++) {
                        int[] entry = queue.pollFirst();

                        for (int[] dir : delta) {

                            int x = entry[0] + dir[0];
                            int y = entry[1] + dir[1];

                            if (x < 0 || x >= rows || y < 0 || y >= cols) {
                                continue;
                            }

                            if (mat[x][y] == 0) {
                                upMat[row][col] = dist;
                                queue.clear();
                                break;
                            } else {
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }

        return upMat;
    }
}

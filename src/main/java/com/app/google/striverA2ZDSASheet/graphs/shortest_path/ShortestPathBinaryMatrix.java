package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import com.app.google.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {{0}};

        ShortestPathBinaryMatrix obj = new ShortestPathBinaryMatrix();
        System.out.println(obj.shortestPathBinaryMatrix(grid));
        System.out.println(obj.cleanedShortestPathBinaryMatrix(grid));
    }

    public int cleanedShortestPathBinaryMatrix(int[][] grid) { // Cleaned solution but not encouraged because of modifying the given input

        int rows = grid.length, cols = grid[0].length;

        if (grid[0][0] != 0 || grid[rows - 1][cols - 1] != 0) {
            return -1;
        }

        Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(0, 0));
        grid[0][0] = 1;

        int[][] delta = {{1, 1}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {1, -1}};

        while (!queue.isEmpty()) {
            var entry = queue.pollFirst();

            for (int[] dir : delta) {

                int x = entry.key() + dir[0];
                int y = entry.value() + dir[1];

                if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != 0) {
                    continue;
                }

                grid[x][y] = grid[entry.key()][entry.value()] + 1;

                queue.add(new Pair<>(x, y));
            }
        }

        return grid[rows - 1][cols - 1] != 0 ? grid[rows - 1][cols - 1] : -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int rows = grid.length, cols = grid[0].length;

        if (grid[0][0] != 0 || grid[rows - 1][cols - 1] != 0) {
            return -1;
        }

        Deque<Pair<Integer, int[]>> queue = new ArrayDeque<>();
        queue.add(new com.app.google.Pair<>(1, new int[]{0, 0}));
        grid[0][0] = -1;

        int[][] delta = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

        while (!queue.isEmpty()) {
            com.app.google.Pair<Integer, int[]> entry = queue.poll();

            for (int[] dir : delta) {

                int x = entry.value()[0] + dir[0];
                int y = entry.value()[1] + dir[1];

                if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 1 || grid[x][y] == -1) {
                    continue;
                }

                int newDist = entry.key() + 1;
                if (x == rows - 1 && y == cols - 1) {
                    return newDist;
                }

                grid[x][y] = -1;
                queue.add(new com.app.google.Pair<>(newDist, new int[]{x, y}));
            }
        }

        return -1;
    }
}

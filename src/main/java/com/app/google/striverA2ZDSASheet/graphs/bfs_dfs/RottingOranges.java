package com.app.google.striverA2ZDSASheet.graphs.bfs_dfs;

import com.app.google.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        RottingOranges obj = new RottingOranges();
        System.out.println(obj.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int minTime = -1;
        int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            minTime++;

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Pair<Integer, Integer> pair = queue.pollFirst();

                for (int[] dir : delta) {

                    int x = pair.getKey() + dir[0];
                    int y = pair.getValue() + dir[1];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }

                    grid[x][y] = 2;
                    queue.add(new Pair<>(x, y));
                    fresh--;
                }
            }
        }

        return fresh == 0 ? minTime : -1;
    }
}

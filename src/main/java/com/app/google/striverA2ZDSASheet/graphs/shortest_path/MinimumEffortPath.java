package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import com.app.google.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumEffortPath {

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        MinimumEffortPath obj = new MinimumEffortPath();

        System.out.println(obj.minimumEffortPath(heights));
    }

    public int minimumEffortPath(int[][] heights) {

        int minEffort = 0;

        PriorityQueue<Pair<Integer, int[]>> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.getKey()));
        pq.add(new Pair<>(0, new int[]{0, 0}));

        int[][] delta = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] visited = new int[rows][cols];
        visited[0][0] = -1;

        while (!pq.isEmpty()) {

            var entry = pq.poll();
            minEffort = Math.max(minEffort, entry.getKey());

            int currentX = entry.getValue()[0];
            int currentY = entry.getValue()[1];

            if (currentX == rows - 1 && currentY == cols - 1) {
                break;
            }

            visited[currentX][currentY] = -1;

            for (int[] dir : delta) {

                int x = currentX + dir[0];
                int y = currentY + dir[1];

                if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] == -1) {
                    continue;
                }

                pq.add(new Pair<>(Math.abs(heights[currentX][currentY] - heights[x][y]), new int[]{x, y}));
            }
        }

        return minEffort;
    }
}

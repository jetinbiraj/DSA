package com.app.google.striverA2ZDSASheet.graphs.bfs_dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FloodFill {

    public static void main(String[] args) {

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1},
        };

        int sr = 1, sc = 1, color = 2;

        FloodFill obj = new FloodFill();

        System.out.println(Arrays.deepToString(obj.bfsFloodFill(image, sr, sc, color)));
        System.out.println(Arrays.deepToString(obj.dfsFloodFill(image, sr, sc, color)));
    }

    public int[][] dfsFloodFill(int[][] image, int sr, int sc, int color) {

        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int startingPixelColor, int color){

        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != startingPixelColor || image[sr][sc] == color){
            return;
        }

        image[sr][sc] = color;
        dfs(image, sr+1, sc, startingPixelColor, color);
        dfs(image, sr-1, sc, startingPixelColor, color);
        dfs(image, sr, sc+1, startingPixelColor, color);
        dfs(image, sr, sc-1, startingPixelColor, color);
    }

    public int[][] bfsFloodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) {
            return image;
        }

        int row = image.length;
        int col = image[0].length;
        int startingPixelColor = image[sr][sc];

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;

        int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        while (!queue.isEmpty()) {

            int[] point = queue.pollFirst();

            for (int[] dir : delta) {

                int x = point[0] + dir[0];
                int y = point[1] + dir[1];

                if (x < 0 || x >= row || y < 0 || y >= col || image[x][y] != startingPixelColor || image[x][y] == color) {
                    continue;
                }

                queue.add(new int[]{x, y});
                image[x][y] = color;
            }
        }

        return image;
    }
}

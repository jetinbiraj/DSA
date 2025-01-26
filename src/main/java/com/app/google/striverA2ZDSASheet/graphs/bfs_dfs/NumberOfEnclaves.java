package com.app.google.striverA2ZDSASheet.graphs.bfs_dfs;

public class NumberOfEnclaves {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        NumberOfEnclaves obj = new NumberOfEnclaves();

        System.out.println(obj.numEnclaves(grid));
        System.out.println(obj.betterNumEnclaves(grid));
    }

    private int betterNumEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            mark(grid, row, 0);
            mark(grid, row, cols - 1);
        }

        for (int col = 1; col < cols - 1; col++) {
            mark(grid, 0, col);
            mark(grid, rows - 1, col);
        }

        int surroundedLands = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid[i][j] == 1) {
                    surroundedLands++;
                }
            }
        }

        return surroundedLands;
    }

    private int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            mark(grid, row, 0);
            mark(grid, row, cols - 1);
        }

        for (int col = 1; col < cols - 1; col++) {
            mark(grid, 0, col);
            mark(grid, rows - 1, col);
        }

        int surroundedLands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    surroundedLands++;
                } else if (grid[i][j] == -1) {
                    grid[i][j] = 1;
                }
            }
        }

        return surroundedLands;
    }

    private void mark(int[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || grid[row][col] == -1) {
            return;
        }

        grid[row][col] = -1;

        mark(grid, row - 1, col);
        mark(grid, row, col + 1);
        mark(grid, row + 1, col);
        mark(grid, row, col - 1);
    }
}

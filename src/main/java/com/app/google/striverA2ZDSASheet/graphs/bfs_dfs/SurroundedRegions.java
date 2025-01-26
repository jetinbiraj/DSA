package com.app.google.striverA2ZDSASheet.graphs.bfs_dfs;

import java.util.Arrays;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };

        SurroundedRegions obj = new SurroundedRegions();
        obj.solve(board);

        System.out.println(Arrays.deepToString(board));
    }

    private void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            mark(board, row, 0);
            mark(board, row, cols - 1);
        }

        for (int col = 1; col < cols - 1; col++) {
            mark(board, 0, col);
            mark(board, rows - 1, col);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void mark(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X'
                || board[row][col] == 'Z') {
            return;
        }

        board[row][col] = 'Z';
        mark(board, row - 1, col);
        mark(board, row, col + 1);
        mark(board, row + 1, col);
        mark(board, row, col - 1);
    }
}

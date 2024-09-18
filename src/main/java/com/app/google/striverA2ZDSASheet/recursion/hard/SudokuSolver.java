package com.app.google.striverA2ZDSASheet.recursion.hard;

import java.util.ArrayList;
import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };

        solveSudoku(board);

        System.out.println(Arrays.deepToString(board));

    }

    private static void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private static boolean solveSudoku(char[][] board, int row, int col) {

        if (col == 9) {
            return true;
        }

        if (row == 9) {
            return solveSudoku(board, 0, col + 1);
        }

        if (board[row][col] != '.') {
            return solveSudoku(board, row + 1, col);
        }

        for (char i = '1'; i <= '9'; i++) {

            if (isCharPossible(board, row, col, i)) {

                board[row][col] = i;
                if (solveSudoku(board, row + 1, col)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }
        return false;
    }

    private static boolean isCharPossible(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch || board[i][col] == ch) {
                return false;
            }
        }

        int boxStartRow = row > 5 ? 6 : row > 2 ? 3 : 0;
        int boxStartCol = col > 5 ? 6 : col > 2 ? 3 : 0;

        for (int i = boxStartRow; i <= boxStartRow + 2; i++) {

            for (int j = boxStartCol; j <= boxStartCol + 2; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }
}

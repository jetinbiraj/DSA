package com.app.google.striverA2ZDSASheet.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        int n = 1;

        System.out.println(solveNQueens(n));
        System.out.println(optimalSolveNQueens(n));
    }

    private static List<List<String>> optimalSolveNQueens(int n) {

        List<List<String>> queenLists = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            for (int col = 0; col < n; col++) {
                row[col] = '.';
            }
        }

        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        optimalSolveNQueens(queenLists, board, 0, n, leftRow, upperDiagonal, lowerDiagonal);

        return queenLists;
    }

    private static void optimalSolveNQueens(List<List<String>> queenLists, char[][] board, int col, int n, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {

        if (col == n) {
            queenLists.add(optimalGetQueenPlaceListFromBoard(board));
            return;
        }

        for (int row = 0; row < n; row++) {

            if (leftRow[row] != 1 && upperDiagonal[n - 1 + col - row] != 1 && lowerDiagonal[col + row] != 1) {
                board[row][col] = 'Q';

                leftRow[row] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                lowerDiagonal[col + row] = 1;

                optimalSolveNQueens(queenLists, board, col + 1, n, leftRow, upperDiagonal, lowerDiagonal);
                board[row][col] = '.';

                leftRow[row] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
                lowerDiagonal[col + row] = 0;
            }
        }
    }

    private static List<String> optimalGetQueenPlaceListFromBoard(char[][] board) {

        List<String> queenPlaceList = new ArrayList<>();

        for (char[] row : board) {
            queenPlaceList.add(new String(row));
        }
        return queenPlaceList;
    }


    private static List<List<String>> solveNQueens(int n) {

        List<List<String>> queenLists = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            for (int col = 0; col < n; col++) {
                row[col] = '.';
            }
        }

        solveNQueens(queenLists, board, 0, n);

        return queenLists;
    }

    private static void solveNQueens(List<List<String>> queenLists, char[][] board, int col, int n) {

        if (col == n) {
            queenLists.add(getQueenPlaceListFromBoard(board));
            return;
        }

        for (int row = 0; row < n; row++) {

            if (bruteForceCanQPlaced(row, col, board)) {
                board[row][col] = 'Q';
                solveNQueens(queenLists, board, col + 1, n);
                board[row][col] = '.';
            }
        }
    }

    private static boolean bruteForceCanQPlaced(int row, int col, char[][] board) {

        int tempRow = row - 1;
        int tempCol = col - 1;

        while (tempRow >= 0 && tempCol >= 0) {

            if (board[tempRow--][tempCol--] == 'Q') {
                return false;
            }
        }

        tempCol = col - 1;

        while (tempCol >= 0) {
            if (board[row][tempCol--] == 'Q') {
                return false;
            }
        }

        tempRow = row + 1;
        tempCol = col - 1;

        while (tempRow < board.length && tempCol >= 0) {

            if (board[tempRow++][tempCol--] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static List<String> getQueenPlaceListFromBoard(char[][] board) {

        List<String> queenPlaceList = new ArrayList<>();
        int colLength = board[0].length;

        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();

            for (int col = 0; col < colLength; col++) {
                sb.append(row[col]);
            }
            queenPlaceList.add(sb.toString());
        }

        return queenPlaceList;
    }
}

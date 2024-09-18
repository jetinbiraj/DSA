package com.app.google.striverA2ZDSASheet.recursion.hard;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public static void main(String[] args) {

//        String word = "ABCCED";
//        String word = "SEE";
//        String word = "ABCB";
        String word = "ABCESEEEFS";

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        board[0][0] ^= 256;
        System.out.println(Arrays.deepToString(board));

        board[0][0] ^= 256;
        System.out.println(Arrays.deepToString(board));

//        System.out.println(bruteForceExist(board, word));
//        System.out.println(betterExist(board, word));
//        System.out.println(optimalExist(board, word));
    }

    public boolean optimalExist(char[][] board, String word) {

        int rowLength = board.length;
        int colLength = board[0].length;

        for (int y = 0; y < rowLength; y++) {
            for (int x = 0; x < colLength; x++) {
                if (optimalExist(board, y, x, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean optimalExist(char[][] board, int y, int x, String word, int i) {
        if (i == word.length()) {
            return true;
        }
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
            return false;
        }
        if (board[y][x] != word.charAt(i)) {
            return false;
        }
        board[y][x] ^= 256;
        boolean exist = optimalExist(board, y, x + 1, word, i + 1)
                || optimalExist(board, y, x - 1, word, i + 1)
                || optimalExist(board, y + 1, x, word, i + 1)
                || optimalExist(board, y - 1, x, word, i + 1);
        board[y][x] ^= 256;
        return exist;
    }

    private static boolean betterExist(char[][] board, String word) {

        int rowLength = board.length;
        int colLength = board[0].length;
        char firstChar = word.charAt(0);

        for (int i = 0; i < rowLength; i++) {

            for (int j = 0; j < colLength; j++) {

                if (firstChar != board[i][j]) {
                    continue;
                }

                board[i][j] = '.';

                if (betterExist(board, word, 1, i, j)) {
                    board[i][j] = firstChar;
                    return true;
                }
                board[i][j] = firstChar;
            }
        }

        return false;
    }

    private static boolean betterExist(char[][] board, String word, int nextCharIndex, int currentRow, int currentCol) {

        if (nextCharIndex == word.length()) {
            return true;
        }

        char currentChar = word.charAt(nextCharIndex);

        if (currentRow > 0 && currentChar == board[currentRow - 1][currentCol]) {

            board[currentRow - 1][currentCol] = '.';

            if (betterExist(board, word, nextCharIndex + 1, currentRow - 1, currentCol)) {
                return true;
            }

            board[currentRow - 1][currentCol] = currentChar;
        }

        if (currentCol > 0 && currentChar == board[currentRow][currentCol - 1]) {

            board[currentRow][currentCol - 1] = '.';

            if (betterExist(board, word, nextCharIndex + 1, currentRow, currentCol - 1)) {
                return true;
            }
            board[currentRow][currentCol - 1] = currentChar;
        }

        if (currentRow < board.length - 1 && currentChar == board[currentRow + 1][currentCol]) {

            board[currentRow + 1][currentCol] = '.';

            if (betterExist(board, word, nextCharIndex + 1, currentRow + 1, currentCol)) {
                return true;
            }
            board[currentRow + 1][currentCol] = currentChar;
        }

        if (currentCol < board[0].length - 1 && currentChar == board[currentRow][currentCol + 1]) {

            board[currentRow][currentCol + 1] = '.';

            if (betterExist(board, word, nextCharIndex + 1, currentRow, currentCol + 1)) {
                return true;
            }
            board[currentRow][currentCol + 1] = currentChar;
        }

        return false;
    }

    private static boolean bruteForceExist(char[][] board, String word) {

        int rowLength = board.length;
        int colLength = board[0].length;
        char firstChar = word.charAt(0);

        HashSet<String> cellTracker = new HashSet<>();

        for (int i = 0; i < rowLength; i++) {

            for (int j = 0; j < colLength; j++) {

                if (firstChar != board[i][j]) {
                    continue;
                }

                cellTracker.add(i + Integer.toString(j));

                if (bruteForceExist(board, word, 1, cellTracker, i, j)) {
                    return true;
                }
                cellTracker.clear();
            }
        }

        return false;
    }

    private static boolean bruteForceExist(char[][] board, String word, int nextCharIndex, Set<String> cellTracker,
                                           int currentRow, int currentCol) {

        if (nextCharIndex == word.length()) {
            return true;
        }

        char currentChar = word.charAt(nextCharIndex);

        if (currentRow > 0 && !cellTracker.contains(Integer.toString(currentRow - 1) + currentCol)
                && currentChar == board[currentRow - 1][currentCol]) {

            String visitedCell = Integer.toString(currentRow - 1) + currentCol;

            cellTracker.add(visitedCell);

            if (bruteForceExist(board, word, nextCharIndex + 1, cellTracker, currentRow - 1, currentCol)) {
                return true;
            }

            cellTracker.remove(visitedCell);
        }

        if (currentCol > 0
                && !cellTracker.contains(currentRow + Integer.toString(currentCol - 1))
                && currentChar == board[currentRow][currentCol - 1]) {

            String visitedCell = currentRow + Integer.toString(currentCol - 1);

            cellTracker.add(visitedCell);
            if (bruteForceExist(board, word, nextCharIndex + 1, cellTracker, currentRow, currentCol - 1)) {
                return true;
            }
            cellTracker.remove(visitedCell);
        }

        if (currentRow < board.length - 1
                && !cellTracker.contains(Integer.toString(currentRow + 1) + currentCol)
                && currentChar == board[currentRow + 1][currentCol]) {

            String visitedCell = Integer.toString(currentRow + 1) + currentCol;

            cellTracker.add(visitedCell);
            if (bruteForceExist(board, word, nextCharIndex + 1, cellTracker, currentRow + 1, currentCol)) {
                return true;
            }
            cellTracker.remove(visitedCell);
        }

        if (currentCol < board[0].length - 1
                && !cellTracker.contains(currentRow + Integer.toString(currentCol + 1))
                && currentChar == board[currentRow][currentCol + 1]) {

            String visitedCell = currentRow + Integer.toString(currentCol + 1);

            cellTracker.add(visitedCell);
            if (bruteForceExist(board, word, nextCharIndex + 1, cellTracker, currentRow, currentCol + 1)) {
                return true;
            }
            cellTracker.remove(visitedCell);
        }

        return false;
    }
}

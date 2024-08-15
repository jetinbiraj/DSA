package com.app.google.striverA2ZDSASheet.bs.answers;

import java.util.ArrayList;

public class PainterPartition {

    public static void main(String[] args) {

        ArrayList<Integer> boards = new ArrayList<>();
        boards.add(2);
        boards.add(1);
        boards.add(5);
        boards.add(6);
        boards.add(2);
        boards.add(3);
        int k = 2;

        System.out.println(bruteForceLargestMinBoard(boards, k));
        System.out.println(optimalLargestMinBoard(boards, k));
    }

    private static int optimalLargestMinBoard(ArrayList<Integer> boards, int k) {

        int maxBoard = 0;
        int totalBoardSum = 0;
        int midBoard;

        for (int board : boards) {
            maxBoard = Math.max(maxBoard, board);
            totalBoardSum += board;
        }

        while (maxBoard <= totalBoardSum) {

            midBoard = (maxBoard + totalBoardSum) / 2;

            int painters = getBoardPainters(boards, k, midBoard);

            if (painters > k) {
                maxBoard = midBoard + 1;
            } else {
                totalBoardSum = midBoard - 1;
            }
        }

        return maxBoard;
    }

    private static int bruteForceLargestMinBoard(ArrayList<Integer> boards, int k) {

        int maxBoard = 0;
        int totalBoardSum = 0;

        for (int board : boards) {
            maxBoard = Math.max(maxBoard, board);
            totalBoardSum += board;
        }

        for (int currentBoard = maxBoard; currentBoard <= totalBoardSum; currentBoard++) {

            if (getBoardPainters(boards, k, currentBoard) <= k) {
                return currentBoard;
            }
        }

        return maxBoard;
    }


    private static int getBoardPainters(ArrayList<Integer> boards, int k, int time) {

        int boardSumTracker = 0;
        int painters = 1;

        for (int board : boards) {

            if (boardSumTracker + board <= time) {
                boardSumTracker += board;
            } else {
                boardSumTracker = board;
                painters++;
            }

            if (painters > k) {
                break;
            }
        }

        return painters;
    }
}

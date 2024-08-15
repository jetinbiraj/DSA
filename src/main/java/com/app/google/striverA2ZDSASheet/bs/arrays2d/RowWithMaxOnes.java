package com.app.google.striverA2ZDSASheet.bs.arrays2d;

public class RowWithMaxOnes {

    public static void main(String[] args) {

        int[][] arr = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};

//        int[][] arr = {{0}, {0}};

        System.out.println(bruteForceRowWithMax1s(arr));
        System.out.println(optimalWithMax1s(arr));
    }

    private static int optimalWithMax1s(int[][] arr) {

        int rowWithMaxOnes = -1;
        int maxOnes = 0;
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {

            int currentOneCounter = 0;
            int low = 0;
            int high = m - 1;
            int mid;

            while (low <= high) {
                mid = (low + high) / 2;

                if (arr[i][mid] < 1) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (low < m && arr[i][low] == 1) {
                currentOneCounter = m - low;
            }

            if (currentOneCounter > maxOnes) {
                maxOnes = currentOneCounter;
                rowWithMaxOnes = i;
            }
        }

        return rowWithMaxOnes;
    }

    private static int bruteForceRowWithMax1s(int[][] arr) { //1.23

        int rowWithMaxOnes = -1;
        int maxOnes = 0;
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {

            int currentOneCounter = 0;

            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    currentOneCounter = m - j;
                    break;
                }
            }

            if (currentOneCounter > maxOnes) {
                maxOnes = currentOneCounter;
                rowWithMaxOnes = i;
            }
        }

        return rowWithMaxOnes;
    }
}

package com.app.google.striverA2ZDSASheet.bs.answers;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {

//        int[] stalls = {0, 3, 4, 7, 10, 9};   //0, 3, 4, 7, 9, 10
        int[] stalls = {4, 2, 1, 3, 6};   //0, 3, 4, 7, 9, 10
//        int cows = 4;
        int cows = 2;

        System.out.println(bruteForceAggressiveCows(stalls, cows));
        System.out.println(optimalAggressiveCows(stalls, cows));
    }

    private static int optimalAggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);
        int n = stalls.length;

        int left = 1;
        int right = stalls[n - 1] - stalls[0];
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (isPlacementPossible(stalls, mid, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }


    private static int bruteForceAggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int n = stalls.length;
        int minMaxDistanceBetweenCows = 1;

        for (int i = 1; i <= stalls[n - 1]; i++) {

            if (isPlacementPossible(stalls, i, k)) {
                minMaxDistanceBetweenCows = i;
            } else {
                break;
            }
        }
        return minMaxDistanceBetweenCows;
    }

    private static boolean isPlacementPossible(int[] stalls, int currentDistance, int k) {
        int cows = 1;
        int lastPlaced = stalls[0];

        for (int stall : stalls) {

            if (currentDistance <= stall - lastPlaced) {
                cows++;
                lastPlaced = stall;
            }

            if (cows >= k) {
                return true;
            }
        }

        return false;
    }
}

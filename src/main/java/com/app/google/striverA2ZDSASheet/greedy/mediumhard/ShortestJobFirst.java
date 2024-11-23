package com.app.google.striverA2ZDSASheet.greedy.mediumhard;

import java.util.Arrays;

public class ShortestJobFirst {

    public static void main(String[] args) {

        int[] burstTime = {4, 3, 7, 1, 2};

        System.out.println(solve(burstTime));
    }

    private static int solve(int[] bt) {

        Arrays.sort(bt);
        int n = bt.length;

        int totalWaitTime = 0;
        int currentWaitTime = 0;

        for (int burstTime : bt) {

            totalWaitTime += currentWaitTime;

            currentWaitTime += burstTime;

        }

        return totalWaitTime / n;
    }
}

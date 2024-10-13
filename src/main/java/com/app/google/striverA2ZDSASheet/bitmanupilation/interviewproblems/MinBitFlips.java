package com.app.google.striverA2ZDSASheet.bitmanupilation.interviewproblems;

public class MinBitFlips {

    public static void main(String[] args) {

        int start = 10;
        int goal = 7;

        System.out.println(minBitFlips(start, goal));
    }

    private static int minBitFlips(int start, int goal) {

        int xor = start ^ goal;
        int minBitFlips = 0;

        for (int i = 0; i <= 31; i++) {

            if ((xor & (1 << i)) != 0) {
                minBitFlips++;
            }

        }

        return minBitFlips;
    }
}

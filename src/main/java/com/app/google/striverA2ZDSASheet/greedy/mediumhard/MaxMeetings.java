package com.app.google.striverA2ZDSASheet.greedy.mediumhard;

import java.util.Arrays;
import java.util.Comparator;

public class MaxMeetings {

    private static class Pair {

        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println(maxMeetings(start, end));
    }

    private static int maxMeetings(int[] start, int[] end) {

        int n = start.length;

        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(start[i], end[i]);
        }

        Arrays.sort(pairs, Comparator.comparingInt(a -> a.end));

        int meetCount = 1;
        int prevEnd = pairs[0].end;

        for (int i = 1; i < n; i++) {

            if (pairs[i].start > prevEnd) {
                prevEnd = pairs[i].end;
                meetCount++;
            }
        }

        return meetCount;
    }
}

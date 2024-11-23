package com.app.google.striverA2ZDSASheet.greedy.mediumhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingIntervals {

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3},
        };

        System.out.println(bruteForceEraseOverlapIntervals(intervals));
        System.out.println(betterEraseOverlapIntervals(intervals));
    }

    private static int betterEraseOverlapIntervals(int[][] intervals) {

        int overLappingIntervals = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int n = intervals.length;
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {

            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                overLappingIntervals++;
            }
        }

        return overLappingIntervals;
    }

    private static int bruteForceEraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        List<int[]> list = new ArrayList<>();

        int n = intervals.length;

        for (int[] interval : intervals) {

            if (list.isEmpty() || list.getLast()[1] <= interval[0]) {
                list.add(interval);
            }
        }

        return n - list.size();
    }
}

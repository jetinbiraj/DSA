package com.app.google.striverA2ZDSASheet.greedy.mediumhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18},
        };

        System.out.println(Arrays.deepToString(betterMerge(intervals)));
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    private static int[][] betterMerge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedOverlappingIntervals = new ArrayList<>();

        for (int[] interval : intervals) {

            if (!mergedOverlappingIntervals.isEmpty() && mergedOverlappingIntervals.getLast()[1] >= interval[0]) {
                mergedOverlappingIntervals.getLast()[1] = Math.max(mergedOverlappingIntervals.getLast()[1], interval[1]);
            } else {
                mergedOverlappingIntervals.add(interval);
            }
        }

        int[][] mergedIntervals = new int[mergedOverlappingIntervals.size()][];
        int index = 0;
        for (int[] interval : mergedOverlappingIntervals) {
            mergedIntervals[index++] = interval;
        }

        return mergedIntervals;
    }

    private static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();

        for (int[] interval : intervals) {

            if (!mergedIntervals.isEmpty() && mergedIntervals.getLast()[1] >= interval[0]) {
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
            } else {
                mergedIntervals.add(interval);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}


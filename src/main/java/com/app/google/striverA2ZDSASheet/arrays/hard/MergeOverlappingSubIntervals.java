package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.*;

public class MergeOverlappingSubIntervals {

    public static void main(String[] args) {

        int[][] intervals1 = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] intervals2 = {
                {1, 4},
                {4, 5},
        };

        System.out.println(Arrays.deepToString(bruteForceMerge(intervals1)));
        System.out.println(Arrays.deepToString(optimalMerge(intervals1)));
    }

    private static int[][] optimalMerge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedOverlappingIntervals = new ArrayList<>();

        mergedOverlappingIntervals.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            if (mergedOverlappingIntervals.getLast()[1] >= intervals[i][0]) {
                mergedOverlappingIntervals.getLast()[1] = Math.max(mergedOverlappingIntervals.getLast()[1], intervals[i][1]);
            } else {
                mergedOverlappingIntervals.add(intervals[i]);
            }
        }

        return mergedOverlappingIntervals.toArray(int[][]::new);
    }

    private static int[][] bruteForceMerge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedOverlappingIntervals = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            int startElement = intervals[i][0];
            int endElement = intervals[i][1];

            if (!mergedOverlappingIntervals.isEmpty() && mergedOverlappingIntervals.getLast()[1] >= endElement) {
                continue;
            }

            for (int j = i + 1; j < intervals.length; j++) {

                if (endElement >= intervals[j][0]) {
                    endElement = Math.max(endElement, intervals[j][1]);
                } else {
                    break;
                }
            }

            mergedOverlappingIntervals.add(new int[]{startElement, endElement});
        }

        return mergedOverlappingIntervals.toArray(int[][]::new);
    }
}

package com.app.google.striverA2ZDSASheet.greedy.mediumhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        List<int[]> result = new ArrayList<>();

        int index = 0;

        while (index < n && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index++]);
        }

        while (index < n && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        result.add(newInterval);

        while (index < n) {
            result.add(intervals[index++]);
        }

        return result.toArray(int[][]::new);
    }
}

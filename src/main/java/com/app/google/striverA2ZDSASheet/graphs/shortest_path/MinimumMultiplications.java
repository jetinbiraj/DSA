package com.app.google.striverA2ZDSASheet.graphs.shortest_path;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MinimumMultiplications {

    public static void main(String[] args) {
        int start = 3, end = 30;
        int[] arr = {2, 5, 7};

        MinimumMultiplications obj = new MinimumMultiplications();
        System.out.println(obj.minimumMultiplications(arr, start, end));
    }

    private int minimumMultiplications(int[] arr, int start, int end) {

        if (start == end) {
            return 0;
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        int[] store = new int[100000];
        Arrays.fill(store, Integer.MAX_VALUE);

        store[start] = 0;

        while (!queue.isEmpty()) {

            int[] entry = queue.pollFirst();

            for (int num : arr) {

                int newNum = (num * entry[0]) % 100000;
                int steps = entry[1] + 1;

                if (steps < store[newNum]) {

                    if (newNum == end) {
                        return steps;
                    }
                    store[newNum] = steps;
                    queue.add(new int[]{newNum, steps});
                }
            }
        }

        return -1;
    }
}

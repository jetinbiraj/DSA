package com.app.google.striverA2ZDSASheet.heaps.medium;

import java.util.*;

public class MergeKSortedArrays {

    public static void main(String[] args) {

        int[][] arr = {
                {57, 81}, {63, 71}
        };

        int k = 2;

        System.out.println(mergeKArrays(arr, k));
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {

            for (int j = 0; j < k; j++) {
                pq.offer(arr[i][j]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        return list;
    }
}

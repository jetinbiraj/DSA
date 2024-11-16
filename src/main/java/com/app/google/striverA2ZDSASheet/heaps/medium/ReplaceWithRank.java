package com.app.google.striverA2ZDSASheet.heaps.medium;

import java.util.*;

public class ReplaceWithRank {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 6};
        int n = 4;

        System.out.println(Arrays.toString(bruteForceReplaceWithRank(nums, n)));
        System.out.println(Arrays.toString(betterReplaceWithRank(nums, n)));
    }

    static int[] betterReplaceWithRank(int arr[], int n) {

        int[] nums = new int[n];

        System.arraycopy(arr, 0, nums, 0, n);
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        int index = 1;

        for (int num : nums) {
            if (map.putIfAbsent(num, index) == null) {
                index++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }

    private static int[] bruteForceReplaceWithRank(int arr[], int n) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.offer(num);
        }

        Map<Integer, Integer> map = new HashMap<>();

        int rank = 1;
        while (!pq.isEmpty()) {
            if (!map.containsKey(pq.peek())) {
                map.put(pq.poll(), rank++);
            } else {
                pq.poll();
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}

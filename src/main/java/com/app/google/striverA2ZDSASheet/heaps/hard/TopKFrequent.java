package com.app.google.striverA2ZDSASheet.heaps.hard;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequentHeap(nums, k)));
        System.out.println(Arrays.toString(topKFrequentBucketSort(nums, k)));
    }

    private static int[] topKFrequentBucketSort(int[] nums, int k) {

        int[] topK = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1]; //TODO: This can also be be solved using TreeMap

        for (var entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }

            bucket[entry.getValue()].add(entry.getKey());
        }


        List<Integer> topKFrequentElements = new ArrayList<>();

        for (int i = bucket.length - 1; i >= 0 && topKFrequentElements.size() < k; i--) {

            if (bucket[i] != null) {
                topKFrequentElements.addAll(bucket[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            topK[i] = topKFrequentElements.get(i);
        }


        return topK;
    }

    private static int[] topKFrequentHeap(int[] nums, int k) {

        int[] topK = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (var entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        for (int i = 0; i < k; i++) {
            topK[i] = maxHeap.poll().getKey();
        }

        return topK;
    }
}

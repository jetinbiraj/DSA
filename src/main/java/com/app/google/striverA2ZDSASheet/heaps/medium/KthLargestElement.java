package com.app.google.striverA2ZDSASheet.heaps.medium;

import java.util.*;

public class KthLargestElement {

    public static void main(String[] args) {

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        System.out.println(bruteForceFindKthLargest(nums, k));
        System.out.println(FindKthLargest(nums, k));
    }

    //TODO: Learn more about quick select algorithm

    private static int FindKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (pq.peek() != null && nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek() == null ? -1 : pq.peek();
    }

    private static int bruteForceFindKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

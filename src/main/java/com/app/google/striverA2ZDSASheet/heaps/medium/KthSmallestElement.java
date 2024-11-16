package com.app.google.striverA2ZDSASheet.heaps.medium;

import java.util.*;

public class KthSmallestElement {

    public static void main(String[] args) {

        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.println(bruteForceFindKthLargest(nums, k));
        System.out.println(FindKthSmallest(nums, k));
    }

    private static int FindKthSmallest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {

            if (pq.peek() != null && nums[i] < pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek() == null ? -1 : pq.peek();
    }

    private static int bruteForceFindKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k - 1];
    }
}

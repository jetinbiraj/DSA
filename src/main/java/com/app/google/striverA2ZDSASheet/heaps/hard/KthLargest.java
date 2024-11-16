package com.app.google.striverA2ZDSASheet.heaps.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {

        int n = nums.length;
        int index = 0;
        pq = new PriorityQueue<>(Collections.reverseOrder());

        while (k-- > 0 && index < n) {
            pq.offer(nums[index++]);
        }

        while (index < n) {
            if (pq.peek() > nums[index]) {
                pq.poll();
                pq.offer(nums[index]);
            }
            index++;
        }
    }

    public int add(int val) {

        if (pq.peek() > val) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}

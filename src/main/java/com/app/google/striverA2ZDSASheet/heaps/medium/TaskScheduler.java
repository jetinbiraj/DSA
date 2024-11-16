package com.app.google.striverA2ZDSASheet.heaps.medium;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {

        char[] tasks = {'B', 'C', 'D', 'A', 'A', 'A', 'A', 'G'};
        int n = 1;

        System.out.println(bruteForceLeastInterval(tasks, n));
        System.out.println(optimalLeastInterval(tasks, n));
    }

    private static int optimalLeastInterval(char[] tasks, int n) {

        int[] hash = new int[26];
        for (char ch : tasks) {
            hash[ch - 'A']++;
        }

        Arrays.sort(hash);

        int max = hash[25] - 1;
        int idle = max * n;

        for (int i = 24; i >= 0; --i) {
            idle -= Math.min(max, hash[i]);
        }

        return tasks.length + Math.max(0, idle);
    }

    private static int bruteForceLeastInterval(char[] tasks, int n) {

        int[] hash = new int[26];

        for (char ch : tasks) {
            hash[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int interval = 0;

        for (int frequency : hash) {
            if (frequency > 0) {
                pq.offer(frequency);
            }
        }

        while (!pq.isEmpty()) {

            List<Integer> list = new ArrayList<>();

            for (int i = 1; i <= n + 1; i++) {
                if (!pq.isEmpty()) {
                    list.add(pq.poll() - 1);
                }
            }

            for (int freq : list) {
                if (freq > 0) {
                    pq.offer(freq);
                }
            }

            if (pq.isEmpty()) {
                interval += list.size();
            } else {
                interval += n + 1;
            }
        }

        return interval;
    }
}

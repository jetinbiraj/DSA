package com.app.google.striverA2ZDSASheet.heaps.medium;

import java.util.*;

public class HandOfStraights {

    public static void main(String[] args) {

        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;

        System.out.println(bruteForceIsNStraightHand(hand, groupSize));
        System.out.println(betterIsNStraightHand(hand, groupSize));
        System.out.println(optimalIsNStraightHand(hand, groupSize));
    }

    private static boolean optimalIsNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);

        for (int i = 0; i < n; i++) {

            if (hand[i] == -1) {
                continue;
            }

            int currentNum = hand[i];
            hand[i] = -1;
            int nextNum = currentNum + 1;
            int groupSizeCount = 1;

            if (groupSizeCount == groupSize) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {

                if (hand[j] == -1) {
                    continue;
                }

                if (hand[j] == nextNum) {
                    nextNum++;
                    hand[j] = -1;

                    if (++groupSizeCount == groupSize) {
                        break;
                    }
                }
            }

            if (groupSizeCount != groupSize) {
                return false;
            }
        }

        return true;
    }

    private static boolean betterIsNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : hand) {
            pq.offer(num);
        }

        while (!pq.isEmpty()) {

            List<Integer> list = new ArrayList<>();

            int currentNum = pq.poll();
            int nextNum = currentNum + 1;
            int groupSizeCount = 1;

            if (groupSizeCount == groupSize) {
                continue;
            }

            while (!pq.isEmpty()) {

                int poll = pq.poll();

                if (poll == currentNum) {
                    list.add(poll);
                } else if (poll == nextNum) {

                    if (++groupSizeCount == groupSize) {
                        break;
                    }

                    currentNum = poll;
                    nextNum = poll + 1;

                } else {
                    return false;
                }
            }

            if (groupSizeCount != groupSize) {
                return false;
            }

            for (int num : list) {
                pq.offer(num);
            }
        }

        return true;
    }

    private static boolean bruteForceIsNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {

            var entry = map.pollFirstEntry();

            if (entry.getValue() != 1) {
                map.put(entry.getKey(), entry.getValue() - 1);
            }

            int groupSizeCount = 1;

            if (groupSizeCount == groupSize) {
                continue;
            }
            int nextNum = entry.getKey() + 1;

            while (groupSizeCount != groupSize) {

                Integer val = map.remove(nextNum);

                if (val == null) {
                    return false;
                }

                if (val != 1) {
                    map.put(nextNum, val - 1);
                }

                nextNum++;
                groupSizeCount++;
            }
        }

        return true;
    }
}

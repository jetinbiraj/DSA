package com.app.google.striverA2ZDSASheet.heaps.hard;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class RodCutting {

    private static class Pair {
        private final float key;
        private final int value;

        public Pair(float key, int value) {
            this.key = key;
            this.value = value;
        }

        public float getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {

        int[] prices = {3, 9, 13, 12, 8, 12, 8, 8, 3, 10, 13};
        int n = 11;

        System.out.println(cutRodUsingPriorityQueue(prices, n));
        System.out.println(cutRod(prices, n));
    }

    private static int cutRod(int[] price, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; // Base case: no value for length 0

        for (int i = 1; i <= n; i++) {
            int maxValue = Integer.MIN_VALUE;
            // Try all cuts of length `j`
            for (int j = 1; j <= i; j++) {
                maxValue = Math.max(maxValue, price[j - 1] + dp[i - j]);
            }
            dp[i] = maxValue;
        }

        return dp[n];
    }

    private static int cutRodUsingPriorityQueue(int[] prices, int n) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Float.compare(b.getKey(), a.getKey()));

        int index = 1;
        for (int price : prices) {
            pq.offer(new Pair((float) price / index, index++));
        }

        int maxPrice = 0;

        while (n > 0) {

            Iterator<Pair> iterator = pq.stream().iterator();

            while (iterator.hasNext()) {
                Pair pair = iterator.next();

                if (n >= pair.getValue()) {
                    maxPrice += (int) (pair.getKey() * pair.getValue());
                    n -= pair.getValue();
                    break;
                }
            }
        }

        return maxPrice;
    }
}

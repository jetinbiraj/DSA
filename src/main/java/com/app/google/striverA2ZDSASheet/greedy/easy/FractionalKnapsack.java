package com.app.google.striverA2ZDSASheet.greedy.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FractionalKnapsack {

    private static class Pair {

        int index;
        double value;

        public Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        List<Integer> val = Arrays.asList(8, 2, 10, 1, 9, 7, 2, 6, 4, 9);
        List<Integer> wt = Arrays.asList(10, 1, 7, 7, 5, 1, 8, 6, 8, 7);

        int capacity = 21;

        Pair[] arr = {new Pair(0, 2.5), new Pair(1, 5)};

        Arrays.sort(arr, (a, b) -> Double.compare(b.value, a.value));

        System.out.println(Arrays.toString(arr));
        System.out.println(fractionalKnapsackUsingHeap(val, wt, capacity));
//        System.out.println(fractionalKnapsackUsingArr(val, wt, capacity));
    }

    private static double fractionalKnapsackUsingArr(List<Integer> val, List<Integer> wt, int capacity) {

        double collection = 0;
        int n = val.size();

        Pair[] pairArr = new Pair[n];

        for (int i = 0; i < n; i++) {
            double valPerUnitWt = (double) val.get(i) / wt.get(i);
            pairArr[i] = new Pair(i, valPerUnitWt);
        }

        Arrays.sort(pairArr, (a, b) -> Double.compare(b.value, a.value));

        for (int i = 0; i < n; i++) {

            Pair pair = pairArr[i];

            int weight = wt.get(pair.index);
            int value = val.get(pair.index);

            if (weight < capacity) {

                collection += value;
                capacity -= weight;
            } else {
                collection += (double)value/weight * capacity;
                break;
            }
        }

        return collection;
    }

    private static double fractionalKnapsackUsingHeap(List<Integer> val, List<Integer> wt, int capacity) {

        double collection = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.value, a.value));
        int n = val.size();

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(i, (double) val.get(i) / wt.get(i)));
        }

        while (capacity > 0 && !pq.isEmpty()) {

            Pair pair = pq.poll();

            int weight = wt.get(pair.index);
            int value = val.get(pair.index);

            if (weight < capacity) {

                capacity -= weight;
                collection += value;

            } else {

                collection += (double) value / weight * capacity;
                capacity = 0;

            }
        }

        return collection;
    }
}

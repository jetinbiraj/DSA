package com.app.google.striverA2ZDSASheet.heaps.hard;

import java.util.*;

public class MaxSumCombinations {

    static class Pair {
        int aElementIndex;
        int bElementIndex;
        int sum;

        public Pair(int aElementIndex, int bElementIndex, int sum) {
            this.aElementIndex = aElementIndex;
            this.bElementIndex = bElementIndex;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> listA = new ArrayList<>(List.of(1, 4, 2, 3));
        ArrayList<Integer> listB = new ArrayList<>(List.of(2, 5, 1, 6));
        int c = 4;

        System.out.println(bruteForceMaxSumCombinations(listA, listB, c));
        System.out.println(optimalMaxSumCombinations(listA, listB, c));
    }

    private static ArrayList<Integer> optimalMaxSumCombinations(ArrayList<Integer> A, ArrayList<Integer> B, int C) {

        ArrayList<Integer> op = new ArrayList<>();
        int size = A.size();

        HashSet<Integer> set = new HashSet<>();
        A.sort(Collections.reverseOrder());
        B.sort(Collections.reverseOrder());

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.sum - a.sum);
        pq.offer(new Pair(0, 0, A.getFirst() + B.getFirst()));

        set.add(0);

        while (C-- != 0) {
            Pair pair = pq.poll();
            op.add(pair.sum);

            int a = pair.aElementIndex;
            int b = pair.bElementIndex;

            if (b + 1 < size && !set.contains(a * size + (b + 1))) {
                set.add(a * size + (b + 1));
                pq.offer(new Pair(a, b + 1, A.get(a) + B.get(b + 1)));
            }

            if (a + 1 < size && !set.contains((a + 1) * size + b)) {
                set.add((a + 1) * size + b);
                pq.offer(new Pair(a + 1, b, A.get(a + 1) + B.get(b)));
            }
        }

        return op;
    }

    private static ArrayList<Integer> bruteForceMaxSumCombinations(ArrayList<Integer> A, ArrayList<Integer> B, int C) {

        ArrayList<Integer> op = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int a : A) {

            for (int b : B) {

                int num = a + b;

                if (pq.size() < C) {
                    pq.offer(num);
                } else if (pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        while (!pq.isEmpty()) {
            op.addFirst(pq.poll());
        }

        return op;
    }
}

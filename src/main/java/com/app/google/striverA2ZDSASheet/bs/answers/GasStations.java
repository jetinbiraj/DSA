package com.app.google.striverA2ZDSASheet.bs.answers;

import java.util.PriorityQueue;

public class GasStations {

    private static class Pair {
        double sectionLength;
        int sectionIndex;

        public Pair(double sectionLength, int sectionIndex) {
            this.sectionLength = sectionLength;
            this.sectionIndex = sectionIndex;
        }
    }

    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {1, 13, 17, 23};
        int k = 5;
//        int k = 4;
        System.out.println(bruteForceMinimiseMaxDistance(arr, k));
        System.out.println(betterMinimiseMaxDistance(arr, k));
        System.out.println(optimalMinimiseMaxDistance(arr, k));
    }

    private static double optimalMinimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;
        double mid;

        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double diff = 1e-6;

        while (high - low > diff) {
            mid = (low + high) / 2;
            int numberOfGasStationsRequired = numberOfGasStationsRequired(mid, arr);

            if (numberOfGasStationsRequired > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }

    private static int numberOfGasStationsRequired(double mid, int[] arr) {

        int n = arr.length;
        int numberOfGasStationsRequired = 0;

        for (int i = 0; i < n - 1; i++) {
            int numberInBetween = (int) ((arr[i + 1] - arr[i]) / mid);

            if ((arr[i + 1] - arr[i]) == (mid * numberInBetween)) {
                numberInBetween--;
            }

            numberOfGasStationsRequired += numberInBetween;
        }

        return numberOfGasStationsRequired;
    }

    private static double betterMinimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.sectionLength, a.sectionLength));

        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        for (int i = 1; i <= k; i++) {

            Pair topPair = pq.poll();
            int sectionIndex = topPair.sectionIndex;

            howMany[sectionIndex]++;

            double newSectionDifference = arr[sectionIndex + 1] - arr[sectionIndex];
            double newSectionLength = newSectionDifference / (howMany[sectionIndex] + 1);

            pq.add(new Pair(newSectionLength, sectionIndex));
        }

        return pq.peek().sectionLength;
    }

    private static double bruteForceMinimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];

        for (int i = 1; i <= k; i++) {

            double maxSection = -1;
            int maxSectionIndex = -1;

            for (int j = 0; j < n - 1; j++) {

                double diff = arr[j + 1] - arr[j];
                double sectionLength = diff / (howMany[j] + 1);

                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxSectionIndex = j;
                }
            }
            howMany[maxSectionIndex]++;
        }

        double minimisedMaxDistance = -1;

        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double maxSectionLength = diff / (howMany[i] + 1);

            minimisedMaxDistance = Math.max(maxSectionLength, minimisedMaxDistance);
        }

        return minimisedMaxDistance;
    }
}

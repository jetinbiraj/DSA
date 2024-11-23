package com.app.google.striverA2ZDSASheet.greedy.mediumhard;

import java.util.*;

public class MinimumPlatforms {

    private static class Pair {
        int arrive;
        int depart;

        public Pair(int arrive, int depart) {
            this.arrive = arrive;
            this.depart = depart;
        }
    }

    public static void main(String[] args) {

        int[] arr = {646, 1812, 1953, 1859, 46, 1935, 1624, 617, 1645, 628};
        int[] dep = {805, 2200, 2106, 2333, 1554, 2047, 2020, 1900, 2048, 2351};

        System.out.println(bruteForceFindPlatform(arr, dep));
        System.out.println(betterFindPlatform(arr, dep));
        System.out.println(optimalFindPlatform(arr, dep));
    }

    private static int optimalFindPlatform(int[] arr, int[] dep) {
        int[] line = new int[2400];
        int[] free = new int[2400];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            line[arr[i]]++;
            free[dep[i]]++;
        }
        int platforms = 0;
        int maxPlatforms = 0;
        for (int i = 0; i < 2400; i++) {
            platforms += line[i];
            maxPlatforms = Math.max(maxPlatforms, platforms);
            platforms -= free[i];
        }
        return maxPlatforms;
    }


    private static int betterFindPlatform(int[] arr, int[] dep) {

        int n = arr.length;
        int minPlatforms = 0;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;
        int platforms = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }

            minPlatforms = Math.max(minPlatforms, platforms);
        }

        return minPlatforms;
    }

    static int bruteForceFindPlatform(int[] arr, int[] dep) {

        int n = arr.length;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], dep[i]);
        }

        Arrays.sort(pairs, Comparator.comparingInt(a -> a.arrive));
        LinkedList<Pair> list = new LinkedList<>();
        int minPlatforms = 0;

        for (int i = 0; i < n; i++) {

            Pair currentPair = pairs[i];

            if (!list.isEmpty()) {
                list.removeIf(pair -> pair.depart < currentPair.arrive);
            }

            list.add(currentPair);

            minPlatforms = Math.max(minPlatforms, list.size());
        }

        return minPlatforms;
    }
}

package com.app.google.striverA2ZDSASheet.bitmanupilation.advancedmath;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorisation {

    private static int[] primeNumTrackerArr;
    private static boolean[] nonPrimeNums;

    public static void main(String[] args) {
        int n = 12246;

//        betterSieve();
        sieve();

        System.out.println(bruteForceFindPrimeFactors(n));
        System.out.println(betterFindPrimeFactors(n));
        System.out.println(optimalFindPrimeFactors(n));
    }

    private static void sieve() {

        primeNumTrackerArr = new int[200001]; // 200001 is max N values in constraint

        for (int i = 2; i < 200001; i++) {
            primeNumTrackerArr[i] = i;
        }

        int maxI = (int) Math.sqrt(200001);

        for (int i = 2; i <= maxI; i++) {

            if (primeNumTrackerArr[i] == i) {

                for (int j = i * i; j < 200001; j += i) {

                    if (primeNumTrackerArr[j] == j) {
                        primeNumTrackerArr[j] = i;
                    }
                }
            }
        }
    }

    private static List<Integer> optimalFindPrimeFactors(int N) {

        List<Integer> primeFactors = new ArrayList<>();

        while (N != 1) {
            primeFactors.add(primeNumTrackerArr[N]);
            N /= primeNumTrackerArr[N];
        }

        return primeFactors;
    }

    static void betterSieve() {

        nonPrimeNums = new boolean[200001];

        int maxI = (int) Math.sqrt(200001);

        for (int i = 2; i <= maxI; i++) {

            if (!nonPrimeNums[i]) {

                for (int j = i * i; j < 200001; j += i) {

                    nonPrimeNums[j] = true;
                }
            }
        }

    }

    static List<Integer> betterFindPrimeFactors(int N) {

        List<Integer> list = new ArrayList<>();

        for (int i = 2; i * i <= N; i++) {

            if (N % i == 0 && !nonPrimeNums[i]) {

                do {

                    N /= i;
                    list.add(i);

                } while (N % i == 0);
            }

        }

        if (N != 1) {
            list.add(N);
        }

        return list;
    }

    private static List<Integer> bruteForceFindPrimeFactors(int N) {

        List<Integer> primeFactors = new ArrayList<>();

        for (int i = 2; i * i <= N; i++) {


            if (N % i == 0 && isPrime(i)) {

                do {
                    N /= i;
                    primeFactors.add(i);

                } while (N % i == 0);
            }
        }

        if (N != 1) {
            primeFactors.add(N);
        }

        return primeFactors;

    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

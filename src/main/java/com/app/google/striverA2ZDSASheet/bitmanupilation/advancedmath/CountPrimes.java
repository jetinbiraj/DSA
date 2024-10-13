package com.app.google.striverA2ZDSASheet.bitmanupilation.advancedmath;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {

    private static boolean[] nonPrimeNums;

    public static void main(String[] args) {

        int n = 10;

        System.out.println(bruteForceCountPrimes(n));
        System.out.println(optimalCountPrimes(n));
    }


    private static int optimalCountPrimes(int n) {

        int primeCount = 0;

        boolean[] nonPrimeArr = new boolean[n + 1];
        int maxI = (int) Math.sqrt(n);

        for (int i = 2; i <= maxI; i++) {

            if (!nonPrimeArr[i]) {

                for (int j = i * i; j <= n; j += i) {
                    nonPrimeArr[j] = true;
                }
            }
        }

        for (int i=2; i<n; i++) {
            if (!nonPrimeArr[i]) {
                primeCount++;
            }
        }

        return primeCount;
    }

    private static int bruteForceCountPrimes(int n) {

        int primeCount = 0;

        for (int i = 2; i < n; i++) {

            if (isPrime(i)) {
                primeCount++;
            }
        }

        return primeCount;
    }

    private static boolean isPrime(int n) {

        int maxI = (int) Math.sqrt(n);

        for (int i = 2; i <= maxI; i++) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

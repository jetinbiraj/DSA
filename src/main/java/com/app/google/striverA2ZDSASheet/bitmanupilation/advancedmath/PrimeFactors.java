package com.app.google.striverA2ZDSASheet.bitmanupilation.advancedmath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactors {

    public static void main(String[] args) {

        int n = 37;
//        int n = 20;

        System.out.println(Arrays.toString(bruteForcePrimeFactors(n)));
        System.out.println(Arrays.toString(betterForcePrimeFactors(n)));
        System.out.println(Arrays.toString(optimalForcePrimeFactors(n)));
    }

    private static int[] optimalForcePrimeFactors(int n) {

        List<Integer> primeFactors = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {

                do {
                    n /= i;
                } while (n % i == 0);

                if (isPrime(i)) {
                    primeFactors.add(i);
                }
            }
        }

        if (n != 1) {
            primeFactors.add(n);
        }

        primeFactors.add(n);

        int[] primeFactorsArr = new int[primeFactors.size()];
        int i = 0;
        for (int factor : primeFactors) {
            primeFactorsArr[i++] = factor;
        }

        return primeFactorsArr;
    }


    private static int[] betterForcePrimeFactors(int n) {

        List<Integer> primeFactors = new ArrayList<>();

        if (n != 1 && isPrime(n)) {
            return new int[]{n};
        }

        int maxI = (int) Math.sqrt(n);

        for (int i = 2; i <= maxI; i++) {
            if (n % i == 0) {
                if (isPrime(i)) {
                    primeFactors.add(i);
                }

                int secondFactor = n / i;
                if (secondFactor != i && isPrime(secondFactor)) {
                    primeFactors.add(secondFactor);
                }
            }
        }

        int[] primeFactorsArr = new int[primeFactors.size()];
        int i = 0;
        for (int factor : primeFactors) {
            primeFactorsArr[i++] = factor;
        }

        return primeFactorsArr;
    }


    private static int[] bruteForcePrimeFactors(int n) {

        List<Integer> primeFactors = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && isPrime(i)) {

                primeFactors.add(i);
            }
        }

        int[] primeFactorsArr = new int[primeFactors.size()];
        int i = 0;
        for (int factor : primeFactors) {
            primeFactorsArr[i++] = factor;
        }

        return primeFactorsArr;
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

package com.app.google.striverA2ZDSASheet.recursion.stronghold;

public class GoodNumbers {

    private static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) {

        long n = 50;

//        System.out.println(bruteForceCountGoodNumbers(n));
//        System.out.println(optimalCountGoodNumbers(n));
        System.out.println(optimalRecursiveCountGoodNumbers(n));
    }

    private static int optimalCountGoodNumbers(long n) {
        long oddPower = n / 2;
        long evenPower = n - oddPower;

        return (int) ((optimalPow(5, evenPower) * optimalPow(4, oddPower)) % mod);
    }

    private static int optimalRecursiveCountGoodNumbers(long n) {
        long oddPower = n / 2;
        long evenPower = n - oddPower;

        return (int) ((recursiveOptimalPow(5, evenPower) * recursiveOptimalPow(4, oddPower)) % mod);
    }

    private static long recursiveOptimalPow(long base, long exp) {

        if (exp == 0) {
            return 1;
        }

        if (exp % 2 == 1) {
            return (base * recursiveOptimalPow((base * base) % mod, exp / 2)) % mod;
        }
        return recursiveOptimalPow((base * base) % mod, exp / 2) % mod;
    }

    private static long optimalPow(long base, long exp) {

        long res = 1;
        while (exp > 0) {

            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }

        return res;
    }

    private static int bruteForceCountGoodNumbers(long n) {

        long oddPower = n / 2;
        long evenPower = n - oddPower;

        return (int) ((bruteForcePow(5, evenPower) * bruteForcePow(4, oddPower)) % mod);
    }


    private static long bruteForcePow(int base, long exp) {

        if (exp == 0) {
            return 1;
        }

        long res = 1;
        while (exp-- > 0) {
            res = (res * base) % mod;
        }

        return res;
    }
}



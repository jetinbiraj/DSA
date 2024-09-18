package com.app.google.striverA2ZDSASheet.recursion.stronghold;

public class Pow {

    public static void main(String[] args) {

        double x = 2;
        int n = -2147483648;

//        System.out.println(bruteForceMyPow(x, n));
        System.out.println(optimalMyPow(x, n));
        System.out.println(iterativeOptimalMyPow(x, n));
    }

    private static double iterativeOptimalMyPow(double x, int n) {
        long nn = n;
        if (n < 0) {
            x = 1 / x;
            nn = -nn;
        }

        double res = 1;

        while (nn > 0) {

            if (nn % 2 == 1) {
                res *= x;
            }

            x *= x;
            nn /= 2;
        }

        return res;
    }

    private static double optimalMyPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n < 0) {
            return (1 / x) * 1 / optimalMyPow(x, -(n + 1));
        }

        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            return optimalMyPow(x * x, n / 2);
        } else {
            return x * optimalMyPow(x * x, n / 2);
        }
    }

    private static double bruteForceMyPow(double x, int n) {

        if (n == 0 || x == 1) {
            return 1;
        }
        if (n < 0) {
            return (1 / x) * 1 / bruteForceMyPow(x, -(n + 1));
        }

        double res = x;
        while (n-- > 1) {
            res *= x;
        }

        return res;
    }
}

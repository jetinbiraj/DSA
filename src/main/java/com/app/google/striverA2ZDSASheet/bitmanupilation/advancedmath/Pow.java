package com.app.google.striverA2ZDSASheet.bitmanupilation.advancedmath;

public class Pow {

    public static void main(String[] args) {

        double x = 2.00000;
        int n = -5;

        System.out.println(bruteForceMyPow(x, n));
        System.out.println(optimalMyPow(x, n));
    }

    private static double optimalMyPow(double x, int n) {

        long nn = n;
        if (n < 0) {
            x = 1 / x;
            nn = -n;
        }

        double pow = 1;

        while (nn > 0) {

            if (n % 2 == 1) {
                pow *= x;
            }

            x *= x;
            nn /= 2;
        }

        return pow;
    }

    private static double bruteForceMyPow(double x, int n) {


        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double pow = 1;

        for (int i = 1; i <= n; i++) {
            pow *= x;
        }

        return pow;
    }
}

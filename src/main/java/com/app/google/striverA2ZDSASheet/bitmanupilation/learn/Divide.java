package com.app.google.striverA2ZDSASheet.bitmanupilation.learn;

public class Divide {

    public static void main(String[] args) {

        int dividend = -1010369383;
        int divisor = -2147483648;

        //divide two integers without using multiplication, division, and mod operator.

//        System.out.println(divide(dividend, divisor));
        System.out.println(simpleDivide(dividend, divisor));
        System.out.println(bestDivide(dividend, divisor));
    }

    private static int bestDivide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;

        int a = Math.abs(dividend), b = Math.abs(divisor), res = 0, x;

        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }

    private static int simpleDivide(int dividend, int divisor) {

        if (dividend == divisor) {
            return 1;
        }
        long ans = 0;

        boolean isPositive = (dividend < 0 == divisor < 0);

        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        while (absDividend >= absDivisor) {

            int q = 0;

            while ((absDivisor << (q + 1)) < absDividend) {
                q++;
            }

            ans += 1L << q;

            absDividend -= absDivisor << q;
        }

        if (ans == (1L << 31)) {

            if (isPositive) {
                return Integer.MAX_VALUE;
            }

            return Integer.MIN_VALUE;
        }

        return isPositive ? (int) ans : (int) -ans;
    }

    private static int divide(int dividend, int divisor) { //Not works for negative numbers

        long dvsr = divisor;
        int quo = 0;
        while (dividend >= dvsr) {
            dvsr += divisor;
            if (dvsr < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (dvsr > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            quo++;
        }

        return quo;
    }
}

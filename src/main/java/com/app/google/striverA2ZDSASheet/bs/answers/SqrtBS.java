package com.app.google.striverA2ZDSASheet.bs.answers;

public class SqrtBS {

    public static void main(String[] args) {

        System.out.println(bruteForceFloorSqrt(101));
        System.out.println(optimalFloorSqrt2(101));
        System.out.println(optimalFloorSqrt(101));
    }

    private static long optimalFloorSqrt(long n) {

        long floorSqrt = 1;

        long left = 1;
        long right = n;
        long mid;

        while (left <= right) {

            mid = (left + right) / 2;

            long midSquare = mid * mid;

            if (midSquare <= n) {
                floorSqrt = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return floorSqrt;
    }

    private static long optimalFloorSqrt2(int n) {

        return (long) Math.sqrt(n);
    }


    private static long bruteForceFloorSqrt(long n) {

        long floorSqrt = 0;

        for (long i = 1; i <= n; i++) {

            if (i * i <= n) {
                floorSqrt = i;
            } else {
                break;
            }
        }

        return floorSqrt;
    }
}

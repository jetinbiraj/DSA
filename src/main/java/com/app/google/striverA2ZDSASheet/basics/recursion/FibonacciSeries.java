package com.app.google.striverA2ZDSASheet.basics.recursion;

public class FibonacciSeries {

    public static void main(String[] args) {

        fibonacciSeries(0, 1, 0, 6);
        System.out.println("\n" + fibonacciNumber(4));

    }

    private static int fibonacciNumber(int num) {

        // Time Complexity => O(2^n)

        if (num <= 1) {
            return num;
        }

        return fibonacciNumber(num - 1) + fibonacciNumber(num - 2);
    }

    private static void fibonacciSeries(int prev, int current, int term, int target) {

        if (term >= target) {
            return;
        }

        if (prev == 0) {
            System.out.print(prev + " ");
        }

        System.out.print(current + " ");

        fibonacciSeries(current, current + prev, term + 1, target);


    }
}

package com.app.google.striverA2ZDSASheet.basics.math;

import java.util.Set;
import java.util.TreeSet;

public class Divisors {

    public static void main(String[] args) {

//        printAllDivisors(36);
//        System.out.println();
//        printAllDivisors(97);

        optimal(36);
        System.out.println();
        optimal(97);

    }

    private static void printAllDivisors(int n) {

        for (int i = 1; i <= n / 2; i++) {

            if (n % i == 0) {
                System.out.print(i + " ");
            }

        }
        System.out.print(n + " ");

    }

    private static void optimal(int n) {

        Set<Integer> divisors = new TreeSet<>();

        for (int i = 1; i <= (int) Math.sqrt(n); i++) {

            if (n % i == 0) {

                divisors.add(i);
                divisors.add(n / i);

            }

        }

        System.out.println(divisors);
    }
}

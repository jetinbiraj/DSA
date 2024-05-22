package com.app.google.striverA2ZDSASheet.basics.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

        Set<Integer> nums = new HashSet<>();

        for (int i = 1; i < (int) Math.sqrt(n); i++) {

            if (n % i == 0) {
                nums.add(i);

                if (i != n / i) {
//                    System.out.print(n/i + " ");
                    nums.add(n / i);
                }
            }

        }

        System.out.println(Arrays.toString(nums.stream().sorted().toArray()));
    }
}

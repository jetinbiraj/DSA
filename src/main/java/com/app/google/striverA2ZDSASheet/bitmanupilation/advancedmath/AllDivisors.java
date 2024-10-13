package com.app.google.striverA2ZDSASheet.bitmanupilation.advancedmath;

import java.util.*;

public class AllDivisors {

    public static void main(String[] args) {

        int n = 100;

        bruteForcePrintAllDivisors(n);
        System.out.println();
        betterForcePrintAllDivisors(n);
    }

    private static void betterForcePrintAllDivisors(int n) {

        int maxI = (int) Math.sqrt(n);
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= maxI; i++) {

            if (n % i == 0) {
                list.add(i);

                if (n / i != i) {
                    stack.push(n / i);
                }
            }
        }

        for (int num : list) {
            System.out.print(num + " ");
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }


    private static void bruteForcePrintAllDivisors(int n) {

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}

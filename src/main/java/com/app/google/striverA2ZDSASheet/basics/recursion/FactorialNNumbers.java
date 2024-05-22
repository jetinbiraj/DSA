package com.app.google.striverA2ZDSASheet.basics.recursion;

public class FactorialNNumbers {

    public static void main(String[] args) {

        System.out.println(fact(5));

    }

    private static int fact(int num) {

        if (num <= 1) {
            return 1;
        }

        return num * fact(num - 1);

    }
}

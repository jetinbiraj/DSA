package com.app.google.striverA2ZDSASheet.basics.recursion;

public class PrintNTimes {

    public static void main(String[] args) {

        print(1, 11);

    }

    private static void print(int current, int target) {

        System.out.println("AyeBiraj!!! " + current);

        if (current >= target) {
            return;
        }

        print(current + 1, target);

    }
}

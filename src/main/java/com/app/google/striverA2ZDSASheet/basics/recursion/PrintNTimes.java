package com.app.google.striverA2ZDSASheet.basics.recursion;

public class PrintNTimes {

    public static void main(String[] args) {

        printNTimes(1, 11);

    }

    private static void printNTimes(int current, int target) {

        System.out.println("Aye Biraj!!! " + current);

        if (current >= target) {
            return;
        }

        printNTimes(current + 1, target);

    }
}

package com.app.google.striverA2ZDSASheet.basics.recursion;

public class PrintNToOne {

    public static void main(String[] args) {

        printNToOne(12);
        System.out.println("-----------------------------------------");
        printNToOneBackTracking(1, 12);
    }

    private static void printNToOneBackTracking(int current, int target) {

        if (current > target) {
            return;
        }

        printNToOneBackTracking(current + 1, target);

        System.out.println(current);

    }

    private static void printNToOne(int target) {

        System.out.println(target);

        if (target <= 1) {

            return;

        }

        printNToOne(target - 1);

    }
}

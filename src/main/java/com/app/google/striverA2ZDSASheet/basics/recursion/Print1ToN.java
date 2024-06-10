package com.app.google.striverA2ZDSASheet.basics.recursion;

public class Print1ToN {

    public static void main(String[] args) {
        print1ToN(1, 12);
        System.out.println("-----------------------------");
        print1ToNBackTracking(12);
    }

    private static void print1ToNBackTracking(int target) {

        if (target < 1) {
            return;
        }
        print1ToNBackTracking(target - 1);

        System.out.println(target);

    }

    private static void print1ToN(int current, int target) {

        System.out.println(current);

        if (current >= target) {
            return;
        }

        print1ToN(current + 1, target);

    }
}

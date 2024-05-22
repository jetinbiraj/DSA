package com.app.google.striverA2ZDSASheet.basics.recursion;

public class Print1ToN {

    public static void main(String[] args) {
        print(1, 12);
    }

    private static void print(int current, int target) {

        System.out.println(current);

        if (current >= target) {
            return;
        }

        print(current + 1, target);

    }
}

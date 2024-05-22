package com.app.google.striverA2ZDSASheet.basics.recursion;

public class PrintNToOne {

    public static void main(String[] args) {

        print(12);

    }


    private static void print(int target) {

        System.out.println(target);

        if (target <= 1) {

            return;

        }

        print(target - 1);

    }
}

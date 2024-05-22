package com.app.google.striverA2ZDSASheet.basics.recursion;

public class SumNaturalNumbers {


    public static void main(String[] args) {
        System.out.println(sum(100));
    }


    private static int sum(int num) {

        if (num <= 1) {
            return 1;
        }

        return num + sum(num - 1);

    }

}

package com.app.google.striverA2ZDSASheet.basics.recursion;

public class SumNaturalNumbers {


    public static void main(String[] args) {
        System.out.println(sumOfNumNaturalNumbers(100));
    }


    private static int sumOfNumNaturalNumbers(int num) {

        if (num < 1) {
            return 0;
        }

        return num + sumOfNumNaturalNumbers(num - 1);

    }

}

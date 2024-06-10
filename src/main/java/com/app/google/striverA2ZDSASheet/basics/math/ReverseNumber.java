package com.app.google.striverA2ZDSASheet.basics.math;

public class ReverseNumber {

    public static void main(String[] args) {

        System.out.println(reverse(1234567));

//        int i = 00000;
//
//        System.out.println(i);
    }

    private static int reverse(int n) {

        int reverseNum = 0;

        while (n > 0) {

            int div = n % 10;
            n = n / 10;

            reverseNum = reverseNum * 10 + div;
        }

        return reverseNum;
    }
}

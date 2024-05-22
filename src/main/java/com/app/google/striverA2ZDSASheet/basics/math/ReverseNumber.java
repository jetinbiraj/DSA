package com.app.google.striverA2ZDSASheet.basics.math;

public class ReverseNumber {

    public static void main(String[] args) {

//        System.out.println(reverse(1234567));

        int i = 00000;

        System.out.println(i);
    }

    private static int reverse(int n) {

        int resultNum = 0;

//       resultNum = Integer.MAX_VALUE +5;

        while (n != 0) {

            int div = n % 10;
            n = n / 10;

            resultNum = resultNum * 10 + div;
        }

        return resultNum;
    }
}

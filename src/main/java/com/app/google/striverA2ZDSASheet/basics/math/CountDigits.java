package com.app.google.striverA2ZDSASheet.basics.math;

public class CountDigits {

    public static void main(String[] args) {
//        System.out.println(countDigits(123456));
        System.out.println(getDigitCounts(123456));
        System.out.println(getDigitCounts(0));
        System.out.println(getDigitCounts(7));
    }

    private static int getDigitCounts(int num) {

        int count = 1;
        if (num > 0) {
            count = 0;
        }

        while (num > 0) {
            num = num / 10;
            count++;

        }

        return count;

    }


//    private static int countDigits(int n){
//
//        return Integer.toString(n).length();
//    }
}

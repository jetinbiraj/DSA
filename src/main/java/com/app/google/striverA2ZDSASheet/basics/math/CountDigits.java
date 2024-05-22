package com.app.google.striverA2ZDSASheet.basics.math;

public class CountDigits {

    public static void main(String[] args) {
        System.out.println(countDigits(123456));
    }

    private static int countDigits(int n){

        return Integer.toString(n).length();
    }
}

package com.app.google.striverA2ZDSASheet.basics.math;

public class Prime {

    public static void main(String[] args) {
        isPrime(101);
    }

    private static void isPrime(int n) {

//        int counter = 0;
        for (int i = 2; i < (int) Math.sqrt(n); i++) {

            if (n % i == 0) {

                System.out.println("Not PrimeNumber!");
                return;
            }
        }
        System.out.println("PrimeNumber!");

//        if (counter == 1) {
//            System.out.println("PrimeNumber!");
//        } else {
//            System.out.println("Not PrimeNumber!");
//        }
    }
}

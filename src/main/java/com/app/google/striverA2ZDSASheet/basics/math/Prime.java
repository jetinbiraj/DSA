package com.app.google.striverA2ZDSASheet.basics.math;

public class Prime {

    public static void main(String[] args) {
        isPrime(4);
        bruteIsPrime(101);
    }

    private static void isPrime(int num) {

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {

            if (num % i == 0) {

                System.out.println("Not PrimeNumber!");
                return;
            }
        }
        System.out.println("PrimeNumber!");

    }

    private static void bruteIsPrime(int num) {

        int counter = 1;

        for (int i = 1; i <= num / 2; i++) {

            if (num % i == 0) {
                counter++;
            }
        }

        if (counter == 2) {
            System.out.println("PrimeNumber!");
        } else {
            System.out.println("Not PrimeNumber!");
        }
    }
}

package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern12 {

    public static void main(String[] args) {
        int n = 6;

        pattern12(n);
    }


    private static void pattern12(int n) {

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            for (int j = 0; j < ((2 * n) - (2 * i)); j++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}

/* Output
 1          1
12        21
123      321
1234    4321
12345  54321
123456654321
 */
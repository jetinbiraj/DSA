package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern16 {

    public static void main(String[] args) {

        int n = 6;

        pattern16(n);
    }


    private static void pattern16(int n) {

        for (int i = 0; i < n; i++) {

            for (char j = 0; j <= i; j++) {

                System.out.print((char) ('A' + i) + " ");

            }

            System.out.println();
        }

    }
}

/* Output
A
B B
C C C
D D D D
E E E E E
F F F F F F
 */
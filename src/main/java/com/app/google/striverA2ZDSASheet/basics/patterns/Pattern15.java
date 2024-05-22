package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern15 {

    public static void main(String[] args) {
        int n = 6;

        pattern15(n);
    }


    private static void pattern15(int n) {

        char printer = 'A';

        for (int i = n; i > 0; i--) {

            for (char j = 'A'; j < 'A' + i; j++) {

                System.out.print(j + " ");

            }

            System.out.println();
        }

    }
}

/* Output
A B C D E F
A B C D E
A B C D
A B C
A B
A
 */
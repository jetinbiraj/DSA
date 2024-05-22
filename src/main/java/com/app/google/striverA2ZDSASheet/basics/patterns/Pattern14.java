package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern14 {

    public static void main(String[] args) {
        int n = 6;

        pattern14(n);
    }


    private static void pattern14(int n) {

        for (int i = 1; i <= n; i++) {

            for (char j = 'A'; j <  'A' + i; j++) {

                System.out.print(j + " ");

            }

            System.out.println();
        }

    }
}

/* Output
A
A B
A B C
A B C D
A B C D E
A B C D E F
 */
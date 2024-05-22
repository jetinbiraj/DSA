package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern5 {

    private static void pattern5(int n) {

        for (int i = n; i > 0; i--) {

            for (int j = i; j > 0; j--) {

                System.out.print("* ");

            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n = 5;
        pattern5(n);
    }
}

/* Output
 * * * * *
 * * * *
 * * *
 * *
 *
 */

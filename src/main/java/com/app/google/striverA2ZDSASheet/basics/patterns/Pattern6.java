package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern6 {

    private static void pattern6(int n) {

        for (int i = n; i > 0; i--) {

            for (int j = 1; j <= i; j++) {

                System.out.print(j + " ");

            }

            System.out.println();
        }
    }


    public static void main(String[] args) {
        int n = 5;
        pattern6(n);
    }
}

/* Output
 * * * * *
 * * * *
 * * *
 * *
 *
 */

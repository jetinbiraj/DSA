package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern1 {

    private static void pattern1(int n){

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print("* ");
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {

        int n = 6;
        pattern1(n);

    }
}

/* Output
 * * * * * *
 * * * * * *
 * * * * * *
 * * * * * *
 * * * * * *
 * * * * * *
 */

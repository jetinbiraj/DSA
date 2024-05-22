package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern11 {

    public static void main(String[] args) {
        int n = 11;

        pattern11(n);
    }


    private static void pattern11(int n) {

        int printer = 1;

        for (int i = 1; i <= n; i++) {

            if (i % 2 == 0) {
                printer = 0;
            } else {
                printer = 1;
            }

            for (int j = 0; j < i; j++) {

                System.out.print(printer);

                printer = 1 - printer;

            }

            System.out.println();
        }

    }
}

/* Output
 *
 **
 ***
 ****
 *****
 ****
 ***
 **
 *
 */
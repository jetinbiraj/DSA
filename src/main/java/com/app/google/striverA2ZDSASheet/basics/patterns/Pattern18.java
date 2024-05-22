package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern18 {

    public static void main(String[] args) {

        int n = 6;

        pattern18(n);
    }


    private static void pattern18(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

/* Output
F
FE
FED
FEDC
FEDCB
FEDCBA

 */
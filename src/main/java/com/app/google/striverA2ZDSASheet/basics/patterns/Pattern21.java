package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern21 {


    public static void main(String[] args) {

        int n = 5;

        pattern21(n);
    }

    private static void pattern21(int n) {

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {

                    System.out.print(" ");
                }

            }

            System.out.println();
        }
    }
}

/* Output
 *****
 *   *
 *   *
 *   *
 *****
 */
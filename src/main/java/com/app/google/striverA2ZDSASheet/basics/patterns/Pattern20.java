package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern20 {


    public static void main(String[] args) {

        int n = 5;

        pattern20(n);
    }

    private static void pattern20(int n) {

        int stars = 1;

        for (int i = 1; i <= (2 * n - 1); i++) {

            if (i <= n) {

                for (int j = 0; j < stars; j++) {
                    System.out.print("*");
                }


                for (int j = 0; j < 2 * (n - i); j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < stars; j++) {
                    System.out.print("*");
                }

                if (i != n)
                    stars++;

            } else {

                stars -= 1;

                for (int j = 0; j < stars; j++) {
                    System.out.print("*");
                }


                for (int j = 0; j < 2 * (i - n); j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < stars; j++) {
                    System.out.print("*");
                }


            }

            System.out.println();
        }
    }
}

/* Output
 *        *
 **      **
 ***    ***
 ****  ****
 **********
 ****  ****
 ***    ***
 **      **
 *        *

 */
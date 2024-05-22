package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern19 {

    public static void main(String[] args) {

        int n = 3;

        pattern19(n);
    }


    private static void pattern19(int n) {

        for(int i=0; i<n; i++){

            for(int j=0; j<n-i; j++){
                System.out.print("*"+" ");
            }

            for(int j=0; j<2*i; j++){

                System.out.print(" ");

            }

            for(int j=0; j<n-i; j++){
                System.out.print("*");
            }

            System.out.println();
        }

        reverse(n);


    }

    private static void reverse(int n){

        for(int i=1; i<=n; i++){

            for(int j=0; j<i; j++){
                System.out.print("*");
            }

            for(int j=0; j< (n-i)*2; j++){
                System.out.print(" ");

            }


            for(int j=0; j<i; j++){
                System.out.print("*");
            }


            System.out.println();
        }

    }
}

/* Output
 ************
 *****  *****
 ****    ****
 ***      ***
 **        **
 *          *
 *          *
 **        **
 ***      ***
 ****    ****
 *****  *****
 ************


 */
package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern13 {

    public static void main(String[] args) {
        int n = 6;

        pattern13(n);
    }


    private static void pattern13(int n) {

        int counter = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                System.out.print(counter + " ");

                counter += 1;

            }

            System.out.println();
        }

    }
}

/* Output
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
16 17 18 19 20 21
 */
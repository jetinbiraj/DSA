package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern11 {

    public static void main(String[] args) {
        int n = 11;

        pattern11(n);
    }


    private static void pattern11(int n) {

        int printer;

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
1
01
101
0101
10101
010101
1010101
01010101
101010101
0101010101
10101010101
 */
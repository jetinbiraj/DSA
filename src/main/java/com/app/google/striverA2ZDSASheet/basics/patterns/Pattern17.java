package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern17 {

    public static void main(String[] args) {

        int n = 3;

        pattern17(n);
    }


    private static void pattern17(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            char printer = 'A';
            int revPoint = (2 * i + 1) / 2;

            for (int j = 0; j < 2 * i + 1; j++) {

                System.out.print(printer);

                if (j >= revPoint) {
                    printer--;
                } else {
                    printer++;
                }
            }

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}

/* Output
     A
    ABA
   ABCBA
  ABCDCBA
 ABCDEDCBA
ABCDEFEDCBA
 */
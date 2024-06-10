package com.app.google.striverA2ZDSASheet.basics.patterns;

public class Pattern22 {


    public static void main(String[] args) {

        int n = 5;

        pattern21(n);
    }

    private static void pattern21(int n) {

        for (int i = 0; i < 2 * n - 1; i++) {

            for (int j = 0; j < 2 * n - 1; j++) {


                int right = (2 * n - 2) - j;
                int left = (2 * n - 2) - i;

                System.out.print(n - Math.min(Math.min(i, j), Math.min(left, right)) + " ");
            }

            System.out.println();
        }
    }
}

/* Output
5 5 5 5 5 5 5 5 5
5 4 4 4 4 4 4 4 5
5 4 3 3 3 3 3 4 5
5 4 3 2 2 2 3 4 5
5 4 3 2 1 2 3 4 5
5 4 3 2 2 2 3 4 5
5 4 3 3 3 3 3 4 5
5 4 4 4 4 4 4 4 5
5 5 5 5 5 5 5 5 5
 */
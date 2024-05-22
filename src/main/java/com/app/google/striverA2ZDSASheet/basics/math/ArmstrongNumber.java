package com.app.google.striverA2ZDSASheet.basics.math;

public class ArmstrongNumber {

    public static void main(String[] args) {


        int an = 371;

        int result = 0;

        int temp = an;

        while (temp != 0) {

            int div = temp % 10;

            result += (div * div * div);

            temp /= 10;
        }

        if (result == an) {
            System.out.println("It's an armstrong number!");
        } else {
            System.out.println("It's an armstrong number!");

        }
    }
}

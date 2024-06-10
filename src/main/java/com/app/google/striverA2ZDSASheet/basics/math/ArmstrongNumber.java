package com.app.google.striverA2ZDSASheet.basics.math;

public class ArmstrongNumber {

    public static void main(String[] args) {


        int an = 3713;
        int resultNum = 0;
        int tempNum = an;

        while (tempNum > 0) {

            int div = tempNum % 10;

            resultNum += (div * div * div);

            tempNum /= 10;
        }

        if (resultNum == an) {
            System.out.println("It's an armstrong number!");
        } else {
            System.out.println("It's not an armstrong number!");

        }
    }
}

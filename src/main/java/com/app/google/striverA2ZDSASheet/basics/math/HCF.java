package com.app.google.striverA2ZDSASheet.basics.math;

import java.util.ArrayList;
import java.util.List;

public class HCF {

    public static void main(String[] args) {

        System.out.println(hcf(4, 8));
        System.out.println(hcf(3, 6));
        System.out.println(hcf(11, 13));
        System.out.println(hcf(50, 20));
        System.out.println("////////*******************//////////////////");
        System.out.println(gcd(4, 8));
        System.out.println(gcd(3, 6));
        System.out.println(gcd(11, 13));
        System.out.println(gcd(50, 20));
    }

    private static int gcd(int num1, int num2) {

        List<String> list = new ArrayList<>();

        while (num1 > 0 && num2 > 0) {

            if (num1 > num2) {
                num1 = num1 % num2;
            } else {
                num2 = num2 % num1;
            }

        }

        if (num1 == 0) {
            return num2;
        } else {
            return num1;
        }
    }


    private static int hcf(int num1, int num2) {

        int minNum = Math.min(num1, num2);

        int gcd = 0;

        for (int i = 1; i <= minNum; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }

        }

        return gcd;
    }
}

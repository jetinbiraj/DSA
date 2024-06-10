package com.app.google.striverA2ZDSASheet.string.basic;

public class LargestOddNumber {

    public static void main(String[] args) {

        String str = "35427";
//        String str = "52";

        System.out.println(largestOddNumber(str));

    }

    public static String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {

            if (((int) num.charAt(i)) % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }

}

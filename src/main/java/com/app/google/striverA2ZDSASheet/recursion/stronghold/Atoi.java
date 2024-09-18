package com.app.google.striverA2ZDSASheet.recursion.stronghold;

public class Atoi {

    public static void main(String[] args) {

//                String str = "42";
//        String str = " -042";
//        String str = "1337c0d3";
//        String str = "0-1";
//        String str = "words and 987";
//        String str = "4193 with words";
//        String str = "-91283472332";
//        String str = "+1";
//        String str = "21474836460";
        String str = "-21474836482";

        System.out.println(recursiveAtoi(str));
    }

    private static int recursiveAtoi(String str) {

        str = str.strip();
        if (str.isEmpty()) {
            return 0;
        }
        int sign = 1;
        int atoi;

        char firstChar = str.charAt(0);
        if (firstChar == '+' || firstChar == '-') {
            sign = firstChar == '-' ? -1 : 1;
            atoi = atoi(str.substring(1), 0, sign);
        } else {
            atoi = atoi(str, 0, sign);
        }

        if (sign < 0 && atoi > 0) {
            return atoi * sign;
        }

        return atoi;
    }

    private static int atoi(String remStr, int atoi, int sign) {

        char firstChar;

        if (remStr.isEmpty() || (firstChar = remStr.charAt(0)) < '0' || firstChar > '9') {
            return atoi;
        }

        int num = firstChar - '0';

        if (atoi > (Integer.MAX_VALUE - num) / 10) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        atoi = (atoi * 10) + num;

        return atoi(remStr.substring(1), atoi, sign);
    }
}

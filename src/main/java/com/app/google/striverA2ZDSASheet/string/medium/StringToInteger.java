package com.app.google.striverA2ZDSASheet.string.medium;

public class StringToInteger {

    public static void main(String[] args) {

//        String str = "42";
//        String str = " -042";
//        String str = "1337c0d3";
//        String str = "0-1";
//        String str = "words and 987";
//        String str = "4193 with words";
//        String str = "-91283472332";
//        String str = "+1";
//        String str = "21474836460";
        String str = "-21474836482";

        System.out.println(bruteForceMyAtoi(str));
        System.out.println(cleanMyAtoi(str));
    }

    private static int cleanMyAtoi(String s) {

        s = s.stripLeading();

        if (s.isEmpty()) {
            return 0;
        }

        int index = 0, atoiNum = 0, sign = 1;

        char firstChar = s.charAt(index++);

        if (firstChar == '+' || firstChar == '-') {
            sign = firstChar == '+' ? 1 : -1;
        }

        while (index <= s.length()) {

            char charAtIndex = s.charAt(index++);

            if (charAtIndex < '0' || charAtIndex > '9') {
                break;
            }

            int digit = charAtIndex - '0';

            if (atoiNum > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            atoiNum = atoiNum * 10 + digit;
        }

        return atoiNum * sign;
    }

    private static int bruteForceMyAtoi(String s) {

        int atoiNum = 0;

        s = s.stripLeading();

        boolean isNegativeNumber = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (i == 0 && ch == '-') {
                isNegativeNumber = true;

            } else if (i == 0 && ch == '+') {
                continue;
            } else if (ch == '0' && atoiNum == 0) {
                continue;
            } else if ((int) ch >= (int) '0' && (int) ch <= (int) '9') {

                int digit = ch - '0';

                long tempNum = ((atoiNum * 10L) + digit);

                if (isNegativeNumber && tempNum * (-1) <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

                if (!isNegativeNumber && tempNum >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

                atoiNum = (int) tempNum;

            } else {
                break;
            }
        }

        if (isNegativeNumber) {
            atoiNum = atoiNum * (-1);
        }

        return atoiNum;
    }
}

package com.app.google.striverA2ZDSASheet.basics.recursion;

public class CheckPalindrome {

    public static void main(String[] args) {

        String s1 = "ABCDCBA";
        String s2 = "TAKE U FORWARD";

//        s2.r

        System.out.println(checkPalindrome(s1, 0, s1.length() - 1));
        System.out.println(checkPalindrome(s2, 0, s2.length() - 1));
    }

    private static boolean checkPalindrome(String str, int start, int last) {

        if (start >= last) {
            return true;
        }

        if (str.charAt(start) == str.charAt(last)) {
            return checkPalindrome(str, start + 1, last - 1);
        }

        return false;

    }
}

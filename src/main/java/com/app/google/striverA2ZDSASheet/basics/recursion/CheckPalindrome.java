package com.app.google.striverA2ZDSASheet.basics.recursion;

public class CheckPalindrome {

    public static void main(String[] args) {

        String s1 = "ABCDCBA";
        String s2 = "TAKE U FORWARD";

        System.out.println(isPalindrome(s1, 0, s1.length() - 1));
        System.out.println(isPalindrome(s2, 0, s2.length() - 1));
        System.out.println("-----------------------------------------");
        System.out.println(s1 + " " + isPalindrome2(s1, 0));
        System.out.println(s2 + " " + isPalindrome2(s2, 0));
    }

    private static boolean isPalindrome2(String str, int index) {

        if (index >= str.length() / 2) {
            return true;
        }

        if (str.charAt(index) == str.charAt(str.length() - index - 1)) {
            return isPalindrome2(str, index + 1);
        }

        return false;
    }

    private static boolean isPalindrome(String str, int startIndex, int lastIndex) {

        if (startIndex >= lastIndex) {
            return true;
        }

        if (str.charAt(startIndex) == str.charAt(lastIndex)) {
            return isPalindrome(str, startIndex + 1, lastIndex - 1);
        }

        return false;

    }
}

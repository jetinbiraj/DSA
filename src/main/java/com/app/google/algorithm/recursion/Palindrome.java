package com.app.google.algorithm.recursion;

public class Palindrome {

    public static void main(String[] args) {
        String str1 = "abcdcba";
        String str2 = "xxcvb";
        String str3 = "abccba";
        String str4 = "123321";
        String str5 = "1235556328729865825321";

        System.out.println(isPalindrome(str1, 0, str1.length()-1));
        System.out.println(isPalindrome(str2, 0, str2.length()-1));
        System.out.println(isPalindrome(str3, 0, str3.length()-1));
        System.out.println(isPalindrome(str4, 0, str4.length()-1));
        System.out.println(isPalindrome(str5, 0, str5.length()-1));

    }

    private static boolean isPalindrome(String str, int left, int right) {

        if (left>= right){
            return true;
        } else if (str.charAt(left) != str.charAt(right)){
            return false;
        }

        return isPalindrome(str, ++left, --right);
    }
}

package com.app.google.striverA2ZDSASheet.basics.math;

public class Palindrome {

    public static void main(String[] args) {

        isPalindrome(1122);
        isPalindrome(123321);
        isPalindrome(121);

    }

    private static void isPalindrome(int num) {

        int temp = num;

        int rev = 0;

        while (temp != 0) {

            int div = temp % 10;

            rev = rev * 10 + div;

            temp /= 10;
        }

        if (num == rev){
            System.out.println("Palindrome!!!");
        } else {
            System.out.println("Not Palindrome!!!");
        }
    }
}

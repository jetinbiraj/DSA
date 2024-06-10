package com.app.google.striverA2ZDSASheet.basics.math;

public class Palindrome {

    public static void main(String[] args) {

        isPalindrome(1122);
        isPalindrome(123321);
        isPalindrome(121);

    }

    private static void isPalindrome(int num) {

        int tempNum = num;

        int revNum = 0;

        while (tempNum > 0) {

            int div = tempNum % 10;

            revNum = revNum * 10 + div;

            tempNum /= 10;
        }

        if (num == revNum){
            System.out.println("Palindrome!!!");
        } else {
            System.out.println("Not Palindrome!!!");
        }
    }
}

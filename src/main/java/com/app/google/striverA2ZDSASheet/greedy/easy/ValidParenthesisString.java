package com.app.google.striverA2ZDSASheet.greedy.easy;

public class ValidParenthesisString {

    public static void main(String[] args) {

        String s = "(*))";

        System.out.println(bruteForceCheckValidString(s));
        System.out.println(optimalCheckValidString(s));
    }

    private static boolean optimalCheckValidString(String s) {

        int maxOp = 0;
        int minOp = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                maxOp++;
                minOp++;
            } else if (ch == ')') {

                maxOp--;
                minOp--;

            } else {
                maxOp++;
                minOp--;
            }

            if(maxOp < 0){
                return false;
            }

            minOp = Math.max(minOp, 0);
        }

        return minOp == 0;
    }

    private static boolean bruteForceCheckValidString(String s) {

        return isValid(s, 0, 0);
    }

    private static boolean isValid(String s, int index, int count) {

        if (count < 0) {
            return false;
        }

        if (index == s.length()) {
            return count == 0;
        }

        if (s.charAt(index) == '(') {
            return isValid(s, index + 1, count + 1);
        }

        if (s.charAt(index) == ')') {
            return isValid(s, index + 1, count - 1);
        }

        return isValid(s, index + 1, count + 1) || isValid(s, index + 1, count - 1) || isValid(s, index + 1, count);
    }
}

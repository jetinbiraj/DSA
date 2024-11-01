package com.app.google.striverA2ZDSASheet.stackandQueues.monotonic;

import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
        String num = "9999999999991";

        System.out.println(bruteForceRemoveKDigits(num, 8));
    }

    private static String bruteForceRemoveKDigits(String num, int k) {

        int n = num.length();

        if (n == k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        int deletedCharCount = 0;

        for (int i = 0; i < n; i++) {

            char currentChar = num.charAt(i);

            while (!stack.isEmpty() && stack.peek() > currentChar && deletedCharCount < k) {
                stack.pop();
                deletedCharCount++;
            }

            if (stack.size() < n - k) {
                stack.push(currentChar);
            } else {
                deletedCharCount++;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
                i = -1;
            } else {
                break;
            }
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}

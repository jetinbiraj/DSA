package com.app.google.striverA2ZDSASheet.stackandQueues.learning;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty() || map(ch) != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private static char map(char ch) {
        return switch (ch) {
            case ')' -> '(';
            case '}' -> '{';
            case ']' -> '[';
            default -> '0';
        };
    }
}

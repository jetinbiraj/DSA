package com.app.google.striverA2ZDSASheet.stackandQueues.conversion;

import java.util.Stack;

public class PrefixToPostfix {

    public static void main(String[] args) {
        String exp = "ABC/-AK/L-*";

        System.out.println(prefixToPostfix(exp));
    }

    private static String prefixToPostfix(String exp) {
        Stack<String> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                stack.push(String.valueOf(ch));
            } else {
                String secondElement = stack.pop();
                stack.push(ch + stack.pop() + secondElement);
            }
        }

        return stack.pop();
    }
}

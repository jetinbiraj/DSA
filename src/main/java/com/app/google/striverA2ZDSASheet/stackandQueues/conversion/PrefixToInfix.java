package com.app.google.striverA2ZDSASheet.stackandQueues.conversion;

import java.util.Stack;

public class PrefixToInfix {

    public static void main(String[] args) {
        String exp = "*+PQ-MN";

        System.out.println(prefixToInfix(exp));
    }

    private static String prefixToInfix(String exp) {
        Stack<String> stack = new Stack<>();

        int index = exp.length() - 1;

        while (index >= 0) {

            char ch = exp.charAt(index);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                stack.push(String.valueOf(ch));
            } else {
                stack.push("(" + stack.pop() + ch + stack.pop() + ")");
            }

            index--;
        }

        return stack.pop();
    }
}

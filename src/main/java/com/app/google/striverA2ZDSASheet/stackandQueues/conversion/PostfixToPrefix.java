package com.app.google.striverA2ZDSASheet.stackandQueues.conversion;

import java.util.Stack;

public class PostfixToPrefix {

    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";

        System.out.println(prefixToPostfix(exp));
    }

    private static String prefixToPostfix(String exp) {

        Stack<String> stack = new Stack<>(); //,
        int index = exp.length() - 1;

        while (index >= 0) {
            char ch = exp.charAt(index);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                stack.push(String.valueOf(ch));
            } else {

                stack.push(stack.pop() + stack.pop() + ch);
            }

            index--;
        }

        return stack.pop();
    }
}

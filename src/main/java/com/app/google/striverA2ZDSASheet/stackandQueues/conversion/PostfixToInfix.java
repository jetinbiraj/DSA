package com.app.google.striverA2ZDSASheet.stackandQueues.conversion;

import java.util.Stack;

public class PostfixToInfix {

    public static void main(String[] args) {

        String exp = "AB-DE+F*/";

        System.out.println(postfixToInfix(exp));
    }

    private static String postfixToInfix(String exp) {

        Stack<String> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {

            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                stack.push(String.valueOf(ch));
            } else {

                String secondElement = stack.pop();
                stack.push('(' + stack.pop() + ch + secondElement + ')');
            }
        }

        return stack.pop();
    }
}

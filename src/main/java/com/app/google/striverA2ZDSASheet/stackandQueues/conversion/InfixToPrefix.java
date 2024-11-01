package com.app.google.striverA2ZDSASheet.stackandQueues.conversion;

import java.util.Stack;

public class InfixToPrefix {

    public static void main(String[] args) {
        String exp = "x+y*z/w+u";

        System.out.println(infixToPrefix(exp)); //++x/*yzwu
    }

    private static String infixToPrefix(String exp) {

        StringBuilder ans = new StringBuilder();
        StringBuilder revExpSb = new StringBuilder(exp).reverse();

        for (int i = 0; i < revExpSb.length(); i++) {
            char ch = revExpSb.charAt(i);
            if (ch == '(') {
                revExpSb.setCharAt(i, ')');
            } else if (ch == ')') {
                revExpSb.setCharAt(i, '(');
            }
        }

        String revExp = revExpSb.toString();

        Stack<Character> stack = new Stack<>();

        for (char ch : revExp.toCharArray()) {

            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                ans.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop();

            } else {

                if (ch == '^') {
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
                        ans.append(stack.pop());
                    }
                } else {
                    while (!stack.isEmpty() && priority(stack.peek()) > priority(ch)) {
                        ans.append(stack.pop());
                    }
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }

    private static int priority(char ch) {
        return switch (ch) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }
}

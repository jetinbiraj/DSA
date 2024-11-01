package com.app.google.striverA2ZDSASheet.stackandQueues.conversion;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {

        String exp = "a+b*(c^d-e)^(f+g*h)-i";
//        String exp = "A*(B+C)/D";

        System.out.println(infixToPostfix(exp));
    }

    private static String infixToPostfix(String exp) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {

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

                while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
                    ans.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.toString();
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

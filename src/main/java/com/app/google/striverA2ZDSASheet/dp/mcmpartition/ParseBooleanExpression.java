package com.app.google.striverA2ZDSASheet.dp.mcmpartition;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ParseBooleanExpression {

    public static void main(String[] args) {
        String expression = "&(|(f))";

        ParseBooleanExpression obj = new ParseBooleanExpression();
        System.out.println(obj.bruteForceParseBoolExpr(expression));
        System.out.println(obj.parseBoolExprUsingRecursion(expression));
        System.out.println(obj.parseBoolExprUsingStack(expression));
    }

    private boolean parseBoolExprUsingStack(String expression) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : expression.toCharArray()) {

            if (ch == ',') {
                continue;
            }

            if (ch != ')') {
                stack.push(ch);
                continue;
            }

            List<Character> vals = new ArrayList<>();
            while (!stack.isEmpty() && stack.peek() != '(') {
                vals.add(stack.pop());
            }

            stack.pop();

            char op = stack.pop();
            if (op == '!') {
                stack.push(vals.getFirst() == 't' ? 'f' : 't');
            } else if (op == '&') {
                boolean broken = false;
                for (char val : vals) {
                    if (val == 'f') {
                        stack.push('f');
                        broken = true;
                        break;
                    }
                }

                if (!broken) {
                    stack.push('t');
                }
            } else if (op == '|') {
                boolean broken = false;
                for (char val : vals) {
                    if (val == 't') {
                        stack.push('t');
                        broken = true;
                        break;
                    }
                }

                if (!broken) {
                    stack.push('f');
                }
            }
        }

        return stack.pop() == 't';
    }

    private int index = 0;

    private boolean parseBoolExprUsingRecursion(String expression) {

        char currentChar = expression.charAt(index++);

        if (currentChar == 't') {
            return true;
        }

        if (currentChar == 'f') {
            return false;
        }

        index++;
        if (currentChar == '!') {
            boolean res = !parseBoolExprUsingRecursion(expression);
            index++;
            return res;
        }

        List<Boolean> values = new ArrayList<>();
        while (expression.charAt(index) != ')') {
            if (expression.charAt(index) == ',') {
                index++;
            }

            values.add(parseBoolExprUsingRecursion(expression));
        }

        index++;

        if (currentChar == '&') {
            for (boolean val : values) {
                if (!val) {
                    return false;
                }
            }

            return true;
        }

        if (currentChar == '|') {
            for (boolean val : values) {
                if (val) {
                    return true;
                }
            }

            return false;
        }


        return false;
    }

    private boolean bruteForceParseBoolExpr(String expression) {

        while (expression.length() > 1) {

            int start = Math.max(expression.lastIndexOf('!'),
                    Math.max(expression.lastIndexOf('&'), expression.lastIndexOf('|')));

            int end = expression.indexOf(')', start);

            String subExpr = expression.substring(start, end + 1);

            char evalExpr = evaluateSubExpr(subExpr);

            expression = expression.substring(0, start) + evalExpr + expression.substring(end + 1);
        }

        return expression.charAt(0) == 't';
    }

    private char evaluateSubExpr(String subExpr) {

        char op = subExpr.charAt(0);

        if (op == '!') {
            return subExpr.charAt(2) == 't' ? 'f' : 't';
        } else if (op == '&') {
            return subExpr.contains("f") ? 'f' : 't';
        } else if (op == '|') {
            return subExpr.contains("t") ? 't' : 'f';
        }

        return 'f';
    }
}

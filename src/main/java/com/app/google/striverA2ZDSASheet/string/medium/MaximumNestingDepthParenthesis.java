package com.app.google.striverA2ZDSASheet.string.medium;

public class MaximumNestingDepthParenthesis {

    public static void main(String[] args) {

        String str = "(3*(4*(5*(6))))";

        System.out.println(maxDepth(str));
    }


    public static int maxDepth(String s) {

        int maxNestCount = 0;
        int nestingCount = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                nestingCount++;
            } else if (ch == ')') {
                nestingCount--;
            }

            maxNestCount = Math.max(maxNestCount, nestingCount);
        }

        return maxNestCount;
    }
}

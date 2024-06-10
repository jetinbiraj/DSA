package com.app.google.striverA2ZDSASheet.string.basic;

public class MaximumNestingDepthParenthesis {

    public static void main(String[] args) {

        String str = "(3*(4*(5*(6))))";

        System.out.println(maxDepth(str));
    }


    public static int maxDepth(String s) {

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                count += 1;

                maxCount = Math.max(maxCount, count);
            } else if (s.charAt(i) == ')') {
                count -= 1;
            }

        }

        return maxCount;
    }
}

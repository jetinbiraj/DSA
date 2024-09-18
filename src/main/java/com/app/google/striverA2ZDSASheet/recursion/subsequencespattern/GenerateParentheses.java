package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {

        int n = 3;

        System.out.println(generateParenthesis(n));
    }

    private static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        generate(n, res, "", 0, 0);

        return res;
    }

    private static void generate(int n, List<String> res, String s, int openCount, int closeCount) {

        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (openCount < n) {
            generate(n, res, s + "(", openCount + 1, closeCount);
        }
        if (closeCount < openCount) {
            generate(n, res, s + ")", openCount, closeCount + 1);
        }
    }
}

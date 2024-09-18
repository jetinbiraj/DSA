package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {

    public static void main(String[] args) {

        int n = 3;

        System.out.println(bruteForceGenerateBinaryStrings(n));
        System.out.println(recursiveGenerateBinaryStrings(n));
    }

    private static List<String> recursiveGenerateBinaryStrings(int n) {

        List<String> res = new ArrayList<>();
        generateAndAdd(n, "0", res);
        generateAndAdd(n, "1", res);
        return res;
    }

    private static void generateAndAdd(int n, String s, List<String> res) {

        if (s.length() == n) {
            res.add(s);
            return;
        }

        if (s.charAt(s.length() - 1) == '0') {
            generateAndAdd(n, s + "0", res);
            generateAndAdd(n, s + "1", res);
        } else {
            generateAndAdd(n, s + "0", res);
        }
    }

    public static List<String> bruteForceGenerateBinaryStrings(int n) {

        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        sb.append("0".repeat(Math.max(0, n)));

        String copy = sb.toString();

        list.add(sb.toString());

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j += 2) {
                sb.setCharAt(j, '1');
                list.add(sb.toString());
            }

            sb = new StringBuilder(copy);
        }

        return list;
    }
}

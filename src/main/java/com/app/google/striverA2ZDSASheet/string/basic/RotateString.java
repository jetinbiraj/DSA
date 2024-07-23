package com.app.google.striverA2ZDSASheet.string.basic;

public class RotateString {

    public static void main(String[] args) {

        String str = "abcde";
        String goal = "abced";

        System.out.println(bruteForceRotateString(str, goal));
    }

    public static boolean bruteForceRotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            s = rotate(s);
            if (s.equals(goal)) {
                return true;
            }
        }

        return false;
    }

    private static String rotate(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        sb.append(s.charAt(0));

        return sb.toString();
    }
}

package com.app.google.CTCI.arrays_strings;

public class IsUnique {

    public static void main(String[] args) {
//        String str = "hutg9mnd!nk9";
//        String str = "abcd10jk";
        String str = "abcda";

        IsUnique obj = new IsUnique();
        System.out.println(obj.betterIsUnique(str));
        System.out.println(obj.betterIsUnique2(str));
    }

    // applicable only when string has letters between a - z
    private boolean betterIsUnique2(String str) {

        if (str.length() > 26) {
            return false;
        }

        int checker = 0;
        for (char ch : str.toCharArray()) {
            int val = ch - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }

            checker |= (1 << val);
        }

        return true;
    }

    private boolean betterIsUnique(String str) {

        if (str.length() > 128) {
            return false;
        }

        boolean[] hash = new boolean[128];

        for (char ch : str.toCharArray()) {
            if (hash[ch]) {
                return false;
            }

            hash[ch] = true;
        }

        return true;
    }
}

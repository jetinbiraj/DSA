package com.app.google.ds.String;

public class Concatenation {

    public static void main(String[] args) {
        StringEquality();
//        nullString();
//        multiStrings();
//        concatPlus();
//        concat();
    }

    private static void StringEquality() {
        String s = "Geeks", g = "";
        String f = s.concat(g);

        if (f == s) {
            System.out.println("Both are same");
        } else {
            System.out.println("not same");
        }

        String e = s + g;

        if (e == s) {
            System.out.println("Both are same");
        } else {
            System.out.println("not same");
        }
    }

    private static void nullString() {
        String s = "Geeks";
        String r = null;

        System.out.println(s + r);
        System.out.println(s.concat(r));
    }

    private static void multiStrings() {
        String s = "Geeks", t = "for", g = "geeks";
        System.out.println(s + t + g);
        System.out.println(s.concat(t));
    }

    private static void concatPlus() {

        String s1 = "Geeks ";
        String s2 = " for geeks! ";

        String s3 = s1.concat(s2);
        String s4 = s1 + s2;

        System.out.println(s3);
        System.out.println(s4);

    }

    private static void concat() {

        String s = "Geeks ";

        s = s.concat("for geeks!");

        System.out.println(s);

    }

}

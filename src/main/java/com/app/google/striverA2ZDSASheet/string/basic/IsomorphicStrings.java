package com.app.google.striverA2ZDSASheet.string.basic;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {

    public static void main(String[] args) {

        String s1 = "hgvoo";
        String s2 = "bnnff";

//        String s1 = "aab";
//        String s2 = "xxy";

//        System.out.println(bruteIsIsomorphic(s1, s2));
//        System.out.println(bruteIsIsomorphic(s1, s2));
        System.out.println(optimalIsIsoMorphic(s1, s2));
    }

    private static boolean optimalIsIsoMorphic(String s, String t) {

        int[] num1 = new int[256];
        int[] num2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (num1[c1] != num2[c2]) {
                return false;
            }
            num1[c1] = i + 1;
            num2[c2] = i + 1;
        }
        return true;
    }

    private static boolean betterIsIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (map.containsKey(sChar)) {

                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (set.contains(tChar)) {
                    return false;
                }
                map.put(sChar, tChar);
                set.add(tChar);
            }
        }

        return true;
    }

    private static boolean bruteIsIsomorphic(String s, String t) {

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {

            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (map1.containsKey(sChar)) {

                if (map1.get(sChar) != tChar) {
                    return false;
                }
            }

            if (map2.containsKey(tChar)) {

                if (map2.get(tChar) != sChar) {
                    return false;
                }
            }

            map1.put(sChar, tChar);
            map2.put(tChar, sChar);
        }

        return true;

    }
}

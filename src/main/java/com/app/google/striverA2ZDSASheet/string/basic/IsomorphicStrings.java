package com.app.google.striverA2ZDSASheet.string.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

    public static void main(String[] args) {

//        String s = "hgvoo";
//        String t = "bnnff";

        String s = "aab";
        String t = "xxy";

        System.out.println(bruteIsIsomorphic(s, t));
        System.out.println(betterIsIsomorphic(s, t));
        System.out.println(optimalIsIsoMorphic(s, t));
    }

    private static boolean optimalIsIsoMorphic(String s, String t) {

        int[] sArray = new int[256];
        int[] tArray = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sArray[sChar] != tArray[tChar]) {
                return false;
            }
            sArray[sChar] = i + 1;
            tArray[tChar] = i + 1;
        }
        return true;
    }

    private static boolean betterIsIsomorphic(String s, String t) {

        HashMap<Character, Character> sMap = new HashMap<>();
        HashSet<Character> mappedCharacterSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (mappedCharacterSet.contains(tChar)) {
                    return false;
                }
                sMap.put(sChar, tChar);
                mappedCharacterSet.add(tChar);
            }
        }

        return true;
    }

    private static boolean bruteIsIsomorphic(String s, String t) {

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sMap.containsKey(sChar) && sMap.get(sChar) != tChar) {
                return false;
            } else {
                sMap.put(sChar, tChar);
            }

            if (tMap.containsKey(tChar) && tMap.get(tChar) != sChar) {
                return false;
            } else {
                tMap.put(tChar, sChar);
            }
        }

        return true;
    }
}

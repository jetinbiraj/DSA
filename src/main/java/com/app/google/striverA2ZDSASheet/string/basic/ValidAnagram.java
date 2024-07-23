package com.app.google.striverA2ZDSASheet.string.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(bruteForceIsAnagram(s, t));
        System.out.println(betterIsAnagram(s, t));
        System.out.println(optimalIsAnagram(s, t));
    }

    private static boolean optimalIsAnagram(String s, String t) {

        int[] tempArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tempArr[s.charAt(i) - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            tempArr[ch - 'a']--;
        }

        for (int num : tempArr) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }


    private static boolean betterIsAnagram(String s, String t) {

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        return sMap.equals(tMap);
    }


    private static boolean bruteForceIsAnagram(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }
}

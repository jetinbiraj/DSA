package com.app.google.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";

//        Map<Character, Integer> map1 = new HashMap<>();
//        Map<Character, Integer> map2 = new HashMap<>();

//        for (char c : s1.toCharArray()) {
//            map1.put(c, map1.getOrDefault(c, 0) + 1);
//        }
//        for (char c : s2.toCharArray()) {
//            map2.put(c, map2.getOrDefault(c, 0) + 1);
//        }

        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();
//
//        for (int i = 0; i < s.length; i++) {
//            map1.put(s[i], map1.getOrDefault(s[i], 0) + 1);
//            map2.put(t[i], map2.getOrDefault(t[i], 0) + 1);
//        }
//
//        System.out.println(map1.equals(map2));

        Arrays.sort(s);
        Arrays.sort(t);
        System.out.println(Arrays.equals(s, t));

        System.out.println(s);
        System.out.println(t);
    }
}

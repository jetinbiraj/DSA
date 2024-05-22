package com.app.google.leetcode;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));
    }

    // O (m * n)
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();

            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());
    }


// O(m * nlogn
//    private static List<List<String>> groupAnagrams(String[] strs) {
//
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (String s : strs) {
//
//            char[] chars1 = s.toCharArray();
//            Arrays.sort(chars1);
//
//            String str = new String(chars1);
//
//            map.computeIfAbsent(str, k -> new ArrayList<>()).add(str);
//        }
//
//        return new ArrayList<>(map.values());
//    }
}

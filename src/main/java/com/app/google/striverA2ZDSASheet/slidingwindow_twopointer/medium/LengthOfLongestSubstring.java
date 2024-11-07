package com.app.google.striverA2ZDSASheet.slidingwindow_twopointer.medium;

import java.util.*;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
//        String str = "tmmzuxt"; // 5
        String str = "pwwwke"; // 5

        System.out.println(bruteForceLengthOfLongestSubstring(str));
        System.out.println(betterLengthOfLongestSubstring(str));
        System.out.println(optimalLengthOfLongestSubstring(str));
    }

    private static int optimalLengthOfLongestSubstring(String s) {

        int longestSubstring = 0;
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>(); // char & index

        while (j < s.length()) {

            char currentChar = s.charAt(j);
            Integer charIndex = map.get(currentChar);

            if (charIndex != null && charIndex >= i) {
                i = charIndex + 1;
            }

            map.put(currentChar, j);
            longestSubstring = Math.max(longestSubstring, j - i + 1);
            j++;
        }

        return longestSubstring;
    }

    private static int betterLengthOfLongestSubstring(String s) {

        int longestSubstring = 0;
        int i = 0;
        int j = 0;
        Set<Character> charSet = new HashSet<>();

        while (j < s.length()) {

            if (!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j++));
                longestSubstring = Math.max(longestSubstring, charSet.size());
            } else {
                charSet.remove(s.charAt(i++));
            }
        }

        return longestSubstring;
    }

    private static int bruteForceLengthOfLongestSubstring(String s) {

        int longestSubstring = 0;
        Set<Character> set = new HashSet<>();
        Deque<Character> deque = new ArrayDeque<>();


        for (char ch : s.toCharArray()) {

            if (set.contains(ch)) {

                while (!deque.isEmpty() && deque.getLast() != ch) {
                    set.remove(deque.pollLast());
                }
                deque.pollLast();
            }

            set.add(ch);
            deque.push(ch);
            longestSubstring = Math.max(longestSubstring, deque.size());
        }

        return longestSubstring;
    }
}

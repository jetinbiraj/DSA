package com.app.google.striverA2ZDSASheet.slidingwindow_twopointer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
//        String str = "tmmzuxt"; // 5
        String str = "pwwwke"; // 5

        System.out.println(bruteForceLengthOfLongestSubstring(str));
        System.out.println(optimalLengthOfLongestSubstring(str));
    }

    private static int optimalLengthOfLongestSubstring(String s) {

        int longestSubstring = 0;
        int i = 0;
        int j = 0;
        Set<Character> charSet = new HashSet<>();

        while(j < s.length()){

            if(!charSet.contains(s.charAt(j))){
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

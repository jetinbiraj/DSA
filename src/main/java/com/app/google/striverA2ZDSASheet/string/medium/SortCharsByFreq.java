package com.app.google.striverA2ZDSASheet.string.medium;

import java.util.*;

public class SortCharsByFreq {

    public static void main(String[] args) {

        String str = "tree";
//        System.out.println(bruteForceFrequencySort("Aabb"));
        System.out.println(betterFrequencySort("tree"));
    }

    private static String betterFrequencySort(String s) {

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : s.toCharArray()) {

            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sortedString = new StringBuilder();

        while (!frequencyMap.isEmpty()) {

            int maxOccurance = -1;
            char maxOccurringChar = '\0';

            for (var entry : frequencyMap.entrySet()) {

                if (entry.getValue() > maxOccurance) {

                    maxOccurance = entry.getValue();
                    maxOccurringChar = entry.getKey();
                }
            }

            sortedString.append(String.valueOf(maxOccurringChar).repeat(Math.max(0, maxOccurance)));

            frequencyMap.remove(maxOccurringChar);
        }

        return sortedString.toString();
    }


//    private static String bruteForceFrequencySort(String s) {
//
//        Map<Character, Integer> characterFreqMap = new HashMap<>();
//
//        for (char ch : s.toCharArray()) {
//            characterFreqMap.put(ch, characterFreqMap.getOrDefault(ch, 0) + 1);
//        }
//
//        List<Character>[] arrListChars = new List[s.length() + 1];
//
//        for (var entry : characterFreqMap.entrySet()) {
//            int val = entry.getValue();
//
//            if (arrListChars[val] == null) {
//                arrListChars[val] = new ArrayList<>();
//            }
//
//            for (int i = 0; i < val; i++) {
//                arrListChars[val].add(entry.getKey());
//            }
//        }
//
//        StringBuilder res = new StringBuilder();
//
//        for (int i = arrListChars.length - 1; i >= 0; i--) {
//
//            List<Character> list = arrListChars[i];
//
//            if (list != null) {
//
//                for (char ch : list) {
//                    res.append(ch);
//                }
//            }
//        }
//
//        return res.toString();
//    }
}
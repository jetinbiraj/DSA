package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    private static Map<Character, String> map;

    public static void main(String[] args) {

        System.out.println(bruteForceLetterCombinations("23"));
        System.out.println(optimalLetterCombinations("23"));
    }

    private static List<String> optimalLetterCombinations(String digits) {

        List<String> letterCombinations = new ArrayList<>();

        if (digits.isEmpty()) {
            return letterCombinations;
        }

        String[] mobileNumberMappingArr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        optimalLetterCombinations(letterCombinations, new StringBuilder(), 0, digits, mobileNumberMappingArr);

        return letterCombinations;
    }

    private static void optimalLetterCombinations(List<String> letterCombinations, StringBuilder sb, int currentCharIndex,
                                                  String digits, String[] mobileNumberMappingArr) {

        if (digits.length() == sb.length()) {
            letterCombinations.add(sb.toString());
            return;
        }

        String currentString = mobileNumberMappingArr[digits.charAt(currentCharIndex) - '0'];

        for (char ch : currentString.toCharArray()) {

            sb.append(ch);
            optimalLetterCombinations(letterCombinations, sb, currentCharIndex + 1, digits, mobileNumberMappingArr);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static List<String> bruteForceLetterCombinations(String digits) {

        List<String> letterCombinations = new ArrayList<>();

        if (digits.isEmpty()) {
            return letterCombinations;
        }

        bruteForceLetterCombinations("", digits, letterCombinations);

        return letterCombinations;
    }

    private static void bruteForceLetterCombinations(String existingStr, String remStr, List<String> letterCombinations) {


        String currentStr = getMobileNumberMapping(remStr.charAt(0));
        remStr = remStr.substring(1);

        for (char ch : currentStr.toCharArray()) {

            String newStr = existingStr + ch;
            if (remStr.isEmpty()) {
                letterCombinations.add(newStr);
            } else {
                bruteForceLetterCombinations(newStr, remStr, letterCombinations);
            }
        }
    }

    private static String getMobileNumberMapping(char ch) {

        if (map == null) {
            map = new HashMap<>();

            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
        }

        return map.get(ch);
    }
}

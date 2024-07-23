package com.app.google.striverA2ZDSASheet.string.medium;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {

    public static void main(String[] args) {

//        String str = "       a good    example       ";
//        String str = "a good   example";
        String str = "  good   example  ";
        StringBuilder sb = new StringBuilder();


        System.out.println(bruteForceReverseWords(str));
//        System.out.println(betterReverseWords(str));
//        System.out.println(optimalReverseWords(str));
    }

    private static String optimalReverseWords(String str) {

        StringBuilder reversedWords = new StringBuilder();

        String[] words = str.split("\\s+");

        for (int i = words.length - 1; i >= 0; i--) {

            reversedWords.append(words[i]).append(" ");
        }

        return reversedWords.toString().strip();
    }

    private static String betterReverseWords(String str) {

        StringBuilder reversedWords = new StringBuilder();

        String[] words = str.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {

            if (!words[i].isBlank()) {
                reversedWords.append(words[i]).append(" ");
            }
        }

        return reversedWords.toString().strip();
    }

    public static String bruteForceReverseWords(String s) {

        StringBuilder reversedWords = new StringBuilder();

        List<StringBuilder> words = new ArrayList<>();

        StringBuilder word = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch != ' ') {
                word.append(ch);
            } else {
                if (!word.isEmpty()) {
                    words.add(word);
                    word = new StringBuilder();
                }
            }
        }

        if (!word.isEmpty()) {
            words.add(word);
        }

        for (int i = words.size() - 1; i > 0; i--) {
            reversedWords.append(words.get(i)).append(" ");
        }

        return reversedWords.append(words.getFirst()).toString();
    }
}

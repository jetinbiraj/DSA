package com.app.google.striverA2ZDSASheet.recursion.subsequencespattern;

import java.util.HashSet;
import java.util.Set;

public class BetterString {

    public static void main(String[] args) {

        String str1 = "gfg";
        String str2 = "ggg";

        System.out.println(recursiveBetterString(str1, str2));
        System.out.println(betterString(str1, str2));
    }

    //TODO: Optimise the solution using DP

    private static String betterString(String str1, String str2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        subsequencesUsingPickAndNotPick(set1, str1, new StringBuilder(), 0, str1.length());
        subsequencesUsingPickAndNotPick(set2, str2, new StringBuilder(), 0, str2.length());

        return set2.size() > set1.size() ? str2 : str1;
    }

    private static void subsequencesUsingPickAndNotPick(Set<String> set, String str, StringBuilder sb, int index, int length) {

        if (index >= length) {
            return;
        }

        sb.append(str.charAt(index));
        set.add(sb.toString());
        subsequencesUsingPickAndNotPick(set, str, sb, index + 1, length);

        sb.deleteCharAt(sb.length() - 1);
        set.add(sb.toString());
        subsequencesUsingPickAndNotPick(set, str, sb, index + 1, length);
    }

    private static String recursiveBetterString(String str1, String str2) {

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        subsequences(set1, str1, new StringBuilder(), 0);
        subsequences(set2, str2, new StringBuilder(), 0);

        return set2.size() > set1.size() ? str2 : str1;
    }

    private static void subsequences(Set<String> set, String str, StringBuilder sb, int index) {

        if (!sb.isEmpty()) {
            set.add(sb.toString());
        }

        for (int i = index; i < str.length(); i++) {
            sb.append(str.charAt(i));
            subsequences(set, str, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

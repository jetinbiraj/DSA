package com.app.google.striverA2ZDSASheet.string.basic;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {

//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"ab", "a"};

        System.out.println(bruteForceLongestCommonPrefix(strs));
        System.out.println(betterLongestCommonPrefix(strs));
        System.out.println(optimalLongestCommonPrefix(strs));
    }

    private static String optimalLongestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        StringBuilder longestCommonPrefix = new StringBuilder();

        int smallestStringLength = Math.min(strs[0].length(), strs[strs.length - 1].length());

        if (strs.length > 1) {

            for (int i = 0; i < smallestStringLength; i++) {

                if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                    return longestCommonPrefix.toString();
                }

                longestCommonPrefix.append(strs[0].charAt(i));
            }
        } else {
            return strs[0];
        }

        return longestCommonPrefix.toString();
    }

    private static String betterLongestCommonPrefix(String[] strs) {

        StringBuilder longestCommonPrefix = new StringBuilder();

        if (strs.length > 1) {

            for (int j = 0; j < strs[0].length(); j++) {

                boolean charExists = true;
                char currentChar = strs[0].charAt(j);

                for (String str : strs) {
                    if (str.length() <= j) {
                        charExists = false;
                    } else if (str.charAt(j) != currentChar) {
                        charExists = false;
                    }
                }

                if (charExists) {
                    longestCommonPrefix.append(currentChar);
                } else {
                    break;
                }
            }

        } else if (strs.length == 1) {
            return strs[0];
        }

        return longestCommonPrefix.toString();
    }

    public static String bruteForceLongestCommonPrefix(String[] strs) {

        if (strs.length == 1) {
            return strs[0];
        }

        int smallestStringIndex = 0;

        for (int i = 1; i < strs.length; i++) {

            if (strs[i].length() < strs[smallestStringIndex].length()) {
                smallestStringIndex = i;
            }
        }

        StringBuilder longestCommonPrefix = new StringBuilder();

        for (int i = 0; i < strs[smallestStringIndex].length(); i++) {

            boolean charExists = true;

            for (String str : strs) {

                if (str.charAt(i) != strs[smallestStringIndex].charAt(i)) {
                    charExists = false;
                    break;
                }
            }

            if (charExists) {
                longestCommonPrefix.append(strs[smallestStringIndex].charAt(i));
            } else {
                break;
            }
        }

        return longestCommonPrefix.toString();
    }
}

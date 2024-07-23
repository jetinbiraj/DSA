package com.app.google.striverA2ZDSASheet.string.medium;

import java.util.*;

public class RomanToInteger {

    public static void main(String[] args) {

//        int[] arr = {0, 1, 0, 0, 1}; // 0 ,1, 0 => 0, 1, 0 => 0, 1, 0
//        int[] arr = {0, 1, 1};
//        int[] arr = {0, 1, 0};

//        System.out.println(numberOfAlternatingGroups(arr));

        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int betterRomanToInt(String s) {

        int resultNum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && romanToInt(s.charAt(i)) < romanToInt(s.charAt(i + 1))) {
                resultNum -= romanToInt(s.charAt(i));
            } else {
                resultNum += romanToInt(s.charAt(i));
            }
        }

        return resultNum;
    }

    public static int romanToInt(String s) {

        int resultNum = 0;

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);

            if (i < s.length() - 1) {

                char nextChar = s.charAt(i + 1);

                if (currentChar == 'I') {

                    if (nextChar == 'V') {
                        resultNum += 4;
                        i = i + 1;
                        continue;
                    } else if (nextChar == 'X') {
                        resultNum += 9;
                        i = i + 1;
                        continue;
                    }

                } else if (currentChar == 'X') {

                    if (nextChar == 'L') {
                        resultNum += 40;
                        i = i + 1;
                        continue;
                    } else if (nextChar == 'C') {
                        resultNum += 90;
                        i = i + 1;
                        continue;
                    }

                } else if (currentChar == 'C') {

                    if (nextChar == 'D') {
                        resultNum += 400;
                        i = i + 1;
                        continue;
                    } else if (nextChar == 'M') {
                        resultNum += 900;
                        i = i + 1;
                        continue;
                    }
                }
            }
            resultNum += romanToInt(currentChar);
        }

        return resultNum;
    }

    private static int romanToInt(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}

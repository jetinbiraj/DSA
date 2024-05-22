package com.app.google.striverA2ZDSASheet.string.basic;

public class ReverseWords {

    public static void main(String[] args) {

        String str = "       a good    example       ";

//        System.out.println(reverseWords(str));
        System.out.println(reverseWordsOptimal(str));

    }

    private static String reverseWordsOptimal(String str) {
        StringBuilder sb = new StringBuilder();

        String[] arr = str.split(" ");

        for (int i = arr.length - 1; i >= 0; i--) {

            if (!arr[i].isBlank()) {
                sb.append(arr[i]).append(" ");
            }
        }

        return sb.toString().strip();
    }


    private static String reverseWords(String str) {

        StringBuilder sb = new StringBuilder();

        String[] arr = str.split("\\s+");

        for (int i = arr.length - 1; i >= 0; i--) {

            sb.append(arr[i]).append(" ");

//            if (!arr[i].isBlank()) {
//
//            }
        }

        return sb.toString().strip();
    }
}

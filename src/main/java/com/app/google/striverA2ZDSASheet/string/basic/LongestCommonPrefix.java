package com.app.google.striverA2ZDSASheet.string.basic;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {

//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"ab", "a"};

//        String commonPrefix = bruteLongestCommonPrefix(strs);
        String commonPrefix = optimalLongestCommonPrefix(strs);

        System.out.println(commonPrefix);


    }

    private static String optimalLongestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        StringBuilder sb = new StringBuilder();

        if (strs.length > 1) {

            for (int i = 0; i < Math.min(strs[0].length(), strs[strs.length - 1].length()); i++){

                if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                    return sb.toString();
                }

                sb.append(strs[0].charAt(i));

            }

        } else {
            return strs[0];
        }


        return sb.toString();

    }

    private static String bruteLongestCommonPrefix(String[] strs) {

        StringBuilder commonPrefix = new StringBuilder();

        if (strs.length > 1) {

            for (int j = 0; j < strs[0].length(); j++) {


                boolean charExists = true;
                char currentChar = strs[0].charAt(j);

                for (int i = 1; i < strs.length; i++) {

                    String str = strs[i];
                    if (str.length() <= j) {

                        charExists = false;

                    } else if (str.charAt(j) != currentChar) {
                        charExists = false;
                    }

                }

                if (charExists) {
                    commonPrefix.append(currentChar);
                } else {
                    break;
                }

            }


        } else if (strs.length == 1) {
            return strs[0];
        }

        return commonPrefix.toString();

    }
}

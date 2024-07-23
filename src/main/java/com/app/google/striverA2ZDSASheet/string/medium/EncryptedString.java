package com.app.google.striverA2ZDSASheet.string.medium;

public class EncryptedString {

    public static void main(String[] args) {

        System.out.println(getEncryptedString("dart", 3));
    }

    public static String getEncryptedString(String s, int k) {

        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < chars.length; i++) {

            int kth = i + k;

            if (kth >= n) {

                chars[i] = s.charAt(kth % n);

            } else {
                chars[i] = s.charAt(kth);
            }
        }

        return String.valueOf(chars);
    }
}

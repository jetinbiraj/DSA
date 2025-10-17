package com.app.google.striverA2ZDSASheet.string.hard;

public class MatchingSubstringIndex {

    public static void main(String[] args) {

        String text = "gffgfg", pattern = "gfg";

        MatchingSubstringIndex obj = new MatchingSubstringIndex();
        System.out.println(obj.findMatching(text, pattern));
        System.out.println(obj.oneLinerFindMatching(text, pattern));
    }

    private int oneLinerFindMatching(String text, String pat) {
        return text.indexOf(pat);
    }

    private int findMatching(String text, String pat) {

        char[] patChars = pat.toCharArray();
        int n = text.length();

        for (int i = 0; i < n; i++) {

            char currentChar = text.charAt(i);

            if (currentChar == patChars[0] && n - i >= patChars.length) {

                boolean found = true;
                int k = i;

                for (char ch : patChars) {

                    if (ch != text.charAt(k++)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    return i;
                }
            }
        }

        return -1;
    }
}

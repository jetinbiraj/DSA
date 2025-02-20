package com.app.google.striverA2ZDSASheet.dp.subsequences;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {

        int[] g = {1, 2}, s = {1, 2, 3};

//        System.out.println(bruteForceFindContentChildren(g, s));
        System.out.println(betterFindContentChildren(g, s));
        System.out.println(cleanFindContentChildren(g, s));
        System.out.println(findContentChildren(g, s));
    }

    private static int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);

        int child = 0;
        for (int cookie = 0; child < children.length && cookie < cookies.length; cookie++) {
            if (cookies[cookie] >= children[child]) {
                child++;
            }
        }

        return child;
    }

    private static int cleanFindContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gPointer = 0, sPointer = 0;

        while (gPointer < g.length && sPointer < s.length) {

            if (g[gPointer] <= s[sPointer++]) {
                gPointer++;
            }
        }

        return gPointer;
    }

    private static int betterFindContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int index1 = 0, index2 = 0, contentChildren = 0;

        while (index1 < g.length && index2 < s.length) {

            int greed = g[index1++];
            boolean found = false;

            while (index2 < s.length) {

                if (s[index2++] >= greed) {
                    contentChildren++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                break;
            }
        }

        return contentChildren;
    }

    private static int bruteForceFindContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int contentChildren = 0;

        for (int greed : g) {

            boolean found = false;

            for (int i = 0; i < s.length; i++) {
                if (s[i] >= greed) {
                    contentChildren++;
                    s[i] = -1;
                    found = true;
                    break;
                }
            }

            if (!found) {
                break;
            }
        }

        return contentChildren;
    }
}

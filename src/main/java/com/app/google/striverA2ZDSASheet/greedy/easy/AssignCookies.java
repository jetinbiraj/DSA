package com.app.google.striverA2ZDSASheet.greedy.easy;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {

        int[] g = {1, 2};
        int[] s = {1, 2, 3};

//        System.out.println(bruteForceFindContentChildren(g, s));
        System.out.println(betterFindContentChildren(g, s));
        System.out.println(cleanFindContentChildren(g, s));
        System.out.println(findContentChildren(g, s));
    }

    private static int findContentChildren(int[] children, int[] cookies) {

        Arrays.sort(children);
        Arrays.sort(cookies);

        int child = 0;
        for (int cookie = 0; child < children.length && cookie < cookies.length; cookie ++) {
            if (cookies[cookie] >= children[child]) {
                child++;
            }
        }

        return child;
    }

    private static int cleanFindContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gPointer = 0;
        int sPointer = 0;

        while (gPointer < g.length && sPointer < s.length) {

            if (g[gPointer] <= s[sPointer]) {
                gPointer++;
            }
            sPointer++;
        }

        return gPointer;
    }

    private static int betterFindContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int children = 0;

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < g.length && pointer2 < s.length) {

            int currentNum = g[pointer1++];
            boolean found = false;

            while (pointer2 < s.length) {
                if (s[pointer2++] >= currentNum) {
                    children++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                break;
            }
        }

        return children;
    }

    private static int bruteForceFindContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int children = 0;

        for (int num : g) {

            boolean found = false;

            for (int j = 0; j < s.length; j++) {
                if (s[j] >= num) {
                    s[j] = -1;
                    children++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                break;
            }
        }

        return children;
    }
}

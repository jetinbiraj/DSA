package com.app.google.striverA2ZDSASheet.string.hard;

import java.util.ArrayList;
import java.util.List;

public class CountNSay {

    public static void main(String[] args) {

        int n = 4;

        CountNSay obj = new CountNSay();
        System.out.println(obj.recursiveCountAndSay(n));
        System.out.println(obj.iterativeCountAndSay(n));
    }

    private String iterativeCountAndSay(int n) {

        int count = 1;
        String str = "1";

        while (++count <= n) {

            List<int[]> list = new ArrayList<>();

            for (char ch : str.toCharArray()) {

                if (list.isEmpty() || list.getLast()[0] != (int) ch - '0') {
                    list.add(new int[]{(int) ch - '0', 1});
                } else {
                    list.getLast()[1]++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int[] set : list) {
                sb.append(set[1]).append(set[0]);
            }

            str = sb.toString();
        }

        return str;
    }

    private String recursiveCountAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        String str = recursiveCountAndSay(n - 1);

        List<int[]> list = new ArrayList<>();

        for (char ch : str.toCharArray()) {

            if (list.isEmpty() || list.getLast()[0] != (int) ch - '0') {
                list.add(new int[]{(int) ch - '0', 1});
            } else {
                list.getLast()[1]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] set : list) {
            sb.append(set[1]).append(set[0]);
        }

        return sb.toString();
    }
}

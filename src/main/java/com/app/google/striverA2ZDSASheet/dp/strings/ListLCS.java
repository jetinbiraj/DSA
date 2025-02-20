package com.app.google.striverA2ZDSASheet.dp.strings;

import java.util.*;

public class ListLCS {

    public static void main(String[] args) {

        String s = "abaaa", t = "baabaca";

        ListLCS obj = new ListLCS();
//        System.out.println(obj.bruteForceAllLongestCommonSubsequences(s, t));
        System.out.println(obj.allLongestCommonSubsequencesUsingMemoization(s, t));
    }

    private List<String> allLongestCommonSubsequencesUsingMemoization(String s, String t) {

        int n1 = s.length();
        int n2 = t.length();

        int[][] dp = new int[n1 + 1][n2 + 1]; //Indexes have been shifted by 1

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        Set<String> set = new TreeSet<>();
        allLongestCommonSubsequencesUsingMemoization(s, t, n1, n2, set, new StringBuilder(), dp, new HashSet<>());

        return new ArrayList<>(set);
    }

    private void allLongestCommonSubsequencesUsingMemoization(String s, String t, int index1, int index2, Set<String> set,
                                                              StringBuilder sb, int[][] dp, Set<String> memo) {

        if (index1 == 0 || index2 == 0) {
            set.add(sb.reverse().toString());
            sb.reverse();
            return;
        }

        String memKey = index1 + "," + index2 + sb.toString();
        if (memo.contains(memKey)) {
            return;
        }

        if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
            sb.append(s.charAt(index1 - 1));
            allLongestCommonSubsequencesUsingMemoization(s, t, index1 - 1, index2 - 1, set, sb, dp, memo);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (dp[index1 - 1][index2] == dp[index1][index2]) {
                allLongestCommonSubsequencesUsingMemoization(s, t, index1 - 1, index2, set, sb, dp, memo);
            }

            if (dp[index1][index2 - 1] == dp[index1][index2]) {
                allLongestCommonSubsequencesUsingMemoization(s, t, index1, index2 - 1, set, sb, dp, memo);
            }
        }

        memo.add(memKey);
    }

    private List<String> bruteForceAllLongestCommonSubsequences(String s, String t) {

        List<String> list = new ArrayList<>();

        bruteForceAllLongestCommonSubsequences(s, t, 0, 0, list, new StringBuilder());

        int lcs = 0;
        HashMap<Integer, TreeSet<String>> map = new HashMap<>();
        for (String cs : list) {
            int len = cs.length();
            lcs = Math.max(lcs, len);
            map.computeIfAbsent(len, k -> new TreeSet<>()).add(cs);
        }

        return lcs != 0 ? new ArrayList<>(map.get(lcs)) : List.of();
    }

    private void bruteForceAllLongestCommonSubsequences(String s, String t, int index1, int index2, List<String> list, StringBuilder sb) {

        if (index1 >= s.length() || index2 >= t.length()) {
            return;
        }

        if (s.charAt(index1) == t.charAt(index2)) {

            sb.append(s.charAt(index1));
            list.add(sb.toString());

            bruteForceAllLongestCommonSubsequences(s, t, index1 + 1, index2 + 1, list, sb);

            sb.deleteCharAt(sb.length() - 1);
            return;
        }


        bruteForceAllLongestCommonSubsequences(s, t, index1, index2 + 1, list, sb);
        bruteForceAllLongestCommonSubsequences(s, t, index1 + 1, index2, list, sb);
    }
}

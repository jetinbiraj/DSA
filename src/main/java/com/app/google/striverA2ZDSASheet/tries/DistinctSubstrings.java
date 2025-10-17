package com.app.google.striverA2ZDSASheet.tries;

public class DistinctSubstrings {

    static class TrieNode {

        TrieNode[] links = new TrieNode[26];

        public boolean containsKey(char ch) {
            return this.links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return this.links[ch - 'a'];
        }
    }

    public static void main(String[] args) {

        String str = "abc";

        DistinctSubstrings obj = new DistinctSubstrings();
        System.out.println(obj.countDistinctSubstrings(str));
        System.out.println(obj.betterCountDistinctSubstrings(str));
    }

    private int betterCountDistinctSubstrings(String str) {

        int distinctSubstrings = 0, strLength = str.length();

        TrieNode root = new TrieNode();

        for (int i = 0; i < strLength; i++) {

            TrieNode node = root;

            for (int j = i; j < strLength; j++) {

                char ch = str.charAt(j);

                if (!node.containsKey(ch)) {
                    node.links[ch - 'a'] = new TrieNode();
                    distinctSubstrings++;
                }

                node = node.get(ch);
            }
        }

        return distinctSubstrings + 1; // +1 for blank string
    }


    private int countDistinctSubstrings(String str) {

        int distinctSubstrings = 0, strLength = str.length();

        TrieNode root = new TrieNode();

        for (int i = 0; i < strLength; i++) {

            for (int j = i + 1; j <= strLength; j++) {

                String subStr = str.substring(i, j);

                TrieNode node = root;

                for (char ch : subStr.toCharArray()) {

                    if (!node.containsKey(ch)) {
                        node.links[ch - 'a'] = new TrieNode();
                        distinctSubstrings++;
                    }

                    node = node.get(ch);
                }
            }
        }

        return distinctSubstrings + 1; // +1 for blank string
    }
}

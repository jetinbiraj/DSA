package com.app.google.striverA2ZDSASheet.tries;

public class CompleteString {

    static class TrieNode {

        TrieNode[] links = new TrieNode[26];
        boolean flag;

        public boolean containsKey(char ch) {
            return this.links[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public boolean isEnd() {
            return flag;
        }

        public void setEnd() {
            this.flag = true;
        }
    }

    static class Trie {

        private final TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        private void insert(String word) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {

                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }

                node = node.get(ch);
            }

            node.setEnd();
        }

        private boolean search(String word) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {

                if (!node.containsKey(ch)) {
                    return false;
                }

                node = node.get(ch);
            }

            return node.isEnd();
        }
    }

    public static void main(String[] args) {

        int n = 6;
        String[] arr = {"n", "l", "i", "um", "ar", "xcfyc"};

        CompleteString obj = new CompleteString();

        System.out.println(obj.completeString(n, arr));
    }

    public String completeString(int n, String[] arr) {

        Trie trie = new Trie();
        for (String word : arr) {
            trie.insert(word);
        }

        int maxWordLength = 0;
        String completeString = "None";

        for (String word : arr) {

            int strLen = word.length();
            boolean found = true;

            for (int i = 1; i <= strLen; i++) {

                if (!trie.search(word.substring(0, i))) {
                    found = false;
                    break;
                }
            }

            if (found) {

                if (strLen > maxWordLength) {
                    completeString = word;
                    maxWordLength = strLen;
                } else if (maxWordLength == strLen) {
                    completeString = completeString.compareTo(word) > 0 ? word : completeString;
                }
            }
        }

        return completeString;
    }
}

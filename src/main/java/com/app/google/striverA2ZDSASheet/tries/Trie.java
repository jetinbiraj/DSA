package com.app.google.striverA2ZDSASheet.tries;

public class Trie {

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

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }

            node = node.get(ch);
        }

        node.setEnd();
    }

    public boolean search(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            if (!node.containsKey(ch)) {
                return false;
            }

            node = node.get(ch);
        }

        return node.isEnd();
    }

    public boolean startsWith(String prefix) {

        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {

            if (!node.containsKey(ch)) {
                return false;
            }

            node = node.get(ch);
        }

        return true;
    }
}

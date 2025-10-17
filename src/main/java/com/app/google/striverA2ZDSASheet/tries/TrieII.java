package com.app.google.striverA2ZDSASheet.tries;

class TrieNode {

    TrieNode[] children;
    int prefixCount, wordCount;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}

public class TrieII {

    private final TrieNode root;

    public TrieII() {
        this.root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node.children[index].prefixCount++;
            node = node.children[index];
        }

        node.wordCount++;
    }

    public int countWordsEqualTo(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';
            if (node.children[index] == null) {
                return 0;
            }

            node = node.children[ch - 'a'];
        }

        return node.wordCount;
    }

    public int countWordsStartingWith(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                return 0;
            }

            node = node.children[index];
        }

        return node.prefixCount;
    }

    public void erase(String word) {

        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            TrieNode parent = node;
            node = node.children[index];
            node.prefixCount--;

            if (node.prefixCount == 0) {
                parent.children[index] = null;
            }
        }

        node.wordCount--;
    }

    public static void main(String[] args) {


        TrieII obj = new TrieII();

        obj.insert("edqw");
        obj.insert("few");
        obj.insert("few");

        System.out.println(obj.countWordsEqualTo("few"));

        obj.erase("few");
        System.out.println(obj.countWordsStartingWith("few"));

        obj.insert("qeeaad");
        obj.insert("dfweadsaf");
        obj.insert("ewadasewd");

        System.out.println(obj.countWordsEqualTo("ewadasewd"));
        System.out.println(obj.countWordsStartingWith("ew"));
        System.out.println(obj.countWordsEqualTo("dfweadsaf"));
    }
}

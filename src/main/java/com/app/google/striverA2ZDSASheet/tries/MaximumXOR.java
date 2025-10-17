package com.app.google.striverA2ZDSASheet.tries;

public class MaximumXOR {

    static class TrieNode {
        private final TrieNode[] links = new TrieNode[2];

        public boolean containsBit(int bit) {
            return this.links[bit] != null;
        }

        public void put(int bit, TrieNode node) {
            this.links[bit] = node;
        }

        public TrieNode get(int bit) {
            return this.links[bit];
        }
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insertNum(int num) {
            TrieNode node = root;

            for (int i = 31; i >= 0; i--) {

                int bit = (num >> i) & 1;

                if (!node.containsBit(bit)) {
                    node.put(bit, new TrieNode());
                }

                node = node.get(bit);
            }
        }

        public int maxNum(int num) {
            TrieNode node = root;
            int maxNum = 0;

            for (int i = 31; i >= 0; i--) {

                int bit = (num >> i) & 1;

                if (node.containsBit(1 - bit)) {
                    maxNum |= 1 << i;
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }

            return maxNum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};

        MaximumXOR obj = new MaximumXOR();
        System.out.println(obj.bruteForceFindMaximumXOR(nums));
        System.out.println(obj.findMaximumXORUsingTrie(nums));
    }

    public int findMaximumXORUsingTrie(int[] nums) {

        Trie trie = new Trie();

        for (int num : nums) {
            trie.insertNum(num);
        }

        int maxNum = 0;

        for (int num : nums) {
            maxNum = Math.max(maxNum, trie.maxNum(num));
        }

        return maxNum;
    }

    private int bruteForceFindMaximumXOR(int[] nums) {

        int max = Integer.MIN_VALUE, n = nums.length;

        for (int num : nums) {

            for (int i : nums) {
                max = Math.max(max, num ^ i);
            }
        }

        return max;
    }
}

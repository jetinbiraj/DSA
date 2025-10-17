package com.app.google.striverA2ZDSASheet.tries;

import java.util.Arrays;
import java.util.Comparator;

public class MaxXORWithQueries {

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

        int[] nums = {5, 2, 4, 6, 6, 3};
        int[][] queries = {
                {12, 4},
                {8, 1},
                {6, 3},
        };

        int[][] offlineQueries = new int[3][3];
        int index = 0;
        for (int[] query : queries) {
            offlineQueries[index][0] = query[0];
            offlineQueries[index][1] = query[1];
            offlineQueries[index][2] = index;
            index++;
        }

        Arrays.sort(queries, Comparator.comparingInt(a -> a[1]));

        System.out.println(Arrays.deepToString(queries));

//        MaxXORWithQueries obj = new MaxXORWithQueries();
//        System.out.println(Arrays.toString(obj.bruteForceMaximizeXor(nums, queries)));
    }

    public int[] bruteForceMaximizeXor(int[] nums, int[][] queries) {

        int n = queries.length, index = 0;

        int[] xor = new int[n];

        for (int[] row : queries) {

            int currentNum = row[0], max = row[1], maxNum = 0;

            for (int num : nums) {

                if (num <= max) {
                    maxNum = Math.max(maxNum, currentNum ^ num);
                }
            }

            xor[index++] = maxNum == 0 ? -1 : maxNum;
        }

        return xor;
    }
}

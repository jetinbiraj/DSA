package com.app.google.striverA2ZDSASheet.graphs.bfs_dfs;

import com.app.google.Pair;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

        WordLadder obj = new WordLadder();

        System.out.println(obj.ladderLength(beginWord, endWord, wordList));
    }

    private int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Deque<Pair<String, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(beginWord, 1));

        while (!queue.isEmpty()) {

            var entry = queue.pollFirst();

            if (entry.getKey().equals(endWord)) {
                return entry.getValue();
            }

            checkAndAddNewEntries(queue, wordSet, entry.getKey(), entry.getValue() + 1);
        }

        return 0;
    }

    private void checkAndAddNewEntries(Deque<Pair<String, Integer>> queue, Set<String> wordSet, String word, int trans) {

        int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {

            StringBuilder wordSb = new StringBuilder(word);

            for (char ch = 'a'; ch <= 'z'; ch++) {

                wordSb.setCharAt(i, ch);
                String wordString = wordSb.toString();

                if (wordSet.contains(wordString)) {
                    wordSet.remove(wordString);
                    queue.add(new Pair<>(wordString, trans));
                }
            }
        }
    }
}

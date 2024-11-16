package com.app.google.striverA2ZDSASheet.heaps.hard;

import java.util.*;

public class Twitter {

    private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    private final Map<Integer, Set<Integer>> userMap; // userId & followeeIds
    private final List<Pair> tweetList; // List containining pair of userId and tweetId

    public Twitter() {

        userMap = new HashMap<>();
        tweetList = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {

        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new HashSet<>());
        }

        tweetList.add(new Pair(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> list = new ArrayList<>();

        int index = tweetList.size() - 1;

        while (list.size() < 10 && index >= 0) {

            Pair pair = tweetList.get(index--);
            if (pair.getKey() == userId || userMap.get(userId).contains(pair.getKey())) {
                list.add(pair.getValue());
            }
        }

        return list;
    }

    public void follow(int followerId, int followeeId) {

        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            userMap.put(followerId, set);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        userMap.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {

    }
}

package com.app.google.striverA2ZDSASheet.stackandQueues.implementation;

import java.util.LinkedHashMap;

public class LRUCache {

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer val = this.map.get(key);
        if (val == null) {
            return -1;
        }

        this.map.putFirst(key, val);

        return val;
    }

    public void put(int key, int value) {

        if (!this.map.containsKey(key) && this.map.size() == this.capacity) {
            this.map.pollLastEntry();
        }

        this.map.putFirst(key, value);
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);                     // cache is {1=1}
        lruCache.put(2, 2);                     // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1));    // return 1
        lruCache.put(3, 3);                     // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2));    // returns -1 (not found)
        lruCache.put(4, 4);                     // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lruCache.get(1));    // return -1 (not found)
        System.out.println(lruCache.get(3));    // return 3
        System.out.println(lruCache.get(4));    // return 4
    }

//    public class LRUCache {
//        private LinkedHashMap<Integer, Integer> map;
//        private final int CAPACITY;
//        public LRUCache(int capacity) {
//            CAPACITY = capacity;
//            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
//                protected boolean removeEldestEntry(Map.Entry eldest) {
//                    return size() > CAPACITY;
//                }
//            };
//        }
//        public int get(int key) {
//            return map.getOrDefault(key, -1);
//        }
//        public void set(int key, int value) {
//            map.put(key, value);
//        }
//    }

//    class LRUCache extends LinkedHashMap<Integer, Integer> {
//
//        private int capacity;
//
//        public LRUCache(int capacity) {
//            super(capacity, 0.75f, true);
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            Integer val = super.get(key);
//            return val == null ? -1 : val;
//        }
//
//        @Override
//        protected boolean removeEldestEntry(Map.Entry eldest) {
//            return size() > capacity;
//        }
//    }
}

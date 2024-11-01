package com.app.google.striverA2ZDSASheet.stackandQueues.implementation;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LFUCache {

    private int leastFrequency;
    private int capacity;
    private HashMap<Integer, LinkedHashMap<Integer, Integer>> map;  // freq & map<key, value>
    private HashMap<Integer, Integer> hashMap;  // key & freq

    public LFUCache(int capacity) {
        this.leastFrequency = 0; // 1
        this.capacity = capacity; // 2
        this.map = new LinkedHashMap<>(); // {[1, {4, 4}], [2, {3, 3}] }
        this.hashMap = new HashMap<>(); // {3, 2}, {4, 1}
    }

    public int get(int key) {

        Integer freq = hashMap.get(key);
        if (freq == null) {
            return -1;
        }

        Integer val = map.get(freq).remove(key);
        if (map.get(freq).isEmpty() && leastFrequency == freq) {
            leastFrequency = freq + 1;
        }

        LinkedHashMap<Integer, Integer> existingMap = map.getOrDefault(freq + 1, new LinkedHashMap<>());
        existingMap.putFirst(key, val);
        map.put(freq + 1, existingMap);
        hashMap.put(key, freq + 1);
        return val;
    }

    public void put(int key, int value) {

        if (hashMap.containsKey(key)) {
            int freq = hashMap.remove(key);

            map.get(freq).remove(key);
            if (map.get(freq).isEmpty() && leastFrequency == freq) {
                leastFrequency = freq + 1;
            }

            LinkedHashMap<Integer, Integer> existingMap = map.getOrDefault(freq + 1, new LinkedHashMap<>());
            existingMap.putFirst(key, value);
            map.put(freq + 1, existingMap);
            hashMap.put(key, freq + 1);
            return;
        }

        if (hashMap.size() == this.capacity) {
            hashMap.remove(map.get(leastFrequency).pollLastEntry().getKey());
        }

        LinkedHashMap<Integer, Integer> existingMap = map.getOrDefault(1, new LinkedHashMap<>());
        existingMap.putFirst(key, value);
        map.put(1, existingMap);
        hashMap.put(key, 1);
        leastFrequency = 1;
    }

    public static void main(String[] args) {

        LFUCache cache = new LFUCache(10);

        /*
        [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],
        [8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],
        [7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],
        [11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],
        [3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],
        [4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
         */

        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);

        System.out.println(cache.get(13)); // -1

        cache.put(2, 19);
        System.out.println(cache.get(2));  // 19
        System.out.println(cache.get(3));  // 17

        cache.put(5, 25);

        System.out.println(cache.get(8));  // -1

        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        System.out.println(cache.get(11));  // -1

        cache.put(9, 12);

        System.out.println(cache.get(7));  // -1
        System.out.println(cache.get(5));  // 5
        System.out.println(cache.get(8));  // -1
        System.out.println(cache.get(9));  // 12

        cache.put(4, 30);
        cache.put(9, 3);

        System.out.println(cache.get(9));  // 3
        System.out.println(cache.get(10));  // 5
        System.out.println(cache.get(10));  // 5

        cache.put(6, 14);
        cache.put(3, 1);

        System.out.println(cache.get(3));  // 1

        cache.put(10, 11);

        System.out.println(cache.get(8));  // -1

        cache.put(2, 14);

        System.out.println(cache.get(1));  // 30
        System.out.println(cache.get(5));  // 5
        System.out.println(cache.get(4));  // 30

        cache.put(11, 4);
        cache.put(12, 24);
        cache.put(5, 18);

        System.out.println(cache.get(13));  // -1

        cache.put(7, 23);
        System.out.println(cache.get(8));  // -1
        System.out.println(cache.get(12));  // 24

        cache.put(3, 27);
        cache.put(2, 12);

        System.out.println(cache.get(5));  // 18

        cache.put(2, 9);
        cache.put(13, 4);
        cache.put(8, 18);
        cache.put(1, 7);

        System.out.println(cache.get(6));  // 14

        cache.put(9, 29);
        cache.put(8, 21);

        System.out.println(cache.get(5));  // 18

        cache.put(6, 30);
        cache.put(1, 12);
        System.out.println(cache.get(10)); // 11
        cache.put(4, 12);
        cache.put(7, 22);

        cache.put(11, 26);
        cache.put(8, 17);
        cache.put(9, 29);

        System.out.println(cache.get(5));  // 18

        cache.put(3, 4);
        cache.put(11, 30);
        System.out.println(cache.get(12));  // -1 // Prob is here

        cache.put(4, 29);
        System.out.println(cache.get(3));  // 4
        System.out.println(cache.get(9));  // 29
        System.out.println(cache.get(6));  // 30

        cache.put(3, 4);
        System.out.println(cache.get(1));  // 12
        System.out.println(cache.get(10));  // 11

        cache.put(3, 29);
        cache.put(10, 28);
        cache.put(1, 20);
        cache.put(11, 13);
        System.out.println(cache.get(3));  // 29

        cache.put(3, 12);
        cache.put(3, 8);
        cache.put(10, 9);
        cache.put(3, 26);

        System.out.println(cache.get(8));  // 17
        System.out.println(cache.get(7));  // -1
        System.out.println(cache.get(5));  //18

        cache.put(13, 17);
        cache.put(2, 27);
        cache.put(11, 15);

        System.out.println(cache.get(12));  //-1

        cache.put(9, 19);
        cache.put(2, 15);
        cache.put(3, 16);

        System.out.println(cache.get(1));  //20

        cache.put(12, 17);
        cache.put(9, 1);
        cache.put(6, 19);

        System.out.println(cache.get(4));  // 29
        System.out.println(cache.get(5));  // 18
        System.out.println(cache.get(5));  // 18

        cache.put(8, 1);
        cache.put(11, 7);
        cache.put(5, 2);
        cache.put(9, 28);

        System.out.println(cache.get(1));  // 20

        cache.put(2, 2);
        cache.put(7, 4);
        cache.put(4, 22);
        cache.put(7, 24);
        cache.put(9, 26);
        cache.put(13, 28);
        cache.put(11, 26);

    }
}

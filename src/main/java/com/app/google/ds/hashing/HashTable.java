package com.app.google.ds.hashing;

import java.util.Hashtable;

public class HashTable {

    public static void main(String[] args) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        hashtable.put(1, 11);
        hashtable.put(2, 22);
        hashtable.put(3, 33);
        hashtable.put(4, 44);

        hashtable.remove(2);

        System.out.println(hashtable);


    }
}

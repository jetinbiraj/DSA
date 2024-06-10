package com.app.google.striverA2ZDSASheet.basics.hashing;

import java.util.HashMap;

public class CountFrequency {

    public static void main(String[] args) {

        int[] arr = {10, 5, 10, 15, 10, 5};

        int n = 10;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int element : arr) {

            map.put(element, map.getOrDefault(element, 0) + 1);

        }

        System.out.println(map.get(n));
    }
}

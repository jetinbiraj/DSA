package com.app.google.striverA2ZDSASheet.basics.hashing;

import java.util.HashMap;
import java.util.Map;

public class HighLowFrequency {

    public static void main(String[] args) {

        int[] arr = {10, 5, 10, 15, 10, 5};

        int n = 10;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int element : arr) {

            map.put(element, map.getOrDefault(element, 0) + 1);

        }

        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int count = entry.getValue();
            int key = entry.getKey();

            if(count > maxFreq){
                maxEle = key;
                maxFreq = count;
            }

            if (count < minFreq){
                minEle = key;
                minFreq = count;
            }


        }

        System.out.println("The highest frequency element is: " + maxEle);
        System.out.println("The lowest frequency element is: " + minEle);
    }
}

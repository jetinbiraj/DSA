package com.app.google.striverA2ZDSASheet.arrays.easy;

import java.util.*;

public class RemoveDuplicatesFromSorted {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 3, 3, 3, 4, 4, 5, 6};

//        System.out.println(removeDuplicates(arr));
//
//        System.out.println(Arrays.toString(arr));

        System.out.println(removeDuplicatesViaSet(arr));

        System.out.println(Arrays.toString(arr));

    }

    private static int removeDuplicates(int[] arr) {

        int slowPtr = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[slowPtr] != arr[i]) {
                arr[++slowPtr] = arr[i];
            }

        }

        return slowPtr + 1;

    }

    private static int removeDuplicatesViaSet(int[] arr) {

        SortedSet<Integer> set = new TreeSet<>();

        for (int num : arr) {
            set.add(num);
        }

//        for(int i=0; i<set.size();i++){
//            arr[i] = set.get();
//        }

        Iterator<Integer> itr = set.iterator();
        int index = 0 ;
        while (itr.hasNext()){
            arr[index++] = itr.next();
        }

        return set.size();

    }
}

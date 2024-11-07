package com.app.google.striverA2ZDSASheet.slidingwindow_twopointer.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitIntoBasket {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 2, 2, 2}; // {3, 3, 5, 1, 1, 2, 2, 2, 2}

        System.out.println(bruteForceTotalFruits(arr));
        System.out.println(betterTotalFruits(arr));
        System.out.println(optimalTotalFruits(arr));
    }

    private static int optimalTotalFruits(int[] arr) {

        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        int right = 0, left = 0;

        while (right < n) {

            map.put(arr[right], map.getOrDefault(arr[right++], 0) + 1);

            if (map.size() > 2) {

                Integer value = map.put(arr[left], map.get(arr[left]) - 1);

                if (value != null && value == 1) {
                    map.remove(arr[left]);
                }

                left++;
            }
        }

        return right - left;
    }

    private static int betterTotalFruits(int[] arr) {

        int maxFruits = 0;
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        int right = 0, left = 0;

        while (right < n) {

            if (map.size() < 2 || map.containsKey(arr[right])) {

                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
                right++;

            } else {

                while (map.size() == 2) {

                    Integer prevValue = map.put(arr[left], map.get(arr[left]) - 1);

                    if (prevValue != null && prevValue == 1) {
                        map.remove(arr[left]);
                    }

                    left++;
                }
            }

            maxFruits = Math.max(maxFruits, right - left);
        }

        return maxFruits;
    }

    private static int bruteForceTotalFruits(int[] arr) {

        int maxFruits = 0;
        int n = arr.length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {

            set.clear();

            for (int j = i; j < n; j++) {

                set.add(arr[j]);

                if (set.size() <= 2) {
                    maxFruits = Math.max(maxFruits, j - i + 1);
                } else {
                    break;
                }

            }

        }

        return maxFruits;
    }
}

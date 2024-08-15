package com.app.google.striverA2ZDSASheet.bs.answers;

import java.util.ArrayList;
import java.util.List;

public class KthPositive {

    public static void main(String[] args) {

//        int[] arr = {2, 3, 4, 7, 11};
        int[] arr = {1, 2, 3, 4};
        int k = 2;

        System.out.println(bruteForceFindKthPositive1(arr, k));
        System.out.println(bruteForceFindKthPositive2(arr, k));
        System.out.println(bruteForceFindKthPositive3(arr, k));
        System.out.println(optimalFindKthPositive(arr, k));
    }

    private static int optimalFindKthPositive(int[] arr, int k) {

        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {

            mid = (low + high) / 2;
            int missingNums = arr[mid] - (mid + 1);

            if (missingNums < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low + k;
    }

    private static int bruteForceFindKthPositive3(int[] arr, int k) {

        for (int num : arr) {
            if (num <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }

    private static int bruteForceFindKthPositive2(int[] arr, int k) {

        List<Integer> missingNumbers = new ArrayList<>();

        for (int i = 1; true; i++) {

            boolean numberExists = false;

            int left = 0;
            int right = arr.length - 1;
            int mid;

            while (left <= right) {
                mid = (left + right) / 2;

                if (arr[mid] == i) {
                    numberExists = true;
                    break;
                } else if (arr[mid] < i) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (!numberExists) {
                missingNumbers.add(i);
            }

            if (missingNumbers.size() >= k) {
                break;
            }
        }

        return missingNumbers.get(k - 1);
    }

    private static int bruteForceFindKthPositive1(int[] arr, int k) {

        List<Integer> missingNumbers = new ArrayList<>();

        for (int i = 1; true; i++) {
            boolean numberExists = false;

            for (int num : arr) {
                if (num == i) {
                    numberExists = true;
                    break;
                }
            }

            if (!numberExists) {
                missingNumbers.add(i);
            }

            if (missingNumbers.size() >= k) {
                break;
            }
        }

        return missingNumbers.get(k - 1);
    }
}

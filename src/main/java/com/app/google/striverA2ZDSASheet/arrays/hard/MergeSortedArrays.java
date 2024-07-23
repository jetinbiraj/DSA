package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

//        bruteForceMerge(nums1, m, nums2, n);
        optimalMerge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    private static void optimalMerge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    private static void bruteForceMerge(int[] nums1, int m, int[] nums2, int n) {

        int[] tempArray = new int[m];

        System.arraycopy(nums1, 0, tempArray, 0, m);

        int pointer1 = 0;
        int pointer2 = 0;
        int pointer3 = 0;

        while (pointer1 < m && pointer2 < n) {

            if (tempArray[pointer1] <= nums2[pointer2]) {
                nums1[pointer3++] = tempArray[pointer1];
                pointer1++;
            } else {
                nums1[pointer3++] = nums2[pointer2];
                pointer2++;
            }
        }

        while (pointer1 < m) {
            nums1[pointer3++] = tempArray[pointer1++];
        }

        while (pointer2 < n) {
            nums1[pointer3++] = nums2[pointer2++];
        }
    }
}

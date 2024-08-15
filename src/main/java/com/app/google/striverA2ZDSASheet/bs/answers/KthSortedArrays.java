package com.app.google.striverA2ZDSASheet.bs.answers;

public class KthSortedArrays {

    public static void main(String[] args) {

        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;

        System.out.println(bruteForceKthElement(arr1, arr2, k));
        System.out.println(betterKthElement(arr1, arr2, k));
        System.out.println(optimalKthElement(arr1, arr2, k));
    }

    private static int optimalKthElement(int[] arr1, int[] arr2, int k) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        if (n1 > n2) {
            return optimalKthElement(arr2, arr1, k);
        }

        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while (low <= high) {

            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1) r1 = arr1[mid1];
            if (mid2 < n2) r2 = arr2[mid2];

            if (mid1 - 1 >= 0) l1 = arr1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = arr2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }

    private static int betterKthElement(int[] arr1, int[] arr2, int k) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        int pointer1 = 0;
        int pointer2 = 0;
        int mPointer = 0;
        int kthElement = 0;

        while (pointer1 < n1 && pointer2 < n2) {

            if (arr1[pointer1] < arr2[pointer2]) {
                kthElement = arr1[pointer1++];
            } else {
                kthElement = arr2[pointer2++];
            }

            if (mPointer == k - 1) {
                return kthElement;
            }
            mPointer++;
        }

        while (pointer1 < n1) {
            kthElement = arr1[pointer1++];
            if (mPointer == k - 1) {
                return kthElement;
            }
            mPointer++;
        }

        while (pointer2 < n2) {
            kthElement = arr2[pointer2++];
            if (mPointer + 1 == k) {
                return kthElement;
            }
            if (mPointer == k - 1) {
                return kthElement;
            }
            mPointer++;

        }

        return kthElement;
    }

    private static int bruteForceKthElement(int[] arr1, int[] arr2, int k) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] mergeArray = new int[n1 + n2];

        int pointer1 = 0;
        int pointer2 = 0;
        int mPointer = 0;

        while (pointer1 < n1 && pointer2 < n2) {

            if (arr1[pointer1] < arr2[pointer2]) {
                mergeArray[mPointer] = arr1[pointer1++];
            } else {
                mergeArray[mPointer] = arr2[pointer2++];
            }

            if (mPointer == k - 1) {
                return mergeArray[mPointer];
            }
            mPointer++;
        }

        while (pointer1 < n1) {
            mergeArray[mPointer] = arr1[pointer1++];
            if (mPointer == k - 1) {
                return mergeArray[mPointer];
            }
            mPointer++;
        }

        while (pointer2 < n2) {
            mergeArray[mPointer] = arr2[pointer2++];
            if (mPointer == k - 1) {
                return mergeArray[mPointer];
            }
            mPointer++;
        }

        return mergeArray[k - 1];
    }
}

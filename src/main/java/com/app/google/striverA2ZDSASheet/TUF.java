package com.app.google.striverA2ZDSASheet;

public class TUF {
    public static int countPartitions(int[] a, int maxSum) {
        int n = a.length; //size of array.
        int partitions = 1;
        long subarraySum = 0;
        for (int j : a) {
            if (subarraySum + j <= maxSum) {
                //insert element to current subarray
                subarraySum += j;
            } else {
                //insert element to next subarray
                partitions++;
                subarraySum = j;
            }
        }
        return partitions;
    }

    public static int largestSubarraySumMinimized(int[] a, int k) {
        int low = a[0];
        int high = 0;
        //find maximum and summation:
        for (int j : a) {
            low = Math.max(low, j);
            high += j;
        }

        for (int maxSum = low; maxSum <= high; maxSum++) {
            if (countPartitions(a, maxSum) == k)
                return maxSum;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 1, 1, 1};
        int k = 5;
        int ans = largestSubarraySumMinimized(a, k);
        System.out.println("The answer is: " + ans);
    }
}




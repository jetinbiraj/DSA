package com.app.google.striverA2ZDSASheet.bs.answers;

public class SplitArray {

    public static void main(String[] args) {

        int[] nums = {7, 2, 5, 10, 8};
//        int[] nums = {2, 3, 1, 1, 1, 1, 1};
        int k = 2;
//        int k = 5;

        System.out.println(bruteForceSplitArray(nums, k));
        System.out.println(optimalSplitArray(nums, k));
    }

    private static int optimalSplitArray(int[] nums, int k) {

        int left = nums[0];
        int right = 0;
        int mid;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {

            mid = (left + right) / 2;

            int subArrays = countSubArrays(nums, mid, k);

            if (subArrays <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int bruteForceSplitArray(int[] nums, int k) {

        int maxNum = nums[0];
        int totalSum = 0;

        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            totalSum += num;
        }

        for (int i = maxNum; i <= totalSum; i++) {

            int subArrays = countSubArrays(nums, i, k);
            if (subArrays == k) {
                return i;
            } else if (subArrays < k) {
                break;
            }
        }

        return maxNum;
    }

    private static int countSubArrays(int[] nums, int currentSum, int k) {
        int subarrays = 1;
        int currentSubarraySum = 0;

        for (int num : nums) {

            if (currentSubarraySum + num <= currentSum) {
                currentSubarraySum += num;
            } else {
                subarrays++;
                currentSubarraySum = num;
            }

            if (subarrays > k) {
                break;
            }
        }
        return subarrays;
    }
}

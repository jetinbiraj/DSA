package com.app.google.striverA2ZDSASheet.slidingwindow_twopointer.medium;

public class MaxConsecutiveOnesII {

    public static void main(String[] args) {

//        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        System.out.println(longestOnes(nums, k));
        System.out.println(optimalLongestOnes(nums, k));
    }

    private static int optimalLongestOnes(int[] nums, int k) {
        int i = 0, j;
        int n = nums.length;

        for (j = 0; j < n; j++) {

            if (nums[j] == 0) {
                k--;
            }

            if (k < 0 && nums[i++] == 0) {
                k++;
            }
        }

        return j - i;
    }

    private static int longestOnes(int[] nums, int k) {

        int i = 0;
        int j = 0;
        int n = nums.length;
        int longestSubArrayLen = 0;

        while (j < n) {

            if (nums[j] == 1 || nums[j] == 0 && k > 0) {
                if (nums[j] == 0) {
                    k--;
                }
                longestSubArrayLen = Math.max(longestSubArrayLen, j - i + 1);
                j++;
            } else {

                while (nums[i] != 0) {
                    i++;
                }
                i++;
                k++;
            }
        }

        return longestSubArrayLen;
    }
}

package com.app.google.striverA2ZDSASheet.dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
//        int[] nums = {3, 4, 16, 8};
//        int[] nums = {2, 4, 6, 9, 19, 81, 729};
//        int[] nums = {5, 9, 18, 54, 108, 540, 90, 180, 360, 720};
        int[] nums = {4, 8, 10, 240};

        LargestDivisibleSubset obj = new LargestDivisibleSubset();
        System.out.println(obj.largestDivisibleSubset(nums));
    }

    private List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length, maxIndex = 0;
        Arrays.sort(nums);

        int[] dp = new int[n], hash = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            hash[i] = i;

            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }

            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        List<Integer> lds = new ArrayList<>();

        while (hash[maxIndex] != maxIndex) {
            lds.add(nums[maxIndex]);
            maxIndex = hash[maxIndex];
        }
        lds.add(nums[maxIndex]);

        return lds;
    }
}

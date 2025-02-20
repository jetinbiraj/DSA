package com.app.google.striverA2ZDSASheet.dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrintLIS {

    public static void main(String[] args) {

        int[] nums = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        PrintLIS obj = new PrintLIS();

        System.out.println(obj.longestIncreasingSubsequence(nums.length, nums));
    }

    private ArrayList<Integer> longestIncreasingSubsequence(int n, int[] nums) {

        ArrayList<Integer> lis = new ArrayList<>();

        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);

        int maxIndex = 0;

        for (int i = 0; i < n; i++) {

            hash[i] = i;

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }

            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }


        int index = maxIndex;
        while (hash[index] != index) {
            lis.add(nums[index]);
            index = hash[index];
        }
        lis.add(nums[index]);

        Collections.reverse(lis);

        return lis;
    }
}

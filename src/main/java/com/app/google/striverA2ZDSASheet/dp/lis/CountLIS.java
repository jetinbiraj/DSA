package com.app.google.striverA2ZDSASheet.dp.lis;

public class CountLIS {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 4, 7};

        CountLIS obj = new CountLIS();
        System.out.println(obj.findNumberOfLIS(nums));
    }

    private int findNumberOfLIS(int[] nums) {

        int n = nums.length, lis = 0, maxLength = 0;
        int[] dp = new int[n], count = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    if (1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];
                        count[i] = count[j];
                    } else if (1 + dp[j] == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }

            if (maxLength == dp[i]) {
                lis += count[i];
            } else if (maxLength < dp[i]) {
                maxLength = dp[i];
                lis = count[i];
            }
        }

        return lis;
    }
}

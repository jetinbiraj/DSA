package com.app.google.striverA2ZDSASheet.greedy.easy;

import java.util.Arrays;

public class MinimumCoins {

    public static void main(String[] args) {
        int[] coins = {1,2,5,10,20,50,100,500,1000};
        int sum = 87;

        System.out.println(minCoinsRecur(sum, coins));
    }

    private static int minCoinsRecur(int sum, int[] coins) {

        int coinCount = 0;

        Arrays.sort(coins);

        int right = coins.length - 1;

        while (right >= 0 && sum > 0) {

            if (coins[right] <= sum) {
                coinCount++;
                sum -= coins[right];
            } else {
                right--;
            }
        }

        if (right < 0 && sum != 0) {
            return -1;
        }

        return coinCount;
    }

    private static void reverse(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}

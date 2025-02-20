package com.app.google.striverA2ZDSASheet.dp.oneD;

public class HouseRobberII {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        HouseRobberII obj = new HouseRobberII();
        System.out.println(obj.rob(nums));
    }

    //TODO: Refer all other solution in HouseRobber

    private int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int prev = nums[0], current = Math.max(prev, nums[1]), temp;

        for (int i = 2; i < n - 1; i++) {
            temp = current;
            current = Math.max(nums[i] + prev, current);
            prev = temp;
        }

        int max = current;

        prev = nums[n - 1];
        current = Math.max(prev, nums[n - 2]);

        for (int i = n - 3; i > 0; i--) {
            temp = current;
            current = Math.max(nums[i] + prev, current);
            prev = temp;
        }

        return Math.max(max, current);
    }
}

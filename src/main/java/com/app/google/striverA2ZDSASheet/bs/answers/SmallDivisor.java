package com.app.google.striverA2ZDSASheet.bs.answers;

public class SmallDivisor {

    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println(bruteForceSmallestDivisor(nums, threshold));
        System.out.println(optimalSmallestDivisor(nums, threshold));
    }

    private static int optimalSmallestDivisor(int[] nums, int threshold) {

        int left = 1;
        int right = Integer.MAX_VALUE - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            int sum = 0;
            for (int num : nums) {
//                sum += (int) Math.ceil((double) num / mid);

                if (num % mid == 0) {
                    sum += num / mid;
                } else {
                    sum += (num / mid) + 1;
                }

                if (sum > threshold) {
                    break;
                }
            }

            if (sum <= threshold) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


    private static int bruteForceSmallestDivisor(int[] nums, int threshold) {

        for (int i = 1; true; i++) {

            int sum = 0;

            for (int num : nums) {
                sum += (int) Math.ceil((double) num / i);

                if (sum > threshold) {
                    break;
                }
            }

            if (sum <= threshold) {
                return i;
            }
        }
    }
}

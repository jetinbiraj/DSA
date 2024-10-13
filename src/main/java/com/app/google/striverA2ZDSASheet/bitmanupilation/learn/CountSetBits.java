package com.app.google.striverA2ZDSASheet.bitmanupilation.learn;

public class CountSetBits {

    public static void main(String[] args) {

        int num = 4;

        System.out.println(bruteForceCountSetBits(num));
        System.out.println(optimalCountSetBits(num));
    }

    private static int optimalCountSetBits(int n) {

        if (n == 0) {
            return 0;
        }

        int largestPower = maxPowerOfTwo(n);

        int setBitsTillLargestPower = largestPower * (1 << (largestPower - 1));

        int remainingBits = n - (1 << largestPower);

        return setBitsTillLargestPower + remainingBits + 1 + optimalCountSetBits(remainingBits);
    }

    private static int maxPowerOfTwo(int num) {

        int maxPow = 0;

        while (1 << maxPow <= num) {
            maxPow++;
        }

        return maxPow - 1;
    }

    private static int bruteForceCountSetBits(int n) {

        int count = 0;

        for (int i = 1; i <= n; i++) {

            int temp = i;

            while (temp != 0) {

                temp = temp & (temp - 1);
                count++;
            }
        }

        return count;
    }
}

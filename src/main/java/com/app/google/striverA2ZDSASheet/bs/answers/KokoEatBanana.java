package com.app.google.striverA2ZDSASheet.bs.answers;

public class KokoEatBanana {

    public static void main(String[] args) {

//        int[] piles = {3, 6, 7, 11};
//        int[] piles = {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        int[] piles = {312884470};
//        int h = 8;
//        int h = 5;
//        int h = 823855818;
        int h = 312884469;

        System.out.println(bruteForceMinEatingSpeed(piles, h));
        System.out.println(optimalMinEatingSpeed(piles, h));
    }

    private static int optimalMinEatingSpeed(int[] piles, int h) {

        int maxSpeed = 0;
        int minSpeed = Integer.MAX_VALUE;
        int pilesSize = piles.length;

        for (int num : piles) {
            if (num > maxSpeed) {
                maxSpeed = num;
            }
        }

        int left = 1;
        int right = maxSpeed;
        int mid;

        while (left <= right) {

            int hrs = 0;

            mid = (left + right) / 2;

            for (int i = 0; i < pilesSize; i++) {

                int currentPile = piles[i];

                if (currentPile % mid == 0) {
                    hrs += currentPile / mid;
                } else {
                    hrs += (currentPile / mid) + 1;
                }

                if (i == pilesSize - 1) {

                    if (hrs <= h) {
                        minSpeed = mid;
                        right = mid - 1;
                    }
                }
                if (hrs > h) {
                    left = mid + 1;
                    break;
                }
            }
        }

        return minSpeed;
    }

    private static int bruteForceMinEatingSpeed(int[] piles, int h) {

        int maxSpeed = 0;
        int minSpeed = -1;
        int pilesSize = piles.length;

        for (int num : piles) {
            if (num > maxSpeed) {
                maxSpeed = num;
            }
        }

        for (int i = 1; i <= maxSpeed; i++) {

            int hrs = 0;

            for (int j = 0; j < pilesSize; j++) {

                int currentPile = piles[j];

                if (currentPile % i == 0) {
                    hrs += currentPile / i;
                } else {
                    hrs += (currentPile / i) + 1;
                }

                if (j == pilesSize - 1 && hrs <= h) {
                    return i;
                }

                if (hrs >= h) {
                    break;
                }
            }
        }

        return minSpeed;
    }
}

package com.app.google.striverA2ZDSASheet.bs.answers;

public class MinDaysToMBouquets {

    public static void main(String[] args) {

        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;

        System.out.println(bruteForceMinDays(bloomDay, m, k));
        System.out.println(optimalMinDays(bloomDay, m, k));
    }

    private static int optimalMinDays(int[] bloomDay, int m, int k) {

        if (((long) m * k) > bloomDay.length) {
            return -1;
        }

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int num : bloomDay) {
            minDay = Math.min(minDay, num);
            maxDay = Math.max(maxDay, num);
        }
        int midDay;

        while (minDay <= maxDay) {

            midDay = (minDay + maxDay) / 2;
            int bloomedAdjFlowers = 0;
            int bouquet = 0;

            for (int day : bloomDay) {
                if (day <= midDay) {
                    bloomedAdjFlowers++;
                } else {
                    bouquet += (bloomedAdjFlowers / k);
                    bloomedAdjFlowers = 0;
                }

                if (bouquet >= m) {
                    break;
                }
            }
            bouquet += (bloomedAdjFlowers / k);

            if (bouquet < m) {
                minDay = midDay + 1;
            } else {
                maxDay = midDay - 1;
            }
        }

        return minDay;
    }


    private static int bruteForceMinDays(int[] bloomDay, int m, int k) {

        if (((long) m * k) > bloomDay.length) {
            return -1;
        }

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int num : bloomDay) {
            minDay = Math.min(minDay, num);
            maxDay = Math.max(maxDay, num);
        }

        for (int currentDay = minDay; currentDay <= maxDay; currentDay++) {

            int bloomedAdjFlowers = 0;
            int bouquet = 0;

            for (int day : bloomDay) {
                if (day <= currentDay) {
                    bloomedAdjFlowers++;
                } else {
                    bouquet += (bloomedAdjFlowers / k);
                    bloomedAdjFlowers = 0;
                }
            }

            bouquet += (bloomedAdjFlowers / k);

            if (bouquet >= m) {
                return currentDay;
            }
        }

        return -1;
    }
}

package com.app.google.striverA2ZDSASheet.greedy.mediumhard;

public class Candy {

    public static void main(String[] args) {

        int[] ratings = {1, 2, 87, 87, 87, 2, 1};

        System.out.println(bruteForceCandy(ratings));
        System.out.println(betterCandy(ratings));
        System.out.println(optimalCandy(ratings));
    }

    private static int optimalCandy(int[] ratings) {

        int n = ratings.length;
        int index = 1;
        int candies = n;

        while (index < n) {

            if (ratings[index] == ratings[index - 1]) {
                index++;
                continue;
            }

            int peak = 0;

            while (ratings[index] > ratings[index - 1]) {
                candies += ++peak;

                if (++index == n) {
                    return candies;
                }
            }

            int valley = 0;
            while (index < n && ratings[index] < ratings[index - 1]) {
                candies += ++valley;
                index++;
            }

            candies -= Math.min(peak, valley);
        }

        return candies;
    }

    private static int betterCandy(int[] ratings) {

        int n = ratings.length;
        int[] candies = new int[n];

        candies[0] = 1;

        for (int i = 1; i < n; i++) {

            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        int minCandies = candies[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }

            minCandies += candies[i];
        }

        return minCandies;
    }

    private static int bruteForceCandy(int[] ratings) {

        int n = ratings.length;

        int[] leftCheck = new int[n];
        leftCheck[0] = 1;

        int[] rightCheck = new int[n];
        rightCheck[n - 1] = 1;

        for (int i = 1; i < n; i++) {

            if (ratings[i] > ratings[i - 1]) {
                leftCheck[i] = leftCheck[i - 1] + 1;
            } else {
                leftCheck[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {

            if (ratings[i] > ratings[i + 1]) {
                rightCheck[i] = rightCheck[i + 1] + 1;
            } else {
                rightCheck[i] = 1;
            }
        }

        int minCandies = 0;

        for (int i = 0; i < n; i++) {
            minCandies += Math.max(leftCheck[i], rightCheck[i]);
        }

        return minCandies;
    }
}

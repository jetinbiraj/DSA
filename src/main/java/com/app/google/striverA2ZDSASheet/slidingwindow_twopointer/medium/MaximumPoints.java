package com.app.google.striverA2ZDSASheet.slidingwindow_twopointer.medium;

public class MaximumPoints {

    public static void main(String[] args) {

        int[] cardPoints = {96, 90, 41, 82, 39, 74, 64, 50, 30};
        int k = 8;

        System.out.println(betterMaxScore(cardPoints, k));
        System.out.println(optimalMaxScore(cardPoints, k));
    }

    private static int optimalMaxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int maxScore = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        maxScore = sum;

        int right = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            sum -= cardPoints[i];
            sum += cardPoints[right--];

            maxScore = Math.max(maxScore, sum);
        }

        return maxScore;
    }

    private static int betterMaxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int maxScore = 0;

        int totalSum = 0;
        for (int cardPoint : cardPoints) {
            totalSum += cardPoint;
        }

        int windowSum = 0;
        int right;
        for (right = 0; right < n - k; right++) {
            windowSum += cardPoints[right];
        }

        int left = 0;
        while (right < n) {
            maxScore = Math.max(maxScore, totalSum - windowSum);
            windowSum += cardPoints[right++];
            windowSum -= cardPoints[left++];
        }

        return Math.max(maxScore, totalSum - windowSum);
    }
}

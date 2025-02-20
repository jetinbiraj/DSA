package com.app.google.striverA2ZDSASheet.dp.twothreeDGrids;

public class NinjaTraining {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };

        NinjaTraining obj = new NinjaTraining();
        System.out.println(obj.bruteForceMaximumPoints(arr));
        System.out.println(obj.maximumPointsUsingMemoization(arr));
        System.out.println(obj.maximumPointsUsingTabulation(arr));
        System.out.println(obj.maximumPointsUsingSpaceOptimization(arr));
    }

    private int maximumPointsUsingSpaceOptimization(int[][] arr) {
        int n = arr.length;

        int[] dp = new int[4];

        dp[0] = Math.max(arr[0][1], arr[0][2]);
        dp[1] = Math.max(arr[0][0], arr[0][2]);
        dp[2] = Math.max(arr[0][0], arr[0][1]);
        dp[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for (int day = 1; day < n; day++) {

            int[] temp = new int[4];

            for (int lastActivity = 0; lastActivity < 4; lastActivity++) {

                for (int activity = 0; activity < 3; activity++) {

                    if (lastActivity != activity) {
                        temp[lastActivity] = Math.max(temp[lastActivity], arr[day][activity] + dp[activity]);
                    }
                }
            }

            dp = temp;
        }

        return dp[3];
    }

    private int maximumPointsUsingTabulation(int[][] arr) {
        int n = arr.length;

        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for (int day = 1; day < n; day++) {

            for (int lastActivity = 0; lastActivity < 4; lastActivity++) {

                for (int activity = 0; activity < 3; activity++) {

                    if (lastActivity != activity) {
                        dp[day][lastActivity] = Math.max(dp[day][lastActivity], arr[day][activity] + dp[day - 1][activity]);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }


    private int maximumPointsUsingMemoization(int[][] arr) {
        return maximumPointsUsingMemoization(arr, 0, 3, new int[arr.length][4]);
    }

    private int maximumPointsUsingMemoization(int[][] arr, int day, int lastActivity, int[][] dp) {

        int max = 0;
        if (day == arr.length - 1) {

            for (int i = 0; i < 3; i++) {

                dp[day][i] = arr[day][i];
                if (i != lastActivity) {
                    max = Math.max(max, arr[day][i]);
                }
            }

            return max;
        }

        if (dp[day][lastActivity] != 0) {
            return dp[day][lastActivity];
        }

        for (int i = 0; i < 3; i++) {
            if (i != lastActivity) {
                max = Math.max(max, arr[day][i] + maximumPointsUsingMemoization(arr, day + 1, i, dp));
            }
        }

        return dp[day][lastActivity] = max;
    }

    private int bruteForceMaximumPoints(int[][] arr) {
        return bruteForceMaximumPoints(arr, 0, -1);
    }

    private int bruteForceMaximumPoints(int[][] arr, int day, int lastActivity) {
        int max = 0;
        if (day == arr.length - 1) {

            for (int i = 0; i < 3; i++) {

                if (i != lastActivity) {
                    max = Math.max(max, arr[day][i]);
                }
            }

            return max;
        }

        for (int i = 0; i < 3; i++) {

            if (i != lastActivity) {
                max = Math.max(max, arr[day][i] + bruteForceMaximumPoints(arr, day + 1, i));
            }
        }

        return max;
    }
}

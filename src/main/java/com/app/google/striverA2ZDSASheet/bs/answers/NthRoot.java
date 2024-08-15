package com.app.google.striverA2ZDSASheet.bs.answers;

public class NthRoot {

    public static void main(String[] args) {

        System.out.println(bruteForceNthRoot(6, 4096));
        System.out.println(optimalNthRoot(6, 4096));
    }

    private static int optimalNthRoot(int n, int m) {

        int left = 1;
        int right = m;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;
            int checkFuncRes = checkFunc(mid, n, m);

            if (checkFuncRes == 1) {
                return mid;
            } else if (checkFuncRes == 0) {
                left = mid + 1;
            } else {

                right = mid - 1;
            }
        }

        return -1;
    }

    private static int checkFunc(int mid, int n, int m) {

        long powerMid = 1;

        for (int i = 1; i <= n; i++) {
            powerMid *= mid;
            if (powerMid > m) {
                return 2;
            }
        }

        if (powerMid == m) {
            return 1;
        }
        return 0;
    }

    private static int bruteForceNthRoot(int n, int m) {

        for (int i = 1; i <= m; i++) {

            int val = 1;

            for (int j = 1; j <= n; j++) {
                val *= i;
            }

            if (val == m) {
                return i;
            } else if (val > m) {
                break;
            }
        }

        return -1;
    }
}

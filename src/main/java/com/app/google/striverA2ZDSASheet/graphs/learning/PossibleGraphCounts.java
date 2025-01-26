package com.app.google.striverA2ZDSASheet.graphs.learning;

public class PossibleGraphCounts {

    public static void main(String[] args) {
        int n = 5;

        System.out.println(count(n));
    }

    private static long count(int n) {
        return (long) Math.pow(2, ((double) (n * (n - 1)) / 2));
    }
}

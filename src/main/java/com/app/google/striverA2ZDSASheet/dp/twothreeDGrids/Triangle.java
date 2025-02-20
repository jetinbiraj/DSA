package com.app.google.striverA2ZDSASheet.dp.twothreeDGrids;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = getTriangle();

        Triangle obj = new Triangle();
        System.out.println(obj.bruteForceMinimumTotal(triangle));
        System.out.println(obj.minimumTotalUsingMemoization(triangle));
        System.out.println(obj.minimumTotalUsingTabulation(triangle));
        System.out.println(obj.minimumTotalUsingSpaceOptimization(triangle));
        System.out.println(obj.optimalMinimumTotalUsingSpaceOptimization(triangle));
    }

    private static List<List<Integer>> getTriangle() {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>();
        row1.add(2);

        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);

        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);

        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);

        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);
        return triangle;
    }

    private int optimalMinimumTotalUsingSpaceOptimization(List<List<Integer>> triangle) {

        int rows = triangle.size();
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.getFirst().getFirst();
    }

    private int minimumTotalUsingSpaceOptimization(List<List<Integer>> triangle) {

        int rows = triangle.size(); //TODO: Love this solution
        int[] dp = new int[rows + 1];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

    private int minimumTotalUsingTabulation(List<List<Integer>> triangle) {

        int rows = triangle.size();
        List<List<Integer>> dp = new ArrayList<>(rows);

        for (List<Integer> row : triangle) {

            List<Integer> dpRow = new ArrayList<>(row.size());
            for (int i = 0; i < row.size(); i++) {
                dpRow.add(Integer.MAX_VALUE);
            }
            dp.add(dpRow);
        }

        dp.set(rows - 1, triangle.getLast());

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                dp.get(i).set(j, triangle.get(i).get(j) + Math.min(dp.get(i + 1).get(j), dp.get(i + 1).get(j + 1)));
            }
        }

        return dp.getFirst().getFirst();
    }

    public int minimumTotalUsingMemoization(List<List<Integer>> triangle) {

        List<List<Integer>> dp = new ArrayList<>(triangle.size());

        for (List<Integer> row : triangle) {

            List<Integer> dpRow = new ArrayList<>(row.size());
            for (int i = 0; i < row.size(); i++) {
                dpRow.add(Integer.MAX_VALUE);
            }
            dp.add(dpRow);
        }

        return minimumTotalUsingMemoization(triangle, 0, 0, dp);
    }

    private int minimumTotalUsingMemoization(List<List<Integer>> triangle, int row, int col, List<List<Integer>> dp) {

        if (col >= triangle.get(row).size()) {
            return Integer.MAX_VALUE;
        }

        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        int val = dp.get(row).get(col);
        if (val != Integer.MAX_VALUE) {
            return val;
        }

        int newVal = triangle.get(row).get(col) + Math.min(minimumTotalUsingMemoization(triangle, row + 1, col, dp),
                minimumTotalUsingMemoization(triangle, row + 1, col + 1, dp));

        dp.get(row).set(col, newVal);

        return newVal;
    }

    public int bruteForceMinimumTotal(List<List<Integer>> triangle) {
        return bruteForceMinimumTotal(triangle, 0, 0);
    }

    private int bruteForceMinimumTotal(List<List<Integer>> triangle, int row, int col) {

        if (col >= triangle.get(row).size()) {
            return Integer.MAX_VALUE;
        }

        if (row == triangle.size() - 1) {
            return triangle.getLast().get(col);
        }

        return triangle.get(row).get(col) + Math.min(bruteForceMinimumTotal(triangle, row + 1, col),
                bruteForceMinimumTotal(triangle, row + 1, col + 1));
    }
}

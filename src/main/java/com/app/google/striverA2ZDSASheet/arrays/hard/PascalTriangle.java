package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {

//        System.out.println(getElementRowCol(4, 1));

        System.out.println(getPascalTriangleRow(5));

//        System.out.println(generatePascalTriangle(1));

    }

    private static int getElementRowCol(int row, int column) {

	/*

	row = 5, and column = 3

	row!/ column! * (row - column)!

	*/

        if (column == 1 || column == row){
            return 1;
        }

        return fact(row - 1, 0, column - 1) / fact(column - 1, 0, column - 1);

    }


    private static int fact(int num, int currentIteration, int totalIterations) {

        currentIteration += 1;

        if (num == 0) {
            return 1;
        } else if (currentIteration >= totalIterations) {
            return num;
        }

        return num * fact(num - 1, currentIteration, totalIterations);

    }

    private static List<Integer> getPascalTriangleRow(int rowNumber){

        List<Integer> pascalTriangleRow = new ArrayList<>();

        for(int i=1; i<= rowNumber; i++){

            if (i == 1 || i == rowNumber){
                pascalTriangleRow.add(1);
            } else {

                pascalTriangleRow.add(getElementRowCol(rowNumber-1, i-1) + getElementRowCol(rowNumber-1, i));

            }

        }

        return pascalTriangleRow;

    }

    private static List<List<Integer>> generatePascalTriangle(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int currentRow = 1; currentRow <= numRows; currentRow++) {

            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < currentRow; j++) {

                if (j == 0 || j == currentRow - 1) {
                    row.add(1);
                } else {

                    row.add(result.get(currentRow - 2).get(j) + result.get(currentRow - 2).get(j - 1));

                }

            }

            result.add(row);

        }

        return result;

    }
}

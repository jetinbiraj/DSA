package com.app.google.striverA2ZDSASheet.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {

        System.out.println(getElementByRowCol(4, 2));

        System.out.println(getPascalTriangleRow(7));
        System.out.println(getOptimalPascalTriangleRow(7));

        System.out.println(generatePascalTriangle(5));
    }

    private static int getElementByRowCol(int row, int column) { //5, 4

        row = row - 1;
        column = column - 1;

        int elementAtRowCol = 1;

        for (int i = 0; i < column; i++) {
            elementAtRowCol = elementAtRowCol * (row - i) / (i + 1);
        }

        return elementAtRowCol;
    }


    private static List<Integer> getPascalTriangleRow(int rowNumber) {

        List<Integer> pascalTriangleRow = new ArrayList<>();

        for (int column = 1; column <= rowNumber; column++) {

            if (column == 1 || column == rowNumber) {
                pascalTriangleRow.add(1);
            } else {

                pascalTriangleRow.add(getElementByRowCol(rowNumber, column));

            }
        }

        return pascalTriangleRow;

    }

    private static List<Integer> getOptimalPascalTriangleRow(int rowNumber) {

        List<Integer> pascalTriangleRow = new ArrayList<>(); //

        for (int column = 0; column < rowNumber; column++) {

            if (column == 0 || column + 1 == rowNumber) {
                pascalTriangleRow.add(1);
            } else {
                pascalTriangleRow.add((pascalTriangleRow.getLast() * (rowNumber - column) / column));
            }
        }

        return pascalTriangleRow;
    }

    private static List<List<Integer>> generatePascalTriangle(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int currentRow = 1; currentRow <= numRows; currentRow++) {

            ArrayList<Integer> row = new ArrayList<>();

            for (int column = 1; column <= currentRow; column++) {

                if (column == 1 || column == currentRow) {
                    row.add(1);
                } else {

                    row.add(result.get(currentRow - 2).get(column - 1) + result.get(currentRow - 2).get(column - 2));

                }
            }

            result.add(row);
        }

        return result;
    }
}

package com.app.google.striverA2ZDSASheet.graphs.min_spanning_tree_and_disjoint_set;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {

    public static void main(String[] args) {

        int rows = 4, cols = 5;
        int[][] operators = {
                {1, 1},
                {0, 1},
                {3, 3},
                {3, 4},
        };

        NumberOfIslandsII obj = new NumberOfIslandsII();
        System.out.println(obj.numOfIslands(rows, cols, operators));
    }

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {

        List<Integer> list = new ArrayList<>(rows);
        DisjointSetBySize ds = new DisjointSetBySize(rows * cols);

        boolean[][] visited = new boolean[rows][cols];

        int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int islands = 0;

        for (int[] operator : operators) {

            int row = operator[0];
            int col = operator[1];

            if (visited[row][col]) {
                list.add(islands);
                continue;
            }

            visited[operator[0]][operator[1]] = true;
            islands++;

            for (int[] dir : delta) {

                int x = row + dir[0];
                int y = col + dir[1];

                if (x >= 0 && x < rows && y >= 0 && y < cols && visited[x][y]) {

                    int nodeNo = (row * cols) + col;
                    int adjNodeNo = (x * cols) + y;

                    if (ds.findUltimateParent(nodeNo) != ds.findUltimateParent(adjNodeNo)) {
                        islands--;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }

            list.add(islands);
        }

        return list;
    }
}

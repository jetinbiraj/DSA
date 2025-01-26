package com.app.google.striverA2ZDSASheet.graphs.min_spanning_tree_and_disjoint_set;

import java.util.HashSet;
import java.util.Set;

public class LargestIsland {

    public static void main(String[] args) {

        int[][] grid = {{1,1,}, {1,1}};

        LargestIsland obj = new LargestIsland();
        System.out.println(obj.largestIsland(grid));
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;
        DisjointSetBySize ds = new DisjointSetBySize(n * n);

        int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }

                for (int[] dir : delta) {

                    int x = row + dir[0];
                    int y = col + dir[1];

                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {

                        int nodeNo = (row * n) + col;
                        int adjNodeNo = (x * n) + y;

                        ds.unionBySize(adjNodeNo, nodeNo);
                    }
                }
            }
        }

        int large = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    continue;
                }

                Set<Integer> set = new HashSet<>();

                for (int[] dir : delta) {

                    int x = row + dir[0];
                    int y = col + dir[1];

                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                        set.add(ds.findUltimateParent((x * n) + y));
                    }
                }

                int total = 0;
                for (int node : set) {
                    total += ds.size.get(node);
                }

                large = Math.max(large, total + 1);
            }
        }

        return large == 0 ? n * n : large;
    }
}

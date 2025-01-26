package com.app.google.striverA2ZDSASheet.graphs.min_spanning_tree_and_disjoint_set;

import java.util.HashSet;
import java.util.Set;

public class RemoveStones {

    public static void main(String[] args) {

        int[][] stones = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2},
        };

        RemoveStones obj = new RemoveStones();
        System.out.println(obj.removeStonesUsingDFS(stones));
    }

    public int removeStonesUsingDFS(int[][] stones) {

        Set<int[]> visited = new HashSet<>();

        int components = 0;

        for (int[] stone : stones) {
            if (!visited.contains(stone)) {
                components++;
                dfs(stones, visited, stone);
            }
        }

        return stones.length - components;
    }

    private void dfs(int[][] stones, Set<int[]> visited, int[] currentStone) {
        visited.add(currentStone);

        for (int[] stone : stones) {
            if (!visited.contains(stone) && (currentStone[0] == stone[0] || currentStone[1] == stone[1])) {
                dfs(stones, visited, stone);
            }
        }
    }
}

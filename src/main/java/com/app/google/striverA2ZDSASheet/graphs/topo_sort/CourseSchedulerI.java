package com.app.google.striverA2ZDSASheet.graphs.topo_sort;

import java.util.*;

public class CourseSchedulerI {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};

        CourseSchedulerI obj = new CourseSchedulerI();
        System.out.println(obj.canFinish(numCourses, prerequisites));
    }

    private boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int topo = 0;

        while (!queue.isEmpty()) {

            topo++;

            for (int node : adj.get(queue.pollFirst())) {
                if (--inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        return topo == numCourses;
    }
}

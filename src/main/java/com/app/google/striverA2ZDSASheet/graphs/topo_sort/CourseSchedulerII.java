package com.app.google.striverA2ZDSASheet.graphs.topo_sort;

import java.util.*;

public class CourseSchedulerII {

    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses = 4;

        CourseSchedulerII obj = new CourseSchedulerII();
        System.out.println(Arrays.toString(obj.findOrder(numCourses, prerequisites)));
    }

    private int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses], topo = new int[numCourses];
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

        int index = 0;
        while (!queue.isEmpty()) {

            int entry = queue.pollFirst();
            topo[index++] = entry;

            for (int node : adj.get(entry)) {
                if (--inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        if (index == numCourses) {
            return topo;
        }

        return new int[]{};
    }
}

package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;
import com.sun.source.tree.Tree;

import java.sql.Wrapper;
import java.util.*;

public class BurningTree {

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8))), new TreeNode(3, null, new TreeNode(6, null, new TreeNode(9, null, new TreeNode(10)))));
        TreeNode root = new TreeNode(2, new TreeNode(1, null, null), null);

//        int target = 8;
        int target = 1;
        System.out.println(bfsMinTime(root, target));
        System.out.println(dfsMinTime(root, target));
    }

    private static int dfsMinTime(TreeNode root, int target) {
        HashMap<TreeNode, TreeNode> parentTrackerMap = new HashMap<>();
        TreeNode[] targetNode = new TreeNode[1];
        int[] minTime = {0};

        markParent(root, parentTrackerMap, targetNode, target, null);

        Set<TreeNode> visitedSet = new HashSet<>();
        visitedSet.add(targetNode[0]);

        traverse(targetNode[0], minTime, parentTrackerMap, visitedSet, 0);

        return minTime[0];
    }

    private static void traverse(TreeNode node, int[] minTime, HashMap<TreeNode, TreeNode> parentTrackerMap, Set<TreeNode> visitedSet, int time) {
        if (node == null) {
            return;
        }

        minTime[0] = Math.max(minTime[0], time);

        TreeNode parentNode = parentTrackerMap.get(node);

        if (parentNode != null && !visitedSet.contains(parentNode)) {
            visitedSet.add(parentNode);
            traverse(parentNode, minTime, parentTrackerMap, visitedSet, time + 1);
        }

        if (node.left != null && !visitedSet.contains(node.left)) {
            visitedSet.add(node.left);
            traverse(node.left, minTime, parentTrackerMap, visitedSet, time + 1);
        }

        if (node.right != null && !visitedSet.contains(node.right)) {
            visitedSet.add(node.right);
            traverse(node.right, minTime, parentTrackerMap, visitedSet, time + 1);
        }
    }

    private static int bfsMinTime(TreeNode root, int target) {

        HashMap<TreeNode, TreeNode> parentTrackerMap = new HashMap<>();
        TreeNode[] targetNode = new TreeNode[1];

        markParent(root, parentTrackerMap, targetNode, target, null);

        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.add(targetNode[0]);
        Set<TreeNode> visitedSet = new HashSet<>();
        visitedSet.add(targetNode[0]);
        int minTime = -1;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = deque.pollFirst();

                TreeNode parentNode = parentTrackerMap.get(node);
                TreeNode leftNode = node.left;
                TreeNode rightNode = node.right;

                if (parentNode != null && !visitedSet.contains(parentNode)) {
                    visitedSet.add(parentNode);
                    deque.add(parentNode);
                }

                if (leftNode != null && !visitedSet.contains(leftNode)) {
                    visitedSet.add(leftNode);
                    deque.add(leftNode);
                }

                if (rightNode != null && !visitedSet.contains(rightNode)) {
                    visitedSet.add(rightNode);
                    deque.add(rightNode);
                }
            }

            minTime++;
        }

        return minTime;
    }

    private static void markParent(TreeNode node, HashMap<TreeNode, TreeNode> parentTrackerMap, TreeNode[] targetNode, int target, TreeNode parentNode) {

        if (node == null) {
            return;
        }

        parentTrackerMap.put(node, parentNode);

        if (targetNode[0] == null && node.val == target) {
            targetNode[0] = node;
        }

        markParent(node.left, parentTrackerMap, targetNode, target, node);
        markParent(node.right, parentTrackerMap, targetNode, target, node);
    }
}

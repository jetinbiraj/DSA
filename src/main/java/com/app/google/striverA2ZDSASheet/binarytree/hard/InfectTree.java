package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class InfectTree {

    private static int maxDistance = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(5, null, new TreeNode(4, new TreeNode(9), new TreeNode(2))), new TreeNode(3, new TreeNode(10), new TreeNode(6)));

        int start = 3;

        System.out.println(bruteAmountOfTime(root, start));
        System.out.println(optimalAmountOfTime(root, start));
    }

    private static int optimalAmountOfTime(TreeNode root, int start) {
        //TODO: Learn more about this solution
        traverse(root, start);
        return maxDistance;
    }

    private static int traverse(TreeNode root, int start) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        int leftDepth = traverse(root.left, start);
        int rightDepth = traverse(root.right, start);

        if (root.val == start) {
            maxDistance = Math.max(leftDepth, rightDepth);
            depth = -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            depth = Math.max(leftDepth, rightDepth) + 1;
        } else {
            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
            maxDistance = Math.max(maxDistance, distance);
            depth = Math.min(leftDepth, rightDepth) - 1;
        }

        return depth;
    }

    private static int bruteAmountOfTime(TreeNode root, int start) {

        HashMap<TreeNode, TreeNode> parentTrackerMap = new HashMap<>();
        TreeNode[] targetNode = new TreeNode[1];
        int[] time = {0};

        markParent(root, parentTrackerMap, targetNode, start, null);

        Set<TreeNode> visitedSet = new HashSet<>();
        visitedSet.add(targetNode[0]);

        traverse(targetNode[0], time, parentTrackerMap, visitedSet, 0);

        return time[0];
    }

    private static void traverse(TreeNode node, int[] time, HashMap<TreeNode, TreeNode> parentTrackerMap, Set<TreeNode> visitedSet, int currentTime) {
        if (node == null) {
            return;
        }

        time[0] = Math.max(time[0], currentTime);

        TreeNode parentNode = parentTrackerMap.get(node);

        if (parentNode != null && !visitedSet.contains(parentNode)) {
            visitedSet.add(parentNode);
            traverse(parentNode, time, parentTrackerMap, visitedSet, currentTime + 1);
        }

        if (node.left != null && !visitedSet.contains(node.left)) {
            visitedSet.add(node.left);
            traverse(node.left, time, parentTrackerMap, visitedSet, currentTime + 1);
        }

        if (node.right != null && !visitedSet.contains(node.right)) {
            visitedSet.add(node.right);
            traverse(node.right, time, parentTrackerMap, visitedSet, currentTime + 1);
        }
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

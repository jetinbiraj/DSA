package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

public class LargestBST {

    private record Tracker(int minNodeVal, int maxNodeVal, int maxSize) {
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(4));

        System.out.println(largestBst(root));
    }

    private static int largestBst(TreeNode root) {
        return largestBstTracker(root).maxSize;
    }

    private static Tracker largestBstTracker(TreeNode node) {
        if (node == null) {
            return new Tracker(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Tracker leftTracker = largestBstTracker(node.left);
        Tracker rightTracker = largestBstTracker(node.right);

        if (leftTracker.maxNodeVal < node.val && node.val < rightTracker.minNodeVal) {
            return new Tracker(Math.min(node.val, leftTracker.minNodeVal), Math.max(node.val, rightTracker.maxNodeVal), leftTracker.maxSize + rightTracker.maxSize + 1);
        }

        return new Tracker(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(leftTracker.maxSize, rightTracker.maxSize));
    }
}


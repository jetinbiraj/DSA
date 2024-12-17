package com.app.google.striverA2ZDSASheet.binarytree.medium;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxDepth {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println(maxDepthLevelOrderTraversal(root));
        System.out.println(maxDepth(root));
        System.out.println(betterMaxDepth(root));
    }

    private static int betterMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private static int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private static int maxDepth(TreeNode node, int depth) {

        if (node == null) {
            return depth;
        }

        int tempDepth = depth;

        depth = Math.max(depth, maxDepth(node.left, tempDepth + 1));
        depth = Math.max(depth, maxDepth(node.right, tempDepth + 1));

        return depth;
    }

    private static int maxDepthLevelOrderTraversal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {

            int n = queue.size();
            depth++;

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.pollFirst();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return depth;
    }
}

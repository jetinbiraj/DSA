package com.app.google.striverA2ZDSASheet.binarytree.medium;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class MaxPathSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println(maxPathSum(root));
    }

    private static int maxPathSum(TreeNode root) {

        int[] max = {-1001};
        maxPath(root, max);

        return max[0];
    }

    private static int maxPath(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(0, maxPath(node.left, max));
        int rightMax = Math.max(0, maxPath(node.right, max));

        max[0] = Math.max(max[0], leftMax + rightMax + node.val);

        return node.val + Math.max(leftMax, rightMax);
    }
}

package com.app.google.striverA2ZDSASheet.binarytree.medium;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(TreeNode root) {

        return maxHeight(root) != -1;
    }

    private static int maxHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = maxHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = maxHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

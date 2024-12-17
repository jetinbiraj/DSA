package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class CountCompleteTreeNodes {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));

        System.out.println(countNodes(root));
    }

    private static int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root, 0);

        if (leftHeight == getRightHeight(root, 0)) {
            return (int) Math.pow(2, leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int getLeftHeight(TreeNode node, int height) {
        return node == null ? height : getLeftHeight(node.left, ++height);
    }

    private static int getRightHeight(TreeNode node, int height) {
        return node == null ? height : getRightHeight(node.right, ++height);
    }
}

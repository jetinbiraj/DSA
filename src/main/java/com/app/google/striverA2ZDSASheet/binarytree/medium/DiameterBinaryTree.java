package com.app.google.striverA2ZDSASheet.binarytree.medium;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class DiameterBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

        System.out.println(diameterOfBinaryTree(root));
    }

    private static int diameterOfBinaryTree(TreeNode root) {

        int[] arr = {0};
        traverse(root, arr);

        return arr[0];
    }

    private static int traverse(TreeNode node, int[] arr) {
        if (node == null) {
            return 0;
        }

        int leftHeight = traverse(node.left, arr);
        int rightHeight = traverse(node.right, arr);

        arr[0] = Math.max(arr[0], leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

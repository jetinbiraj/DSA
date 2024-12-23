package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

public class DeleteNode {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));

        int key = 3;

        System.out.println(deleteNode(root, key).val);
    }

    private static TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return insertNode(root.left, root.right);
        }

        TreeNode current = root;
        TreeNode prev = current;

        while (current != null && current.val != key) {

            prev = current;
            if (current.val < key) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (prev.left != null && prev.left.val == key) {
            prev.left = insertNode(prev.left.left, prev.left.right);
        } else if (prev.right != null && prev.right.val == key) {
            prev.right = insertNode(prev.right.left, prev.right.right);
        }

        return root;
    }

    private static TreeNode insertNode(TreeNode root, TreeNode node) {

        if (root == null) {
            return node;
        }

        if (node == null) {
            return root;
        }

        TreeNode current = root;

        while (current.right != null) {
            current = current.right;
        }

        current.right = node;
        return root;
    }
}

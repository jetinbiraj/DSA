package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

public class InsertIntoBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));

        int val = 5;

        System.out.println(insertIntoBST(root, val).val);
    }

    private static TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;
        TreeNode prev = current;

        while (current != null) {

            prev = current;

            if (current.val < val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (prev.val < val) {
            prev.right = new TreeNode(val);
        } else {
            prev.left = new TreeNode(val);
        }

        return root;
    }
}

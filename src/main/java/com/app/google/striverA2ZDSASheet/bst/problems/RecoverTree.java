package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

public class RecoverTree {

    private static TreeNode first;
    private static TreeNode prev;
    private static TreeNode middle;
    private static TreeNode last;

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);

        recoverTree(root);
        System.out.println("over");
    }

    private static void recoverTree(TreeNode root) {

        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        if (last != null) {
            int temp = middle.val;
            middle.val = last.val;
            last.val = temp;
        } else {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (node.val < prev.val) {

            if (first == null) {
                first = prev;
                middle = node;
            } else {
                last = node;
            }
        }

        prev = node;

        inorder(node.right);
    }
}

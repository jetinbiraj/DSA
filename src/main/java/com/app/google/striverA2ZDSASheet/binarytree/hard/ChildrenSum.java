package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class ChildrenSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1, null, new TreeNode(3))));

        System.out.println(isSumProperty(root));
    }

    private static void convertChildrenSum(TreeNode node) {
        //TODO: Learn more about the solution => https://www.youtube.com/watch?v=fnmisPM6cVo&ab_channel=takeUforward
        if (node == null) {
            return;
        }

        int child = 0;

        child += node.left != null ? node.left.val : 0;
        child += node.right != null ? node.right.val : 0;

        if (child >= node.val) {

            node.val = child;

        } else {

            if (node.left != null) {
                node.left.val = node.val;
            }

            if (node.right != null) {
                node.right.val = node.val;
            }
        }

        convertChildrenSum(node.left);
        convertChildrenSum(node.right);

        int total = 0;

        if (node.left != null) {
            total += node.left.val;
        }

        if (node.right != null) {
            total += node.right.val;
        }

        if (node.left != null || node.right != null) {
            node.val = total;
        }
    }

    private static int isSumProperty(TreeNode root) {

        return traverse(root);
    }

    private static int traverse(TreeNode node) {

        if (node == null || node.left == null && node.right == null) {
            return 1;
        }

        int num = node.val;

        num -= node.left != null ? node.left.val : 0;
        num -= node.right != null ? node.right.val : 0;

        if (num != 0 || traverse(node.left) == 0 || traverse(node.right) == 0) {
            return 0;
        }

        return 1;
    }
}

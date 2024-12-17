package com.app.google.striverA2ZDSASheet.binarytree.medium;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class SameTree {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println(isSameTree(p, q));
        System.out.println(cleanIsSameTree(p, q));
    }

    private static boolean cleanIsSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val && cleanIsSameTree(p.left, q.left) && cleanIsSameTree(p.right, q.right);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {

        return preorderTraverse(p, q);
    }

    private static boolean preorderTraverse(TreeNode pNode, TreeNode qNode) {

        if (pNode == null && qNode == null) {
            return true;
        } else if (pNode == null || qNode == null) {
            return false;
        }

        if (pNode.val != qNode.val) {
            return false;
        }

        if (!preorderTraverse(pNode.left, qNode.left)) {
            return false;
        }

        return preorderTraverse(pNode.right, qNode.right);
    }
}

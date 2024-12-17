package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode q = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3, p, q);

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    //TODO: add brute force solution

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return traverse(root, p, q);
    }

    private static TreeNode traverse(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null || node.val == p.val || node.val == q.val) {
            return node;
        }

        TreeNode left = traverse(node.left, p, q);
        TreeNode right = traverse(node.right, p, q);

        if (left != null && right != null) {
            return node;
        }

        return left != null ? left : right;
    }
}

package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        TreeNode q = new TreeNode(4, new TreeNode(3), new TreeNode(5));

        TreeNode p = new TreeNode(2, new TreeNode(0), q);

        TreeNode root = new TreeNode(6, p, new TreeNode(8, new TreeNode(7), new TreeNode(9)));

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node.val == p.val || node.val == q.val) {
            return node;
        }

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        if (node.val > min && node.val < max) {
            return node;
        }

        return node.val > max ? lowestCommonAncestor(node.left, p, q) : lowestCommonAncestor(node.right, p, q);
    }
}

package com.app.google.striverA2ZDSASheet.bst.concept;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

public class MinValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(3, new TreeNode(1), null), null), new TreeNode(6, null, new TreeNode(7)));

        System.out.println(minValue(root));
    }

    private static int minValue(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root.val;
    }
}

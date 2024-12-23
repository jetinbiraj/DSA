package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

public class CeilBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(4), new TreeNode(7, null, new TreeNode(8))), new TreeNode(11));

        int key = 6;

        System.out.println(findCeil(root, key));
    }

    private static int findCeil(TreeNode root, int key) {

        int ceil = -1;

        while (root != null) {

            if (root.val == key) {
                return key;
            }

            if (root.val > key) {
                ceil = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ceil;
    }
}

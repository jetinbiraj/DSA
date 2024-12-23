package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

public class FloorBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, null, new TreeNode(81, new TreeNode(42, null, new TreeNode(66, new TreeNode(45), null)), new TreeNode(87, null, new TreeNode(90))));
        int key = 46;

        System.out.println(floor(root, key));
    }

    private static int floor(TreeNode root, int key) {
        int floor = -1;

        while (root != null) {

            if (root.val == key) {
                return key;
            }

            if (root.val > key) {
                floor = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return floor;
    }
}

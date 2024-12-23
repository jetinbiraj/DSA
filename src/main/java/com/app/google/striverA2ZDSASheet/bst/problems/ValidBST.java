package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {

    private static Integer nodeValTracker = null;

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
//
//        System.out.println(bruteForceSsValidBST(root));

        TreeNode root = new TreeNode(0, new TreeNode(-1), null);

        System.out.println(optimalIsValidBST(root));
        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root) {
        return inorderTraverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean inorderTraverse(TreeNode node, long minVal, long maxVal) {

        if (node == null) {
            return true;
        }

        if (node.val <= minVal || node.val >= maxVal) {
            return false;
        }

        return inorderTraverse(node.left, minVal, node.val) && inorderTraverse(node.right, node.val, maxVal);
    }

    private static boolean optimalIsValidBST(TreeNode root) {

        if (root.left == null && root.right == null) {
            return true;
        }

        return inorderTraverse(root);
    }

    private static boolean inorderTraverse(TreeNode node) {

        if (node == null) {
            return true;
        }

        if (!inorderTraverse(node.left) || (nodeValTracker != null && nodeValTracker >= node.val)) {
            return false;
        }

        nodeValTracker = node.val;

        return inorderTraverse(node.right);
    }

    private static boolean bruteForceSsValidBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        inorderTraverse(root, list);

        int n = list.size();

        for (int i = 1; i < n; i++) {

            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }

        return true;
    }

    private static void inorderTraverse(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        inorderTraverse(node.left, list);
        list.add(node.val);
        inorderTraverse(node.right, list);
    }
}

package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

public class KthSmallest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));

        int k = 3;

        System.out.println(kthSmallest(root, k));
    }

    private static int kthSmallest(TreeNode root, int k) {

        int[] kthSmallest = new int[1];
        int[] counter = new int[1];

        inorder(root, counter, kthSmallest, k);

        return kthSmallest[0];
    }

    private static void inorder(TreeNode node, int[] counter, int[] kthSmallest, int k) {

        if (node == null || counter[0] > k) {
            return;
        }

        inorder(node.left, counter, kthSmallest, k);

        counter[0]++;

        if (counter[0] == k) {
            kthSmallest[0] = node.val;
            return;
        }

        inorder(node.right, counter, kthSmallest, k);
    }
}

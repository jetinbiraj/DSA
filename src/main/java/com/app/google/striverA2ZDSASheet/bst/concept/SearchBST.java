package com.app.google.striverA2ZDSASheet.bst.concept;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

public class SearchBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        int val = 2;
        TreeNode ansNode = searchBST(root, val);
        TreeNode ansNode1 = conciseSearchBST(root, val);
        if (ansNode != null) {
            System.out.println(ansNode.val);
            System.out.println(ansNode1.val);
        } else {
            System.out.println("null");
            System.out.println("null");
        }
    }

    private static TreeNode conciseSearchBST(TreeNode root, int val) {

        while (root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }

        return root;
    }


    private static TreeNode searchBST(TreeNode root, int val) {

        TreeNode current = root;

        while (current != null) {

            if (current.val == val) {
                return current;
            } else if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }
}

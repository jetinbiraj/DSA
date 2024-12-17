package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Flatten {

    private static TreeNode prevNode = null;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));

        betterFlatten(root);
        optimalFlatten(root);
        FlattenUsingMorrisTraversal(root);

        System.out.println(root.val);
    }

    private static void optimalFlatten(TreeNode node) {

        if (node == null) {
            return;
        }

        optimalFlatten(node.right);
        optimalFlatten(node.left);

        node.right = prevNode;
        node.left = null;
        prevNode = node;
    }

    private static void FlattenUsingMorrisTraversal(TreeNode root) {

        TreeNode current = root;

        while (current != null) {

            if (current.left != null) {
                TreeNode prev = current.left;

                while (prev.right != null) {
                    prev = prev.right;
                }

                prev.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }

    private static void betterFlatten(TreeNode root) {

        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pollLast();

            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }

            node.right = stack.peekLast();
            node.left = null;
        }
    }
}

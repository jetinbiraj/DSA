package com.app.google.striverA2ZDSASheet.binarytree.traversals;

import java.util.*;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class PreorderTraversal {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        System.out.println(recursivePreorderTraversal(root));
        System.out.println(iterativePreorderTraversal(root));
    }

    private static List<Integer> iterativePreorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.add(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }

    private static List<Integer> recursivePreorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        preorderTraversal(root, list);

        return list;
    }

    private static void preorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        preorderTraversal(node.left, list);

        preorderTraversal(node.right, list);
    }
}

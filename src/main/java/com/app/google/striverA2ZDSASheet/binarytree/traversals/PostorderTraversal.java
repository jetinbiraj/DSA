package com.app.google.striverA2ZDSASheet.binarytree.traversals;

import java.util.*;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class PostorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        System.out.println(recursivePostorderTraversal(root));
        System.out.println(iterativePostorderTraversal(root));
    }

    private static List<Integer> iterativePostorderTraversal(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            list.addFirst(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return list;
    }

    private static List<Integer> recursivePostorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        postorderTraversal(root, list);

        return list;
    }

    private static void postorderTraversal(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        postorderTraversal(node.left, list);

        postorderTraversal(node.right, list);

        list.add(node.val);
    }
}

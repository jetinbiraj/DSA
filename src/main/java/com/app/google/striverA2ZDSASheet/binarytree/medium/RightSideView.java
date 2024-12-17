package com.app.google.striverA2ZDSASheet.binarytree.medium;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));

        System.out.println(rightSideView(root));
        System.out.println(betterRightSideView(root));
    }

    private static List<Integer> betterRightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        traverse(list, root, 0);

        return list;
    }

    private static void traverse(List<Integer> list, TreeNode node, int level) {

        if (list.size() == level) {
            list.add(node.val);
        }

        if (node.right != null) {
            traverse(list, node.right, level + 1);
        }

        if (node.left != null) {
            traverse(list, node.left, level + 1);
        }
    }

    private static List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            TreeNode node = null;

            for (int i = 0; i < size; i++) {

                node = queue.pollFirst();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            list.add(node.val);
        }

        return list;
    }
}

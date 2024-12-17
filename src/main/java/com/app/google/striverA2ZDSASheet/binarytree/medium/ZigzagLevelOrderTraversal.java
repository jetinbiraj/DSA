package com.app.google.striverA2ZDSASheet.binarytree.medium;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.*;

public class ZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println(bruteForceZigzagLevelOrder(root));
        System.out.println(betterZigzagLevelOrder(root));
    }

    private static List<List<Integer>> betterZigzagLevelOrder(TreeNode root) {

        List<List<Integer>> collection = new ArrayList<>();

        if (root == null) {
            return collection;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.add(root);
        boolean isRight = false;

        while (!deque.isEmpty()) {

            int size = deque.size();

            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = deque.pollFirst();
                if (isRight) {
                    list.addFirst(node.val);
                } else {
                    list.add(node.val);
                }

                if (node.left != null) {
                    deque.add(node.left);
                }

                if (node.right != null) {
                    deque.add(node.right);
                }
            }

            collection.add(list);

            isRight = !isRight;
        }

        return collection;
    }

    private static List<List<Integer>> bruteForceZigzagLevelOrder(TreeNode root) {

        List<List<Integer>> collection = new ArrayList<>();

        if (root == null) {
            return collection;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.add(root);
        boolean isRight = false;

        while (!deque.isEmpty()) {

            int size = deque.size();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = deque.pollFirst();
                list.add(node.val);

                if (node.left != null) {
                    deque.add(node.left);
                }

                if (node.right != null) {
                    deque.add(node.right);
                }
            }

            if (isRight) {
                Collections.reverse(list);
            }

            collection.add(list);

            isRight = !isRight;
        }

        return collection;
    }
}

package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.Pair;
import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxWidthBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null), new TreeNode(2, null, new TreeNode(9, new TreeNode(7), null)));

        System.out.println(widthOfBinaryTree(root));
    }

    private static int widthOfBinaryTree(TreeNode root) {

        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();

        queue.add(new Pair<>(root, 1));

        int maxWidth = 0;

        while (!queue.isEmpty()) {

            int size = queue.size(), start = 0, end = 0, min = queue.peekFirst().getValue();

            for (int i = 0; i < size; i++) {

                Pair<TreeNode, Integer> pair = queue.pollFirst();
                TreeNode key = pair.getKey();
                int val = pair.getValue() - min;

                if (i == 0) {
                    start = val;
                } else if (i == size - 1) {
                    end = val;
                }

                if (key.left != null) {
                    queue.add(new Pair<>(key.left, val * 2));
                }

                if (key.right != null) {
                    queue.add(new Pair<>(key.right, val * 2 + 1));
                }
            }

            maxWidth = Math.max(maxWidth, end - start + 1);
        }

        return maxWidth;
    }
}

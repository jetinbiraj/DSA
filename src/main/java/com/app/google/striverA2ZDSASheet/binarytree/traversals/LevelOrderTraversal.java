package com.app.google.striverA2ZDSASheet.binarytree.traversals;

import java.util.ArrayDeque;
import java.util.ArrayList;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.Deque;
import java.util.List;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println(levelOrder(root));
        System.out.println(optimalLevelOrder(root));
    }

    private static List<List<Integer>> optimalLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        levelOrder(root, list, 0);

        return list;
    }

    private static void levelOrder(TreeNode node, List<List<Integer>> list, int level) {

        if (node == null) {
            return;
        }

        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(node.val);

        levelOrder(node.left, list, level + 1);
        levelOrder(node.right, list, level + 1);
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.push(root);

        while (!queue.isEmpty()) {

            List<Integer> sublist = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.pollFirst();

                sublist.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            list.add(sublist);
        }

        return list;
    }
}

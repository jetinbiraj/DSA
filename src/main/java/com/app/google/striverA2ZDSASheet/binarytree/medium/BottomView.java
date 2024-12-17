package com.app.google.striverA2ZDSASheet.binarytree.medium;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.TreeMap;

public class BottomView {

    private record Pair(TreeNode node, int col) {
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20, new TreeNode(8, new TreeNode(5), new TreeNode(3, new TreeNode(10),
                new TreeNode(14))), new TreeNode(22, new TreeNode(4), new TreeNode(25)));

        System.out.println(bottomView(root));
    }

    private static ArrayList<Integer> bottomView(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        Deque<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(root, 0));
        treeMap.put(0, root.val);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Pair pair = queue.pollFirst();

                treeMap.put(pair.col, pair.node.val);

                if (pair.node.left != null) {
                    queue.add(new Pair(pair.node.left, pair.col - 1));
                }

                if (pair.node.right != null) {
                    queue.add(new Pair(pair.node.right, pair.col + 1));
                }
            }
        }

        for (var entry : treeMap.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }
}

package com.app.google.striverA2ZDSASheet.binarytree.medium;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(3, new TreeNode(5), new TreeNode(7)));

        System.out.println(verticalTraversal(root));
    }

    private static List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> collection = new ArrayList<>();

        TreeMap<Integer, Map<Integer, List<Integer>>> treeMap = new TreeMap<>();

        inorderTraversal(root, treeMap, 0, 0);

        for (var colEntry : treeMap.entrySet()) {

            List<Integer> list = new ArrayList<>();

            for (var rowValues : colEntry.getValue().values()) {

                Collections.sort(rowValues);
                list.addAll(rowValues);
            }

            collection.add(list);
        }

        return collection;
    }

    private static void inorderTraversal(TreeNode node, TreeMap<Integer, Map<Integer, List<Integer>>> treeMap, int column, int row) {

        if (node == null) {
            return;
        }

        treeMap.computeIfAbsent(column, k -> new TreeMap<>()).computeIfAbsent(row, k -> new ArrayList<>()).add(node.val);

        inorderTraversal(node.left, treeMap, column - 1, row + 1);
        inorderTraversal(node.right, treeMap, column + 1, row + 1);
    }
}

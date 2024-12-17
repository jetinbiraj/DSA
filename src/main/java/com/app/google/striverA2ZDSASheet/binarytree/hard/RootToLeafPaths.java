package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class RootToLeafPaths {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10, new TreeNode(20, new TreeNode(40), new TreeNode(60)), new TreeNode(30));

        System.out.println(paths(root));
    }

    private static ArrayList<ArrayList<Integer>> paths(TreeNode root) {

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

        preorderTraverse(paths, new LinkedList<>(), root);

        return paths;
    }

    private static void preorderTraverse(ArrayList<ArrayList<Integer>> paths, LinkedList<Integer> path, TreeNode node) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            path.add(node.val);
            paths.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        path.add(node.val);
        preorderTraverse(paths, path, node.left);
        preorderTraverse(paths, path, node.right);
        path.removeLast();
    }
}

package com.app.google.striverA2ZDSASheet.binarytree.traversals;

import java.util.ArrayList;
import java.util.List;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class TreeTraversals {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(2)), new TreeNode(4, new TreeNode(7), new TreeNode(6)));

        System.out.println(getTreeTraversal(root));
    }

    private static List<List<Integer>> getTreeTraversal(TreeNode root) {

        List<List<Integer>> collection = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();

        inorderTraversal(root, inorderList);
        preorderTraversal(root, preorderList);
        postorderTraversal(root, postorderList);

        collection.add(inorderList);
        collection.add(preorderList);
        collection.add(postorderList);

        return collection;
    }

    private static void inorderTraversal(TreeNode node, List<Integer> inorderList) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, inorderList);
        inorderList.add(node.val);
        inorderTraversal(node.right, inorderList);
    }

    private static void preorderTraversal(TreeNode node, List<Integer> preorderList) {
        if (node == null) {
            return;
        }

        preorderList.add(node.val);
        preorderTraversal(node.left, preorderList);
        preorderTraversal(node.right, preorderList);
    }

    private static void postorderTraversal(TreeNode node, List<Integer> postorderList) {
        if (node == null) {
            return;
        }

        postorderTraversal(node.left, postorderList);
        postorderTraversal(node.right, postorderList);
        postorderList.add(node.val);
    }
}

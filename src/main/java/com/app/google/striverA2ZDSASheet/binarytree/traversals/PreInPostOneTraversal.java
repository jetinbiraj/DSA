package com.app.google.striverA2ZDSASheet.binarytree.traversals;

import java.util.ArrayList;
import java.util.List;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class PreInPostOneTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        System.out.println(oneTraversal(root));
    }

    private static List<List<Integer>> oneTraversal(TreeNode root) {

        List<List<Integer>> collection = new ArrayList<>();

        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();

        traverse(root, preorderList, inorderList, postorderList);

        collection.add(preorderList);
        collection.add(inorderList);
        collection.add(postorderList);

        return collection;
    }

    private static void traverse(TreeNode node, List<Integer> preorderList, List<Integer> inorderList, List<Integer> postorderList) {
        if (node == null) {
            return;
        }

        preorderList.add(node.val);
        traverse(node.left, preorderList, inorderList, postorderList);
        inorderList.add(node.val);
        traverse(node.right, preorderList, inorderList, postorderList);
        postorderList.add(node.val);
    }
}

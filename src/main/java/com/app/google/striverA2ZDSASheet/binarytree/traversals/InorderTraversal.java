package com.app.google.striverA2ZDSASheet.binarytree.traversals;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversal {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        System.out.println(recursiveInorderTraversal(root));
        System.out.println(iterativeInorderTraversal(root));
    }

    private static List<Integer> iterativeInorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode node = stack.pop();
            list.add(node.val);
            current = node.right;
        }

        return list;
    }

    private static List<Integer> recursiveInorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        inorderTraversal(root, list);

        return list;
    }

    private static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, list);

        list.add(node.val);

        inorderTraversal(node.right, list);
    }
}

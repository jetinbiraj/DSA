package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        System.out.println(preorderTraversal(root));
    }

    private static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        TreeNode currentNode = root;

        while (currentNode != null) {
            if (currentNode.left == null) {
                list.add(currentNode.val);
                currentNode = currentNode.right;
            } else {

                TreeNode prevNode = currentNode.left;
                while (prevNode.right != null && prevNode.right != currentNode) {
                    prevNode = prevNode.right;
                }

                if (prevNode.right == null) {
                    prevNode.right = currentNode;
                    list.add(currentNode.val);
                    currentNode = currentNode.left;
                } else {
                    prevNode.right = null;
                    currentNode = currentNode.right;
                }
            }
        }

        return list;
    }
}

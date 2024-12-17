package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BTFromInorderAndPostorderTraversal {

    private static int postIndex;

    public static void main(String[] args) {

        int[] postorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        System.out.println(buildTree(postorder, inorder).val);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postIndex, map);
    }

    private static TreeNode buildTree(int[] postorder, int inStart, int inEnd, Map<Integer, Integer> map) {

        if (postIndex < 0 || inStart > inEnd) {
            return null;
        }

        int currentNodeVal = postorder[postIndex--];

        TreeNode rightNode = buildTree(postorder, map.get(currentNodeVal) + 1, inEnd, map);
        TreeNode leftNode = buildTree(postorder, inStart, map.get(currentNodeVal) - 1, map);

        return new TreeNode(currentNodeVal, leftNode, rightNode);
    }
}

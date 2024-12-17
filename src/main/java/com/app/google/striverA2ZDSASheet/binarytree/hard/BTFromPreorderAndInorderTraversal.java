package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BTFromPreorderAndInorderTraversal {

    private static int preIndex = 0;

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        System.out.println(buildTree(preorder, inorder).val);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for (int num : inorder) {
            map.put(num, index++);
        }

        return traverse(preorder, 0, inorder.length - 1, map);
    }

    private static TreeNode traverse(int[] preorder, int inStartIndex, int inEndIndex,
                                     Map<Integer, Integer> map) {

        if (preIndex >= preorder.length || inStartIndex > inEndIndex) {
            return null;
        }

        int currentNodeVal = preorder[preIndex++];

        return new TreeNode(currentNodeVal, traverse(preorder, inStartIndex, map.get(currentNodeVal) - 1, map),
                traverse(preorder, map.get(currentNodeVal) + 1, inEndIndex, map));
    }
}

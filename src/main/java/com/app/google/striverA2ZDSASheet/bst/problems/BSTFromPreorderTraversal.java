package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BSTFromPreorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};

        System.out.println(betterBstFromPreorder(preorder).val);
        System.out.println(bruteForceBstFromPreorder(preorder).val);
        System.out.println(optimalBstFromPreorder(preorder).val);
    }

    private static TreeNode optimalBstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 1001, new int[]{0});
    }

    private static TreeNode bstFromPreorder(int[] preorder, int upperBound, int[] indexTracker) {

        if (indexTracker[0] >= preorder.length || preorder[indexTracker[0]] > upperBound) {
            return null;
        }

        int nodeNum = preorder[indexTracker[0]++];

        return new TreeNode(nodeNum, bstFromPreorder(preorder, nodeNum, indexTracker), bstFromPreorder(preorder, upperBound, indexTracker));
    }

    private static TreeNode betterBstFromPreorder(int[] preorder) {

        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {

            TreeNode current = root;
            TreeNode prev = current;
            int num = preorder[i];

            while (current != null) {
                prev = current;

                if (num > current.val) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            }

            if (num > prev.val) {
                prev.right = new TreeNode(num);
            } else {
                prev.left = new TreeNode(num);
            }
        }

        return root;
    }

    private static int preIndex = 0;

    private static TreeNode bruteForceBstFromPreorder(int[] preorder) {

        int[] inorder = Arrays.copyOf(preorder, preorder.length);

        Arrays.sort(inorder);

        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return constructBST(preorder, 0, preorder.length - 1, inorderIndexMap);
    }

    private static TreeNode constructBST(int[] preorder, int inStartIndex, int inEndIndex, Map<Integer, Integer> inorderIndexMap) {

        if (inStartIndex > inEndIndex || preIndex >= preorder.length) {
            return null;
        }

        int num = preorder[preIndex++];
        int numInorderIndex = inorderIndexMap.get(num);

        return new TreeNode(num, constructBST(preorder, inStartIndex, numInorderIndex - 1, inorderIndexMap),
                constructBST(preorder, numInorderIndex + 1, inEndIndex, inorderIndexMap));
    }
}

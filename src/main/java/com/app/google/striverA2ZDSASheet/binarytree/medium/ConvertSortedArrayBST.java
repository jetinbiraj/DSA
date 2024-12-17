package com.app.google.striverA2ZDSASheet.binarytree.medium;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

public class ConvertSortedArrayBST {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        System.out.println(sortedArrayToBST(nums).val);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {

        return putElement(nums, 0, nums.length - 1);
    }

    private static TreeNode putElement(int[] nums, int left, int right) {

        if (right < left) {
            return null;
        }

        int mid = (left + right) / 2;

        return new TreeNode(nums[mid], putElement(nums, left, mid - 1), putElement(nums, mid + 1, right));
    }
}

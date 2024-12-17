package com.app.google.striverA2ZDSASheet.binarytree.traversals;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CreateTree {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        TreeNode root0 = new TreeNode(list.getFirst());

        createTree(root0, list);
    }

    public static void createTree(TreeNode root0, List<Integer> v) {

        root0.left = new TreeNode(v.get(1));
        root0.right = new TreeNode(v.get(2));

        root0.left.left = new TreeNode(v.get(3));
        root0.left.right = new TreeNode(v.get(4));

        root0.right.left = new TreeNode(v.get(5));
        root0.right.right = new TreeNode(v.get(6));
    }
}

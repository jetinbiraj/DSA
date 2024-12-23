package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

    public static void main(String[] args) {

    }

    Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {

        TreeNode node = stack.pollLast();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }
}

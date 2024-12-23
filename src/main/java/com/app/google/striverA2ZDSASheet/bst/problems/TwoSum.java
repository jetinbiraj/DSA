package com.app.google.striverA2ZDSASheet.bst.problems;

import com.app.google.striverA2ZDSASheet.bst.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TwoSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        int k = 9;

        System.out.println(findTarget(root, k));
        System.out.println(betterFindTarget(root, k));
    }

    private static final Deque<TreeNode> nextStack = new ArrayDeque<>();
    private static final Deque<TreeNode> prevStack = new ArrayDeque<>();

    private static boolean betterFindTarget(TreeNode root, int k) {

        pushAllNext(root);
        pushAllPrev(root);

        while (!nextStack.isEmpty() && !prevStack.isEmpty()) {
            int next = nextStack.peekLast().val;;
            int prev = prevStack.peekLast().val;

            if (next == prev) {
                break;
            }

            int sum = next + prev;
            if (sum == k) {
                return true;
            } else if (sum > k) {
                getPrev();
            } else {
                getNext();
            }
        }

        return false;
    }

    private static void getNext() {
        TreeNode node = nextStack.pollLast();
        pushAllNext(node.right);
    }

    private static void getPrev() {
        TreeNode node = prevStack.pollLast();
        pushAllPrev(node.left);
    }

    private static void pushAllNext(TreeNode node) {
        while (node != null) {
            nextStack.add(node);
            node = node.left;
        }
    }

    private static void pushAllPrev(TreeNode node) {
        while (node != null) {
            prevStack.add(node);
            node = node.right;
        }
    }

    private static boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int num = list.get(left) + list.get(right);
            if (num == k) {
                return true;
            } else if (num > k) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    private static void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}

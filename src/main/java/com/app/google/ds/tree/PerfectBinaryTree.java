package com.app.google.ds.tree;

public class PerfectBinaryTree {

    static class Node {
        int key;
        Node left, right;
    }

    private static int depth(Node node) {

        int depth = 0;

        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    //Check if the tree is perfect binary
    private static boolean isPerfect(Node root, int depth, int level) {

        //Check if the tree is empty
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return (depth == level + 1);
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        return isPerfect(root.left, depth, level + 1) && isPerfect(root.right, depth, level + 1);

    }

    private static boolean isPerfect(Node node) {
        return isPerfect(node, depth(node), 0);
    }

    private static Node newNode(int k) {
        Node node = new Node();
        node.key = k;
        node.left = node.right = null;
        return node;
    }

    public static void main(String[] args) {

        Node root = newNode(1);

        root.left = newNode(2);
        root.right = newNode(3);

        root.left.left = newNode(4);
        root.left.right = newNode(5);

        root.right.left = newNode(6);
        root.right.right = newNode(7);

        if (isPerfect(root))
            System.out.println("The tree is a perfect binary tree");
        else
            System.out.println("The tree is not a perfect binary tree");
    }
}

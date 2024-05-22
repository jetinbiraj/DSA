package com.app.google.ds.tree;

//Not understand it well
public class BalancedBinaryTree {

    private Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Height {
        int height = 0;
    }

    private boolean checkHeightBalance(Node root, Height height) {

        if (root == null) {
            height.height = 0;
            return true;
        }

        Height lh = new Height();
        Height rh = new Height();

        boolean l = checkHeightBalance(root.left, lh);
        boolean r = checkHeightBalance(root.right, rh);

        int leftHeight = lh.height;
        int rightHeight = rh.height;

        height.height = (Math.max(leftHeight, rightHeight)) + 1;

        if ((leftHeight - rightHeight >= 2) || (rightHeight - leftHeight >= 2)) {
            return false;
        } else {
            return l && r;
        }

    }

    public static void main(String[] args) {

        Height height = new Height();

        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        if (tree.checkHeightBalance(tree.root, height)) {
            System.out.println("The tree is balanced");
        } else {
            System.out.println("The tree is not balanced");
        }
    }
}

package com.app.google.ds.tree;

/**
 * BinaryTree traversal inorder, preorder and postorder
 */
public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    static class Node {
        int item;
        Node left, right;

        public Node(int item) {
            this.item = item;
        }
    }

    private void postorder(Node node) {
        if (node == null) {
//            System.out.println("No tree hierarchy.!");
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.item + "->");

    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.item + "->");
        inorder(node.right);
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.item + "->");
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.root = new Node(1);
        bt.root.left = new Node(12);
        bt.root.right = new Node(9);
        bt.root.left.left = new Node(5);
        bt.root.left.right = new Node(6);

        System.out.println("Inorder traversal");
        bt.inorder(bt.root);

        System.out.println("\nPreorder traversal ");
        bt.preorder(bt.root);

        System.out.println("\nPostorder traversal");
        bt.postorder(bt.root);

    }
}

package com.app.google.ds.tree;

public class FullBinaryTree {

    private Node root;

    public FullBinaryTree(Node root) {
        this.root = root;
    }

    static class Node {
        int data;
        Node leftChild, rightChild;

        public Node(int data) {
            this.data = data;
        }
    }

    private boolean isFullBinaryTree(Node node) {

        //Checking tree emptiness
        if (node == null) {
            return true;
        }

        if (node.leftChild == null && node.rightChild == null) {
            return true;
        }

        if (node.leftChild != null && node.rightChild != null) {
            return isFullBinaryTree(node.leftChild) && isFullBinaryTree(node.rightChild);
        }

        return false;
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        FullBinaryTree fbt = new FullBinaryTree(root);

        fbt.root.leftChild = new Node(2);
        fbt.root.rightChild = new Node(3);

        fbt.root.leftChild.leftChild = new Node(4);
        fbt.root.leftChild.rightChild = new Node(5);
        fbt.root.rightChild.leftChild = new Node(6);
        fbt.root.rightChild.rightChild = new Node(7);


//        fbt.root.rightChild.rightChild.rightChild = new Node(8); This is to just get false for isFullBinaryTree

        if (fbt.isFullBinaryTree(root)) {
            System.out.println("The tree is full binary tree!");
        } else {
            System.out.println("The tree is not a full binary tree!");
        }
    }


}

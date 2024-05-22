package com.app.google.ds.tree;

// Not understand it well
public class CompleteBinaryTree {

    Node root;

    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    private int countNumNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return (1 + countNumNodes(root.left) + countNumNodes(root.right));
    }

    private boolean checkComplete(Node root, int index, int numberNodes) {
        //Check if the tree is empty
        if (root == null) {
            return true;
        }

        if (index >= numberNodes) {
            return false;
        }

        return (checkComplete(root.left, 2 * index + 1, numberNodes) &&
                checkComplete(root.right, 2 *index + 2, numberNodes));
    }

    public static void main(String[] args) {

        CompleteBinaryTree tree = new CompleteBinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(6);

        int node_count = tree.countNumNodes(tree.root);
        int index = 0;

        if (tree.checkComplete(tree.root, index, node_count))
            System.out.println("The tree is a complete binary tree");
        else
            System.out.println("The tree is not a complete binary tree");
    }

}

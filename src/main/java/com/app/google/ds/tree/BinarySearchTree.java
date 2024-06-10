package com.app.google.ds.tree;

public class BinarySearchTree {

    private Node root;

    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    private void insert(int key) {
        root = insertKey(root, key);
    }

    private Node insertKey(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insertKey(root.left, key);
        } else if (key > root.key) {
            root.right = insertKey(root.right, key);
        }

        return root;
    }

    private void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + "->");
            inorderRec(root.right);
        }
    }

    private void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    // More expert understanding required
    private Node deleteRec(Node root, int key) {

        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);

        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.key;

        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }

        return minValue;
    }


    // Driver Program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\n\nAfter deleting 10");
        tree.deleteKey(3);
        System.out.print("Inorder traversal: ");
        tree.inorder();
    }
}

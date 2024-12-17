package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserialize {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));

        TreeNode ds = deserialize(serialize(root));
        TreeNode betterDs = betterDeserialize(betterSerialize(root));

        System.out.println(ds.val);
        System.out.println(betterDs.val);
    }

    private static String betterSerialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder serialized = new StringBuilder();

        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.pollFirst();
            if (node == null) {
                serialized.append("#,");
                continue;
            }

            serialized.append(node.val).append(",");
            queue.add(node.left);
            queue.add(node.right);
        }

        return serialized.toString();
    }

    private static TreeNode betterDeserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] entries = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(entries[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        for (int i = 1; i < entries.length; i++) {

            TreeNode node = queue.pollFirst();
            if (!entries[i].equals("#")) {
                TreeNode newNode = new TreeNode(Integer.parseInt(entries[i]));
                node.left = newNode;
                queue.add(newNode);
            }

            if (!entries[++i].equals("#")) {
                TreeNode newNode = new TreeNode(Integer.parseInt(entries[i]));
                node.right = newNode;
                queue.add(newNode);
            }
        }

        return root;
    }

    private static String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder serialized = new StringBuilder();

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        serialized.append(root.val).append(",");

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.pollFirst();

                if (node.left != null) {
                    queue.add(node.left);
                    serialized.append(node.left.val).append(",");
                } else {
                    serialized.append("#,");
                }

                if (node.right != null) {
                    queue.add(node.right);
                    serialized.append(node.right.val).append(",");
                } else {
                    serialized.append("#,");
                }
            }
        }

        return serialized.toString();
    }

    private static TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] entries = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(entries[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        int index = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.pollFirst();
                String entry1 = entries[index++];
                if (!entry1.equals("#")) {
                    TreeNode newNode = new TreeNode(Integer.parseInt(entry1));
                    node.left = newNode;
                    queue.add(newNode);
                }

                String entry2 = entries[index++];
                if (!entry2.equals("#")) {
                    TreeNode newNode = new TreeNode(Integer.parseInt(entry2));
                    node.right = newNode;
                    queue.add(newNode);
                }
            }
        }

        return root;
    }
}

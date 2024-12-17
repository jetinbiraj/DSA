package com.app.google.striverA2ZDSASheet.binarytree.hard;

import com.app.google.striverA2ZDSASheet.binarytree.TreeNode;

import java.util.*;

public class DistanceK {

    public static void main(String[] args) {

        TreeNode target = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));

        TreeNode root = new TreeNode(3, target, new TreeNode(1, new TreeNode(0), new TreeNode(8)));

        int k = 2;

        System.out.println(distanceK(root, target, k));
        System.out.println(dfsSDistanceK(root, target, k));
    }

    private static List<Integer> dfsSDistanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parentTrackerMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        recursiveMarkParents(root, null, parentTrackerMap);
        findK(target, ans, new HashSet<>(), parentTrackerMap, k);

        return ans;
    }

    private static void recursiveMarkParents(TreeNode node, TreeNode parentNode, Map<TreeNode, TreeNode> parentTrackerMap) {
        if (node == null) {
            return;
        }

        parentTrackerMap.put(node, parentNode);
        recursiveMarkParents(node.left, node, parentTrackerMap);
        recursiveMarkParents(node.right, node, parentTrackerMap);
    }

    private static void findK(TreeNode node, List<Integer> ans, HashSet<TreeNode> visited, Map<TreeNode, TreeNode> parentTrackerMap, int k) {
        if (node == null || visited.contains(node) || k < 0) {
            return;
        }

        if (k == 0) {
            ans.add(node.val);
            return;
        }
        visited.add(node);

        findK(parentTrackerMap.get(node), ans, visited, parentTrackerMap, k - 1);
        findK(node.left, ans, visited, parentTrackerMap, k - 1);
        findK(node.right, ans, visited, parentTrackerMap, k - 1);
    }

    private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Deque<TreeNode> deque = new ArrayDeque<>();

        Map<TreeNode, TreeNode> parentTrackerMap = new HashMap<>();

        markParents(root, deque, parentTrackerMap);

        int distance = 0;
        deque.add(target);
        Set<TreeNode> visitedNodes = new HashSet<>();

        while (!deque.isEmpty()) {

            int size = deque.size();
            if (distance == k) {
                break;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = deque.pollFirst();

                TreeNode parent = parentTrackerMap.get(node);
                TreeNode leftNode = node.left;
                TreeNode rightNode = node.right;

                visitedNodes.add(node);

                if (parent != null && !visitedNodes.contains(parent)) {
                    deque.add(parent);
                }

                if (leftNode != null && !visitedNodes.contains(leftNode)) {
                    deque.add(leftNode);
                }

                if (rightNode != null && !visitedNodes.contains(rightNode)) {
                    deque.add(rightNode);
                }
            }

            distance++;
        }

        return new ArrayList<>(deque.stream().map(e -> e.val).toList());
    }

    private static void markParents(TreeNode root, Deque<TreeNode> deque, Map<TreeNode, TreeNode> parentTrackerMap) {

        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = deque.pollFirst();

                if (node.left != null) {
                    deque.add(node.left);
                    parentTrackerMap.put(node.left, node);
                }

                if (node.right != null) {
                    deque.add(node.right);
                    parentTrackerMap.put(node.right, node);
                }
            }
        }
    }
}

package com.app.google.striverA2ZDSASheet.binarytree.traversals;

public class NodeCount {

    public static void main(String[] args) {

        int level = 5;

        System.out.println(countNodes(level));
    }

    private static int countNodes(int level) {
        return (int) Math.pow(2, level - 1);
    }
}

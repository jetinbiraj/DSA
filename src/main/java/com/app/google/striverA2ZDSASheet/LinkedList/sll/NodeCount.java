package com.app.google.striverA2ZDSASheet.LinkedList.sll;

public class NodeCount {

    public static void main(String[] args) {

        Node head = LinkedList.getLLFromArray(new int[]{1, 2, 3, 4, 5, 6});


        System.out.println(getCount(head));
    }

    private static int getCount(Node head) {

        Node currentNode = head;

        if (head == null) {
            return 0;
        }
        int nodeCount = 1;

        while (currentNode.getNext() != null) {
            nodeCount++;
            currentNode = currentNode.getNext();
        }

        return nodeCount;
    }
}

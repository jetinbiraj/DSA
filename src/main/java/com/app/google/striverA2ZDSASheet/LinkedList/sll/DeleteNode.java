package com.app.google.striverA2ZDSASheet.LinkedList.sll;

public class DeleteNode {

    public static void main(String[] args) {

        Node head = LinkedList.getLLFromArray(new int[]{4, 5, 1, 9});

        bruteForceDeleteNode(head.getNext());
        optimalDeleteNode(head.getNext());

        LinkedList.printLinkedList(head);
    }

    private static void optimalDeleteNode(Node node) {
        node.setData(node.getNext().getData());
        node.setNext(node.getNext().getNext());
    }

    private static void bruteForceDeleteNode(Node node) {

        Node currentNode = node;
        Node deleteNode = node;

        while (currentNode.getNext() != null) {
            currentNode.setData(currentNode.getNext().getData());
            deleteNode = currentNode;
            currentNode = currentNode.getNext();
        }

        deleteNode.setNext(null);
    }
}

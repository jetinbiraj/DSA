package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

public class MiddleNode {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = LinkedList.getLLFromArray(arr);

        LinkedList.printLinkedList(bruteForceMiddleNode(head));
        LinkedList.printLinkedList(optimalMiddleNode(head));
    }

    private static Node optimalMiddleNode(Node head) {

        Node current = head;
        Node middleNode = head;

        while (current != null && current.next != null) {

            middleNode = middleNode.next;

            current = current.next.next;
        }

        return middleNode;
    }

    private static Node bruteForceMiddleNode(Node head) {

        if (head.next == null) {
            return head;
        }

        int totalNodes = 1;

        Node current = head;

        while (current.next != null) {

            totalNodes++;
            current = current.next;
        }

        int middleNodeCount = (totalNodes / 2) + 1;

        int counter = 1;
        current = head;

        while (current.next != null) {

            if (counter++ == middleNodeCount) {
                break;
            }

            current = current.next;
        }

        return current;
    }
}

package com.app.google.striverA2ZDSASheet.LinkedList.sll;

public class InsertToLL {

    public static void main(String[] args) {


        Node head = LinkedList.getLLFromArray(new int[]{1, 2, 3, 4, 5, 6});

        LinkedList.printLinkedList(insertHead(head, 7));
        LinkedList.printLinkedList(insertTail(head, 7));
    }

    private static Node insertHead(Node head, int val) {

        Node newHead = new Node(val);

        newHead.setNext(head);

        return newHead;
    }

    private static Node insertTail(Node head, int num) {

        if (head == null) {
            return new Node(num);
        }

        Node currentNode = head;

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(new Node(num));

        return head;
    }
}

package com.app.google.ds.linkedlist;

public class LinkedList {

    private Node head;

    static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    private void insertAtBeginning(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        System.out.println("Inserted at the beginning");

    }

    private void insertAfter(Node currentNode, int value) {

        if (currentNode == null) {
            System.out.println("Current node cannot be null");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = currentNode.next;
        currentNode.next = newNode;

    }

    private void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node tr = head;

        while (tr.next != null) {
            tr = tr.next;
        }

        tr.next = newNode;
        System.out.println("Inserted at the end");
    }

    private void deleteNode(int position) { //{1,2,3,4,5}

        if (head == null) {
            return;
        }

        Node temp = head;

        if (position == 0) {
            head = temp.next;
        }

        for (int i = 1; i < position && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null){
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Element delete success");

    }

    private void printListForward() {

        Node tNode = head;

        while (tNode != null) {
            System.out.print(tNode.value + " ");
            tNode = tNode.next;
        }

    }

    public static void main(String[] args) {

        LinkedList sll = new LinkedList();

        Node head = new Node(1);

        sll.head = head;

        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.next = third;

        sll.printListForward();
    }


}

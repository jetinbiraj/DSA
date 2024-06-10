package com.app.google.ds.linkedlist;

public class CircularLinkedList {

    private Node head;

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private void insertElement(int value) {  // {1, 2, 3}

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        newNode.next = head;

        System.out.println("element inserted");

    }

    private void printList() {

        Node temp = head;

        if (temp == null) {
            System.out.println("Nothing to print");
            return;
        }

        do {
            System.out.print(temp.value + " ");
            temp = temp.next;
        } while (!temp.equals(head));
    }

    public static void main(String[] args) {

        CircularLinkedList cll = new CircularLinkedList();

        cll.insertElement(1);

        cll.insertElement(2);
        cll.insertElement(3);
        cll.insertElement(4);
        cll.insertElement(5);
        cll.insertElement(6);

        cll.printList();
    }
}

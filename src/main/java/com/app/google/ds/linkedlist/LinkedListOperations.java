package com.app.google.ds.linkedlist;

public class LinkedListOperations {

    Node head;

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    private void insertAtBeginning(int value) {

        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;
        System.out.println("Inserted at the beginning");
    }

    private void insertAfter(Node prevNode, int value) {

        if (prevNode == null) {
            System.out.println("prevNode cannot be null");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        System.out.println("New node inserted after prevNode value: " + prevNode.value);
    }

    private void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;

        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        System.out.println("Inserted at the end");
    }

    private void deleteNode(int position) { // {3, 2, 5, 1, 4}

        if (head == null) {
            return;
        }

        Node temp = head;

        if (position == 0) {
            head = temp.next;
        }

        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        // If the key is not present
        if (temp == null || temp.next == null) {
            return;
        }

        temp.next = temp.next.next;

        System.out.println("deleted node");
    }

    private boolean search(Node head, int key) {

        Node current = head;

        while (current.next != null) {

            if (current.value == key) {
                System.out.println("key found");
                return true;
            }
            current = current.next;
        }

        System.out.println("key not found");
        return false;

    }

    private void sortLinkedList(Node head) { // {3 2 5 1}
        /*
        {1 2 3 5}
         */

        Node current = head;

        Node index = null;
        int temp;

        if (head == null) {
            return;
        } else {

            while (current != null) {

                index = current.next;

                while (index != null) {

                    if (current.value > index.value) {
                        temp = current.value;

                        current.value = index.value;
                        index.value = temp;
                    }
                    index = index.next;
                }

                current = current.next;

            }
        }

        System.out.println("Linked list sorted!");
    }

    private void printList() {

        Node tNode = head;

        while (tNode != null) {
            System.out.print(tNode.value + " ");
            tNode = tNode.next;
        }
    }

    public static void main(String[] args) {

        LinkedListOperations list = new LinkedListOperations();

        list.insertAtEnd(1);
        list.printList();

        list.insertAtBeginning(2);
        list.printList();

        list.insertAtBeginning(3);
        list.printList();

        list.insertAtEnd(4);
        list.printList();

        list.insertAfter(list.head.next, 5);

        System.out.println("Linked list: ");
        list.printList();

        System.out.println("\nAfter deleting an element: ");
        list.deleteNode(4);
        list.printList();

        System.out.println();

        int item_to_find = 3;
        if (list.search(list.head, item_to_find)) {
            System.out.println(item_to_find + " is found");
        } else {
            System.out.println(item_to_find + " is not found");
        }

        list.sortLinkedList(list.head);
        System.out.println("\nSorted List: ");
        list.printList();
    }
}

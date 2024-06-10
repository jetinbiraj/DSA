package com.app.google.ds.linkedlist;

public class DoublyLinkedList {

    private Node head;

    static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    private void printListForward() {

        Node tNode = head;
        Node last = null;

        System.out.println("Printing in forward direction");
        while (tNode != null) {
            System.out.print(tNode.value + " ");
            last = tNode;
            tNode = tNode.next;
        }


        System.out.println("\nPrinting in reverse direction");
        while (last != null) {
            System.out.print(last.value + " ");
            last = last.prev;
        }


    }

    private void insertElement(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            System.out.println("Head inserted");
            return;
        }

        Node last = head;

        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;
        System.out.println("inserted at last");

    }

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insertElement(1);

        doublyLinkedList.insertElement(2);
        doublyLinkedList.insertElement(3);
        doublyLinkedList.insertElement(4);
        doublyLinkedList.insertElement(5);
        doublyLinkedList.insertElement(6);

        doublyLinkedList.printListForward();


    }


}

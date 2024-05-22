package com.app.google.ds.linkedlist;

public class DoublyCircularLinkedList {

    private Node head;

    static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    private void insertElement(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;
            Node current = head;

            while (temp.next != head) {
                temp = temp.next;
                current = temp;
            }

            temp.next = newNode;
            newNode.prev = current;
        }

        newNode.next = head;
        head.prev = newNode;
        System.out.println("Element inserted");
    }

    private void printListForward() {

        Node temp = head;
        Node last = head.prev;

        System.out.println("Printing elements in forward direction!");
        while (temp.next != head) {

            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.print(temp.value + " ");

        System.out.println("\nPrinting elements in backward direction!");
        while (last != head) {

            System.out.print(last.value + " ");
            last = last.prev;
        }

        System.out.print(last.value + " ");


    }

    public static void main(String[] args) {

        DoublyCircularLinkedList doublyLinkedList = new DoublyCircularLinkedList();

        doublyLinkedList.insertElement(1);

        doublyLinkedList.insertElement(2);
        doublyLinkedList.insertElement(3);
        doublyLinkedList.insertElement(4);
        doublyLinkedList.insertElement(5);
        doublyLinkedList.insertElement(6);

        doublyLinkedList.printListForward();
    }
}

package com.app.google.striverA2ZDSASheet.LinkedList.mediumDLL;

public class Node {
    public int data;
    public Node next;
    public Node back;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    public static Node dllFromArray(int[] arr) {

        Node head = new Node(arr[0]);

        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], null, prev);
            prev.next = newNode;
            prev = newNode;
        }

        return head;
    }

    public static void printDLL(Node head) {

        if (head == null) {
            System.out.println("Empty doubly linked list...");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(head.data).append(" ");

        Node current = head;

        while (current.next != null) {

            current = current.next;
            sb.append(current.data).append(" ");
        }

        System.out.println(sb);
    }
}

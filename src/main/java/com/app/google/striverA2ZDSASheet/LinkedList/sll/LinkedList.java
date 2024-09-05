package com.app.google.striverA2ZDSASheet.LinkedList.sll;

public class LinkedList {

    public static Node getLLFromArray(int[] arr) {

        Node head = new Node(arr[0]);

        Node tail = head;

        for (int i = 1; i < arr.length; i++) {

            Node newNode = new Node(arr[i]);
            tail.setNext(newNode);
            tail = newNode;
        }

        return head;
    }

    public static void printLinkedList(Node head) {
        StringBuilder sb = new StringBuilder();
        Node cuurentNode = head;
        if (cuurentNode.getNext() == null) {
            sb.append(cuurentNode.getData()).append(" ");
        }

        while (cuurentNode.getNext() != null) {
            sb.append(cuurentNode.getData()).append(" ");
            cuurentNode = cuurentNode.getNext();
        }
        sb.append(cuurentNode.getData()).append(" ");

        System.out.println(sb);
    }
}

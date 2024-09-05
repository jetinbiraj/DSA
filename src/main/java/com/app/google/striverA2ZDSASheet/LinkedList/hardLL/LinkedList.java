package com.app.google.striverA2ZDSASheet.LinkedList.hardLL;


public class LinkedList {

    public static Node getLLFromArray(int[] arr) {

        Node head = new Node(arr[0]);

        Node tail = head;

        for (int i = 1; i < arr.length; i++) {

            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            tail = newNode;
        }

        return head;
    }

    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node curentNode = head;
        if (curentNode.next == null) {
            sb.append(curentNode.data).append(" ");
            System.out.println(sb);
            return;
        }

        while (curentNode.next != null) {
            sb.append(curentNode.data).append(" ");
            curentNode = curentNode.next;
        }
        sb.append(curentNode.data).append(" ");

        System.out.println(sb);
    }
}

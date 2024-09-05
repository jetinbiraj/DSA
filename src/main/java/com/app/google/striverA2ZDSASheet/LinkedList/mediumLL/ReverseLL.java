package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

import java.util.Stack;

public class ReverseLL {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5}; // 1 -> 2 -> 3 -> 4 -> 5

        Node head = LinkedList.getLLFromArray(arr);

        LinkedList.printLinkedList(bruteForceReverseList(head));
        LinkedList.printLinkedList(optimalReverseList(head));
    }

    private static Node optimalReverseList(Node head) {

        Node current = head;
        Node prev = null;

        while (current != null) {

            Node next = current.next;
            current.next = prev;
            prev = current;

            current = next;
        }

        return prev;
    }

    private static Node bruteForceReverseList(Node head) {

        Stack<Integer> stack = new Stack<>();

        Node current = head;

        while (current.next != null) {
            stack.push(current.data);
            current = current.next;
        }
        stack.push(current.data);

        current = head;

        while (current.next != null) {
            current.data = stack.pop();
            current = current.next;
        }

        current.data = stack.pop();

        return head;
    }
}

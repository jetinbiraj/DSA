package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

import java.util.ArrayList;
import java.util.List;

public class OddEvenList {

    public static void main(String[] args) {

        int[] arr = {2, 1, 3, 5, 6, 4, 7};
        Node head = LinkedList.getLLFromArray(arr);

//        Node newHead = bruteForceOddEvenList(head);
        Node newHead = optimalOddEvenList(head);

        LinkedList.printLinkedList(newHead);
    }

    private static Node optimalOddEvenList(Node head) {

        if (head == null) {
            return null;
        }

        Node oddPointer = head;
        Node evenPointer = head.next;
        Node firstEvenPointer = evenPointer;

        while (evenPointer != null && evenPointer.next != null) {

            oddPointer.next = oddPointer.next.next;
            oddPointer = oddPointer.next;

            evenPointer.next = evenPointer.next.next;
            evenPointer = evenPointer.next;
        }

        oddPointer.next = firstEvenPointer;

        return head;
    }

    private static Node bruteForceOddEvenList(Node head) {

        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        Node current = head;
        int counter = 1;

        while (current != null) {
            if (counter++ % 2 == 0) {
                evenList.add(current.data);
            } else {
                oddList.add(current.data);
            }
            current = current.next;
        }

        current = head;

        for (int num : oddList) {
            current.data = num;
            current = current.next;
        }

        for (int num : evenList) {
            current.data = num;
            current = current.next;
        }

        return head;
    }
}

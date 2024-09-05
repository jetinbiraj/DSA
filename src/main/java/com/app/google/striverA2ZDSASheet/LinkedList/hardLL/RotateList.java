package com.app.google.striverA2ZDSASheet.LinkedList.hardLL;

public class RotateList {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        Node head = LinkedList.getLLFromArray(arr);
        int k = 2;

//        Node neaHead = bruteForceRotateRight(head, k);
        Node neaHead = betterForceRotateRight(head, k);

        LinkedList.printLinkedList(neaHead);
    }

    private static Node betterForceRotateRight(Node head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int count = 1;
        Node current = head;

        while (current.next != null) {
            current = current.next;
            count++;
        }
        current.next = head;

        k = k % count;
        k = count - k;

        while (k-- > 0) {
            current = current.next;
        }
        head = current.next;
        current.next = null;
        return head;

//        current = head;
//        int newCount = 1;
//
//        while (newCount < count) {
//            current = current.next;
//            newCount++;
//        }
//        Node nextHead = current.next;
//        current.next = null;
//
//        return nextHead;


//        Node fast = head;
//        for (int i = 1; i <= k; i++) {
//            fast = fast.next;
//        }
//        Node slow = head;
//        while (fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        Node nextHead = slow.next;
//        slow.next = null;
//        fast.next = head;
//
//        return nextHead;
    }


    private static Node bruteForceRotateRight(Node head, int k) {

        if (head == null) {
            return head;
        }

        int count = 0;
        Node current = head;

        while (current != null) {
            current = current.next;
            count++;
        }

        k = k % count;

        while (k-- > 0) {
            head = rotateRight(head);
        }

        return head;
    }

    private static Node rotateRight(Node head) {

        Node current = head;
        Node prev = head;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        prev.next = null;
        current.next = head;
        return current;
    }
}

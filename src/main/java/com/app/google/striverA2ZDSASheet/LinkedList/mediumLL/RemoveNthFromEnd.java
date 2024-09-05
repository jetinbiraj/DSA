package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

public class RemoveNthFromEnd {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        Node head = LinkedList.getLLFromArray(arr);

//        Node newHead = bruteForceRemoveNthFromEnd(head, 2);
        Node newHead = optimalRemoveNthFromEnd(head, 2);

        LinkedList.printLinkedList(newHead);
    }

    private static Node optimalRemoveNthFromEnd(Node head, int n) {
        
        if (head == null) {
            return null;
        }
        Node fast = head, slow = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    private static Node bruteForceRemoveNthFromEnd(Node head, int n) {

        int nodeCount = 1;
        Node current = head;

        while (current.next != null) {
            current = current.next;
            nodeCount++;
        }

        if (nodeCount == 1 && n == 1) {
            return null;
        } else if (nodeCount == n) {
            return head.next;
        } else {

            current = head;

            while (current.next != null) {
                if (--nodeCount == n) {
                    current.next = current.next.next;
                    return head;
                }
                current = current.next;
            }
        }

        return head;
    }
}

package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

public class DeleteMiddle {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 7, 1, 2, 6};
        Node head = LinkedList.getLLFromArray(arr);

//        Node newHead = bruteForceDeleteMiddle(head);
        Node newHead = optimalDeleteMiddle(head);

        LinkedList.printLinkedList(newHead);

    }

    private static Node optimalDeleteMiddle(Node head) {

        Node fast = head, slow = head, prev = head;

        if (fast.next == null) {
            return null;
        }

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = prev.next != null ? prev.next.next : null;

        return head;
    }


    private static Node bruteForceDeleteMiddle(Node head) {

        int nodeCount = 1;

        Node current = head;

        while (current.next != null) {
            nodeCount++;
            current = current.next;
        }

        nodeCount /= 2;
        current = head;
        nodeCount -= 1;

        while (current.next != null) {

            if (nodeCount-- == 0) {
                break;
            }
            current = current.next;
        }
        current.next = current.next != null ? current.next.next : null;

        return head;
    }
}

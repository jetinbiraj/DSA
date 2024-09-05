package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

import java.util.HashSet;
import java.util.Set;

public class LoopStart {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = LinkedList.getLLFromArray(arr);

        makeCycle(head.next.next);
    }

    private static Node optimalDetectCycle(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast.equals(slow)) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    private static Node bruteForceDetectCycle(Node head) {

        if (head == null) {
            return null;
        }

        Node current = head;
        Set<Node> set = new HashSet<>();

        while (current.next != null) {
            if (set.contains(current)) {
                return current;
            }

            set.add(current);
            current = current.next;
        }
        return null;
    }

    private static void makeCycle(Node node) {

        Node current = node;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }
}

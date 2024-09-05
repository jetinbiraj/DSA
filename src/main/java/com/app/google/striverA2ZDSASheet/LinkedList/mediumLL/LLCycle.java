package com.app.google.striverA2ZDSASheet.LinkedList.mediumLL;

import java.util.HashSet;
import java.util.Set;

public class LLCycle {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = LinkedList.getLLFromArray(arr);

        makeCycle(head.next.next);

        System.out.println(bruteForceHasCycle(head));
        System.out.println(optimalHasCycle(head));
    }

    private static boolean optimalHasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

            if (slow.equals(fast)) {
                return true;
            }
        }

        return false;
    }

    private static boolean bruteForceHasCycle(Node head) {

        if (head == null) {
            return false;
        }

        Node current = head;
        Set<Node> set = new HashSet<>();

        while (current.next != null) {
            if (set.contains(current)) {
                return true;
            }

            set.add(current);
            current = current.next;
        }
        return false;
    }


    private static void makeCycle(Node node) {

        Node current = node;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }
}
